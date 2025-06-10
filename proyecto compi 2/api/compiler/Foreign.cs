using analyzer;

public class ForeignFunction : Invocable 
{
    private Environment closure;
    private LanguageParser.FuncDclContext? context;
    private Func<List<ValueWrapper>, CompilerVisitor, ValueWrapper>? nativeFunction; 

    public ForeignFunction(Environment closure, LanguageParser.FuncDclContext context)
    {
        this.closure = closure;
        this.context = context;
        this.nativeFunction = null;
    }


    public ForeignFunction(Func<List<ValueWrapper>, CompilerVisitor, ValueWrapper> nativeFunction)
    {
        this.closure = null;
        this.context = null;
        this.nativeFunction = nativeFunction;
    }
    public ForeignFunction(Invocable invocable)
    {
        this.closure = null;
        this.context = null;
        this.nativeFunction = invocable.Invoke;
    }

    public int Arity()
    {
        if (nativeFunction != null)
        {
            return -1;
        }
        if (context?.@params() == null)
        {
            return 0;
        }
        return context.@params().ID().Length;
    }

    public ValueWrapper Invoke(List<ValueWrapper> args, CompilerVisitor visitor)
{
    if (nativeFunction != null)
    {
        return nativeFunction(args, visitor); 
    }

    if (closure == null || context == null)
    {
        throw new SemanticError("Función inválida o no inicializada correctamente.", null);
    }

    var newEnv = new Environment(closure);
    var beforeCallEnv = visitor.currentEnvironment;
    visitor.currentEnvironment = newEnv;

    if (context.@params() != null)
    {
        for (int i = 0; i < context.@params().ID().Length; i++)
        {
            string paramName = context.@params().ID(i).GetText();
            string paramType = context.@params().TIPOS(i).GetText();
            ValueWrapper argValue = args[i];

            if (!IsCompatibleType(paramType, argValue))
            {
                throw new SemanticError($"Tipo de parámetro incorrecto en la posición {i + 1}. Se esperaba {paramType} pero se recibió {argValue.GetType().Name}.", context.Start);
            }

            newEnv.Declare(paramName, argValue, paramType, context.Start);
        }
    }

    try
    {
        foreach (var stmt in context.dcl())
        {
            visitor.Visit(stmt);
        }
    }
    catch (ReturnException e)
    {
        visitor.currentEnvironment = beforeCallEnv;
        return e.Value;
    }

    visitor.currentEnvironment = beforeCallEnv;
    return visitor.defaultVoid;
}



private bool IsCompatibleType(string expectedType, ValueWrapper value)
{
    return expectedType switch
    {
        "int" => value is IntValue,
        "float64" => value is FloatValue || value is IntValue,
        "string" => value is StringValue,
        "bool" => value is BoolValue,
        "rune" => value is IntValue,
        _ => false
    };
}


   public ForeignFunction Bind(Instance instance)
{
    if (nativeFunction != null)
    {
        return new ForeignFunction(nativeFunction); 
    }

    var hiddenEnv = new Environment(closure);
    hiddenEnv.Declare("this", new InstanceValue(instance), null, null);
    return new ForeignFunction(hiddenEnv, context);
}

}
