
using analyzer;
using System.Globalization;


public class CompilerVisitor : LanguageBaseVisitor<ValueWrapper>
{


    public ValueWrapper defaultVoid = new VoidValue();

    public string output = "";
    public Environment currentEnvironment;

    public CompilerVisitor()
    {
        currentEnvironment = new Environment(null);
        Embeded.Generate(currentEnvironment);
    }



    public override ValueWrapper VisitProgram(LanguageParser.ProgramContext context)
    {
        foreach (var dcl in context.dcl())
        {
            Visit(dcl);
        }
        return defaultVoid;
    }


    public override ValueWrapper VisitEVarDcl(LanguageParser.EVarDclContext context)
    {
        string id = context.ID().GetText();
        string type = context.TIPOS().GetText();
        ValueWrapper value;
        if(context.expr() != null){
            value = Visit(context.expr());
            ValidateType(type, value, out value, context.Start);
        }else{
            value = AsignarValorPorDefecto(type, context.Start);
        }
         
        currentEnvironment.Declare(id, value, type, context.Start);
        return defaultVoid;
    }

    public override ValueWrapper VisitIVarDcl(LanguageParser.IVarDclContext context){
        string id = context.ID().GetText();
        ValueWrapper value = Visit(context.expr());
        string tipoInferido = TipoInferido(value, context.Start);
        currentEnvironment.Declare(id, value, tipoInferido, context.Start);
        return defaultVoid;

    }
    private string TipoInferido(ValueWrapper value, Antlr4.Runtime.IToken token)
    {
        return value switch
        {
            IntValue => "int",
            FloatValue => "float64",
            StringValue => "string",
            BoolValue => "bool",
            _ => throw new SemanticError($"Cannot infer type for value: {value}", token)
        };
    }


    private ValueWrapper AsignarValorPorDefecto(string type, Antlr4.Runtime.IToken token)
    {
        return type switch
        {
            "int" => new IntValue(0),
            "float64" => new FloatValue(0.0f),
            "string" => new StringValue(""),
            "bool" => new BoolValue(false),
            "rune" => new IntValue(0), // Si "rune" es un alias de int, usar 0 como valor por defecto
            _ => throw new SemanticError($"Unknown type {type}", token)
        };
    }


    private void ValidateType(string expectedType, ValueWrapper value, out ValueWrapper outputValue, Antlr4.Runtime.IToken token)
    {
        bool isValid = expectedType switch
        {
            "int" => value is IntValue,
            "float64" => value is FloatValue || value is IntValue,
            "string" => value is StringValue,
            "bool" => value is BoolValue,
            "rune" => value is IntValue, // Podrías definir un tipo específico para Rune si es necesario
            _ => throw new SemanticError($"Unknown type {expectedType}", token)
        };
        

        if (!isValid)
        {
            throw new SemanticError($"Type mismatch: expected {expectedType}, got {value.GetType().Name}", token);
        }
        if (expectedType == "float64" && value is IntValue intValue)
        {
            outputValue = new FloatValue(intValue.Value); 
        }else{
            outputValue = value;
        }

    }

    public override ValueWrapper VisitExprStmt(LanguageParser.ExprStmtContext context)
    {
        return Visit(context.expr());
    }



    public override ValueWrapper VisitIdentifier(LanguageParser.IdentifierContext context)
    {
        string id = context.ID().GetText();
        return currentEnvironment.Get(id, context.Start);
    }

    public override ValueWrapper VisitParens(LanguageParser.ParensContext context)
    {
        return Visit(context.expr());
    }


    public override ValueWrapper VisitNegate(LanguageParser.NegateContext context)
    {
        ValueWrapper value = Visit(context.expr());
        return value switch
        {
            IntValue i => new IntValue(-i.Value),
            FloatValue f => new FloatValue(-f.Value),
            _ => throw new SemanticError("Invalid operation", context.Start)
        };
    }

    public override ValueWrapper VisitInt(LanguageParser.IntContext context)
    {
        return new IntValue(int.Parse(context.INT().GetText()));
    }


    public override ValueWrapper VisitMulDiv(LanguageParser.MulDivContext context)
    {
        ValueWrapper left = Visit(context.expr(0));
        ValueWrapper right = Visit(context.expr(1));
        var op = context.op.Text;

        if ((op == "/"||op=="%") && 
       ((right is IntValue intRight && intRight.Value == 0) ||
        (right is FloatValue floatRight && floatRight.Value == 0.0f))){
        throw new SemanticError("Todo bien en casa? ._. no se puede dividir entre 0", context.Start);
        }

        return (left, right, op) switch
        {
            (IntValue l, IntValue r, "*") => new IntValue(l.Value * r.Value),
            (IntValue l, IntValue r, "/") => new IntValue(l.Value / r.Value),
            (IntValue l, IntValue r, "%") => new IntValue(l.Value % r.Value),
            (FloatValue l, FloatValue r, "*") => new FloatValue(l.Value * r.Value),
            (FloatValue l, FloatValue r, "/") => new FloatValue(l.Value / r.Value),
            (IntValue l, FloatValue r, "*") => new FloatValue(l.Value * r.Value),
            (FloatValue l, IntValue r, "*") => new FloatValue(l.Value * r.Value),
            (IntValue l, FloatValue r, "/") => new FloatValue(l.Value / r.Value),
            (FloatValue l, IntValue r, "/") => new FloatValue(l.Value / r.Value),
            _ => throw new SemanticError("Invalid operation", context.Start)
        };

    }


    public override ValueWrapper VisitAddSub(LanguageParser.AddSubContext context)
    {
        ValueWrapper left = Visit(context.GetChild(0));
        ValueWrapper right = Visit(context.expr(1));
        var op = context.op.Text;

        return (left, right, op) switch
        {
            (IntValue l, IntValue r, "+") => new IntValue(l.Value + r.Value),
            (IntValue l, IntValue r, "-") => new IntValue(l.Value - r.Value),
            (FloatValue l, FloatValue r, "+") => new FloatValue(l.Value + r.Value),
            (FloatValue l, FloatValue r, "-") => new FloatValue(l.Value - r.Value),
            (StringValue l, StringValue r, "+") => new StringValue(l.Value + r.Value),
            (IntValue l, FloatValue r, "+") => new FloatValue(l.Value + r.Value),
            (FloatValue l, IntValue r, "+") => new FloatValue(l.Value + r.Value),
            (IntValue l, FloatValue r, "-") => new FloatValue(l.Value - r.Value),
            (FloatValue l, IntValue r, "-") => new FloatValue(l.Value - r.Value),
            _ => throw new SemanticError("Invalid operation", context.Start)
        };
    }

    public override ValueWrapper VisitAddSubAssign(LanguageParser.AddSubAssignContext context)
{
    if (context.expr(0) is not LanguageParser.IdentifierContext idContext)
    {
        throw new SemanticError("Left side of assignment must be a variable", context.Start);
    }

    string id = idContext.ID().GetText();
    ValueWrapper currentValue = currentEnvironment.Get(id, context.Start);
    ValueWrapper exprValue = Visit(context.expr(1));
    string op = context.op.Text; 

   
    ValueWrapper newValue = (currentValue, exprValue, op) switch
    {
        (IntValue l, IntValue r, "+=") => new IntValue(l.Value + r.Value),
        (IntValue l, IntValue r, "-=") => new IntValue(l.Value - r.Value),
        (FloatValue l, FloatValue r, "+=") => new FloatValue(l.Value + r.Value),
        (FloatValue l, FloatValue r, "-=") => new FloatValue(l.Value - r.Value),
        _ => throw new SemanticError($"Invalid operation {op} for types {currentValue.GetType().Name} and {exprValue.GetType().Name}", context.Start)
    };

    currentEnvironment.Assign(id, newValue, context.Start);
    return newValue;
}




    public override ValueWrapper VisitFloat(LanguageParser.FloatContext context)
    {
        string floatText = context.FLOAT().GetText();
        float value = float.Parse(floatText, CultureInfo.InvariantCulture); // Asegura que el punto decimal se interprete correctamente
        return new FloatValue(value);
    }


    public override ValueWrapper VisitRelational(LanguageParser.RelationalContext context)
    {
        ValueWrapper left = Visit(context.expr(0));
        ValueWrapper right = Visit(context.expr(1));
        var op = context.op.Text;

        return (left, right, op) switch
        {
            (IntValue l, IntValue r, "<") => new BoolValue(l.Value < r.Value),
            (IntValue l, IntValue r, "<=") => new BoolValue(l.Value <= r.Value),
            (IntValue l, IntValue r, ">") => new BoolValue(l.Value > r.Value),
            (IntValue l, IntValue r, ">=") => new BoolValue(l.Value >= r.Value),
            (FloatValue l, FloatValue r, "<") => new BoolValue(l.Value < r.Value),
            (FloatValue l, FloatValue r, "<=") => new BoolValue(l.Value <= r.Value),
            (FloatValue l, FloatValue r, ">") => new BoolValue(l.Value > r.Value),
            (FloatValue l, FloatValue r, ">=") => new BoolValue(l.Value >= r.Value),
            (IntValue l, FloatValue r, "<") => new BoolValue(l.Value < r.Value),
            (IntValue l, FloatValue r, "<=") => new BoolValue(l.Value <= r.Value),
            (IntValue l, FloatValue r, ">") => new BoolValue(l.Value > r.Value),
            (IntValue l, FloatValue r, ">=") => new BoolValue(l.Value >= r.Value),
            (FloatValue l, IntValue r, "<") => new BoolValue(l.Value < r.Value),
            (FloatValue l, IntValue r, "<=") => new BoolValue(l.Value <= r.Value),
            (FloatValue l, IntValue r, ">") => new BoolValue(l.Value > r.Value),
            (FloatValue l, IntValue r, ">=") => new BoolValue(l.Value >= r.Value),
            _ => throw new SemanticError("Invalid operation", context.Start)
        };
    }

    public override ValueWrapper VisitLogical(LanguageParser.LogicalContext context)
    {
        ValueWrapper left = Visit(context.expr(0));
        ValueWrapper right = Visit(context.expr(1));
        var op = context.op.Text;

        if (left is not BoolValue l || right is not BoolValue r)
        {
            throw new SemanticError($"Los operadores lógicos requieren valores booleanos, got {left.GetType().Name} and {right.GetType().Name}", context.Start);
        }

        return op switch
        {
            "&&" => new BoolValue(l.Value && r.Value),
            "||" => new BoolValue(l.Value || r.Value),
            _ => throw new SemanticError($"Unknown logical operator {op}", context.Start)
        };
    }

    public override ValueWrapper VisitNotExpr(LanguageParser.NotExprContext context)
    {
        ValueWrapper value = Visit(context.expr());

        if (value is not BoolValue b)
        {
            throw new SemanticError($"El operador '!' requiere un valor booleano, got {value.GetType().Name}", context.Start);
        }

        return new BoolValue(!b.Value);
    }

    public override ValueWrapper VisitAssign(LanguageParser.AssignContext context)
    {
        var asignee = context.expr(0);
        ValueWrapper value = Visit(context.expr(1));

        if(asignee is LanguageParser.IdentifierContext idContext) {
            string id = idContext.ID().GetText();
            currentEnvironment.Assign(id, value, context.Start);
            return defaultVoid;
        }else if(asignee is LanguageParser.CalleeContext calleContext){
        ValueWrapper callee = Visit(calleContext.expr());

        for (int i = 0; i < calleContext.call().Length; i++)
        {
            var action = calleContext.call(i);
            if(i== calleContext.call().Length-1){
                if(action is LanguageParser.GetContext propertyAccess){
                    if(callee is InstanceValue instanceValue)
                    {
                        var instance = instanceValue.instance;
                        var propertyName = propertyAccess.ID().GetText();
                        instance.Set(propertyName, value);
                    }else {
                        throw new SemanticError("Invalid property access", context.Start);
                    }
                }



                else if (action is LanguageParser.ArrayAccessContext arrayAccess){
                if (callee is InstanceValue instanceValue){
                    var index = Visit(arrayAccess.expr());
                    if(index is IntValue intValue){
                        instanceValue.instance.Set(intValue.Value.ToString(), value);
                    }else {
                        throw new SemanticError("Invalid array access", context.Start);
                    }
                }else{
                    throw new SemanticError("Invalid array access", context.Start);
                }
            }




            }else{
                throw new SemanticError("Invalid assign", context.Start);
            }
        
            


            if(action is LanguageParser.FuncCallContext funcall){
                if (callee is FunctionValue functionValue)
                {
                    callee = VisitCall(functionValue.invocable, funcall.args());
                }
                else
                {
                    throw new SemanticError("Invalid function call", context.Start);
                }
            }
            else if(action is LanguageParser.GetContext propertyAccess){
                if(callee is InstanceValue instanceValue)
                {
                    callee = instanceValue.instance.Get(propertyAccess.ID().GetText(), propertyAccess.Start);
                }else {
                    throw new SemanticError("Invalid property access", context.Start);
                }
            }



            else if (action is LanguageParser.ArrayAccessContext arrayAccess){
                if (callee is InstanceValue instanceValue){
                    var index = Visit(arrayAccess.expr());
                    if(index is IntValue intValue){
                        callee = instanceValue.instance.Get(intValue.Value.ToString(), arrayAccess.Start);
                    }else {
                        throw new SemanticError("Invalid array access", context.Start);
                    }
                }else{
                    throw new SemanticError("Invalid array access", context.Start);
                }
            } 
        }

        return callee;

        }else {
            throw new SemanticError("Invalid assign", context.Start);
        }
    }


    public override ValueWrapper VisitEquality(LanguageParser.EqualityContext context)
    {
        ValueWrapper left = Visit(context.expr(0));
        ValueWrapper right = Visit(context.expr(1));
        var op = context.op.Text;

        return (left, right, op) switch
        {
            (IntValue l, IntValue r, "==") => new BoolValue(l.Value == r.Value),
            (IntValue l, IntValue r, "!=") => new BoolValue(l.Value != r.Value),
            (FloatValue l, FloatValue r, "==") => new BoolValue(l.Value == r.Value),
            (FloatValue l, FloatValue r, "!=") => new BoolValue(l.Value != r.Value),
            (IntValue l, FloatValue r, "==") => new BoolValue(l.Value == r.Value),
            (FloatValue l, IntValue r, "!=") => new BoolValue(l.Value != r.Value),
            (FloatValue l, IntValue r, "==") => new BoolValue(l.Value == r.Value),
            (IntValue l, FloatValue r, "!=") => new BoolValue(l.Value != r.Value),
            (StringValue l, StringValue r, "==") => new BoolValue(l.Value == r.Value),
            (StringValue l, StringValue r, "!=") => new BoolValue(l.Value != r.Value),
            (BoolValue l, BoolValue r, "==") => new BoolValue(l.Value == r.Value),
            (BoolValue l, BoolValue r, "!=") => new BoolValue(l.Value != r.Value),
            (RuneValue l, RuneValue r, "!=") => new BoolValue(l.Value != r.Value),
            (RuneValue l, RuneValue r, "==") => new BoolValue(l.Value == r.Value),
            _ => throw new SemanticError("Invalid operation", context.Start)
        };
    }

    public override ValueWrapper VisitBoolean(LanguageParser.BooleanContext context)
    {
        return new BoolValue(bool.Parse(context.BOOL().GetText()));
    }


    public override ValueWrapper VisitString(LanguageParser.StringContext context)
    {
        string text = context.STRING().GetText().Trim('"');
        return new StringValue(text);
    }



    public override ValueWrapper VisitBlockStmt(LanguageParser.BlockStmtContext context)
    {
        Environment previousEnvironment = currentEnvironment;
        currentEnvironment = new Environment(currentEnvironment);

        foreach (var stmt in context.dcl())
        {
            Visit(stmt);
        }

        currentEnvironment = previousEnvironment;
        return defaultVoid;
    }

    public override ValueWrapper VisitIfStmt(LanguageParser.IfStmtContext context)
    {
        ValueWrapper condition = Visit(context.expr());

        if (condition is not BoolValue)
        {
            throw new SemanticError("Invalid condition", context.Start);
        }

        if ((condition as BoolValue).Value)
        {
            Visit(context.stmt(0));
        }
        else if (context.stmt().Length > 1)
        {
            Visit(context.stmt(1));
        }

        return defaultVoid;
    }

    public override ValueWrapper VisitWhileStmt(LanguageParser.WhileStmtContext context)
    {
        ValueWrapper condition = Visit(context.expr());

        if (condition is not BoolValue)
        {
            throw new SemanticError("Invalid condition", context.Start);
        }

        while ((condition as BoolValue).Value)
        {
            Visit(context.stmt());
            condition = Visit(context.expr());
        }

        return defaultVoid;
    }

    public override ValueWrapper VisitForStmt(LanguageParser.ForStmtContext context)
    {
        Environment previousEnvironment = currentEnvironment;
        currentEnvironment = new Environment(currentEnvironment);

        Visit(context.forInit());

        VisitForBody(context);

        currentEnvironment = previousEnvironment;
        return defaultVoid;
    }

    public void VisitForBody(LanguageParser.ForStmtContext context)
    {
        ValueWrapper condition = Visit(context.expr(0));

        var lastEnvironment = currentEnvironment;


        if (condition is not BoolValue)
        {
            throw new SemanticError("Invalid condition", context.Start);
        }


        try
        {
            while (condition is BoolValue boolCondition && boolCondition.Value)
            {
                Visit(context.stmt());
                Visit(context.expr(1));
                condition = Visit(context.expr(0));
            }
        }
        catch (BreakException)
        {
            currentEnvironment = lastEnvironment;
        }
        catch (ContinueException)
        {
            currentEnvironment = lastEnvironment;
            Visit(context.expr(1));
            VisitForBody(context);
        }

    }

    public override ValueWrapper VisitBreakStmt(LanguageParser.BreakStmtContext context)
    {
        throw new BreakException();
    }

    public override ValueWrapper VisitContinueStmt(LanguageParser.ContinueStmtContext context)
    {
        throw new ContinueException();
    }

    public override ValueWrapper VisitReturnStmt(LanguageParser.ReturnStmtContext context)
    {
        ValueWrapper value = defaultVoid;

        if (context.expr() != null)
        {
            value = Visit(context.expr());
        }


        throw new ReturnException(value);
    }

    public override ValueWrapper VisitCallee(LanguageParser.CalleeContext context)
    {
        ValueWrapper callee = Visit(context.expr());

        foreach (var action in context.call())
        {
            if(action is LanguageParser.FuncCallContext funcall){
                if (callee is FunctionValue functionValue)
                {
                    callee = VisitCall(functionValue.invocable, funcall.args());
                }
                else
                {
                    throw new SemanticError("Invalid function call", context.Start);
                }
            }
            else if(action is LanguageParser.GetContext propertyAccess){
                if(callee is InstanceValue instanceValue)
                {
                    callee = instanceValue.instance.Get(propertyAccess.ID().GetText(), propertyAccess.Start);
                }else {
                    throw new SemanticError("Invalid property access", context.Start);
                }
            }
            else if (action is LanguageParser.ArrayAccessContext arrayAccess){
                if (callee is InstanceValue instanceValue){
                    var index = Visit(arrayAccess.expr());
                    if(index is IntValue intValue){
                        callee = instanceValue.instance.Get(intValue.Value.ToString(), arrayAccess.Start);
                    }else {
                        throw new SemanticError("Invalid array access", context.Start);
                    }
                }else{
                    throw new SemanticError("Invalid array access", context.Start);
                }
            } 
        }

        return callee;
    }

    public ValueWrapper VisitCall(Invocable invocable, LanguageParser.ArgsContext context)
    {

        List<ValueWrapper> arguments = new List<ValueWrapper>();

        if (context != null)
        {
            foreach (var expr in context.expr())
            {
                arguments.Add(Visit(expr));
            }
        }

        return invocable.Invoke(arguments, this);

    }

    public override ValueWrapper VisitFuncDcl(LanguageParser.FuncDclContext context)
    {
        var foreign = new ForeignFunction(currentEnvironment, context);
        currentEnvironment.Declare(context.ID().GetText(), new FunctionValue(foreign, context.ID().GetText()), null, context.Start);

        return defaultVoid;
    }

    public override ValueWrapper VisitClassDcl(LanguageParser.ClassDclContext context){
        Dictionary<string, LanguageParser.VarDclContext> props = new Dictionary<string, LanguageParser.VarDclContext>();
        Dictionary<string, ForeignFunction> methods = new Dictionary<string, ForeignFunction>();

        foreach(var prop in context.classBody()){
            if (prop.varDcl() != null)
            {
                var vardcl = prop.varDcl();
                string id;
                if (vardcl is LanguageParser.EVarDclContext explicitVar){
                    id = explicitVar.ID().GetText();
                }else if (vardcl is LanguageParser.IVarDclContext inferredVar){
                    id = inferredVar.ID().GetText();
                }else{
                    throw new SemanticError("Unknown variable declaration type", vardcl.Start);
                }
                props.Add(id, vardcl);
            }else if (prop.funcDcl() != null){
                var funcDcl = prop.funcDcl();
                var foreignFunction = new ForeignFunction(currentEnvironment, funcDcl);
                methods.Add(funcDcl.ID().GetText(), foreignFunction);
            }

        }
        LanguageClass languageClass = new LanguageClass(context.ID().GetText(), props, methods);
        currentEnvironment.Declare(context.ID().GetText(), new ClassValue(languageClass), "class", context.Start);

        return defaultVoid;
    }

    public override ValueWrapper VisitNew(LanguageParser.NewContext context){

        ValueWrapper classValue = currentEnvironment.Get(context.ID().GetText(), context.Start);

        if(classValue is not ClassValue){
            throw new SemanticError("Invalid class instance", context.Start);
        }

        List<ValueWrapper> arguments = new List<ValueWrapper>();

        if(context.args() != null){
            foreach(var arg in context.args().expr()){
                arguments.Add(Visit(arg));
            }
        }
        var instance = ((ClassValue)classValue).languageClass.Invoke(arguments, this);

        return instance;

    }

    public override ValueWrapper VisitArray(LanguageParser.ArrayContext context){
        

        List<ValueWrapper> arguments = new List<ValueWrapper>();

        if(context.args() != null){
            foreach(var arg in context.args().expr()){
                arguments.Add(Visit(arg));
            }
        }
        var ArrayClass = new LanguageArray();
        var instance = ArrayClass.Invoke(arguments, this);

        return instance;
    }

}