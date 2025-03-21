using analyzer;

public class ForeignFunction : Invocable 
{
    private Environment clousure;
    private LanguageParser.FuncDclContext context;
    
    public ForeignFunction(Environment clousure, LanguageParser.FuncDclContext context)
    {
        this.clousure = clousure;
        this.context = context;
    }
    public int Arity()
    {
        if(context.@params()==null)
        {
            return 0;
        }
        return context.@params().ID().Length;
    }

    public ValueWrapper Invoke(List<ValueWrapper> args, CompilerVisitor visitor) {
        var newEnv = new Environment(clousure);
        var beforeCallEnv = visitor.currentEnvironment;
        visitor.currentEnvironment = newEnv;
        
        if(context.@params() != null){
            for (int i = 0; i<context.@params().ID().Length; i++)
            {
                newEnv.Declare(context.@params().ID(i).GetText(), args[i], null);
            }
        }
        try {
            foreach (var stmt in context.dcl()){
            visitor.Visit(stmt);
        }
        }catch (ReturnException e)
        {
            visitor.currentEnvironment = beforeCallEnv;
            return e.Value;
        }
        visitor.currentEnvironment = beforeCallEnv;
        return visitor.defaultVoid;
    }

    public ForeignFunction Bind(Instance instance){
        var hiddenEnv = new Environment(clousure);   
        hiddenEnv.Declare("this", new InstanceValue(instance), null);
        return new ForeignFunction(hiddenEnv, context);
        }
}