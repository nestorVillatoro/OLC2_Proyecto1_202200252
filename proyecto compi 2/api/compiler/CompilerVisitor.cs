
using analyzer;

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


    // VisitProgram
    public override ValueWrapper VisitProgram(LanguageParser.ProgramContext context)
    {
        foreach (var dcl in context.dcl())
        {
            Visit(dcl);
        }
        return defaultVoid;
    }

    // VisitVarDcl
    public override ValueWrapper VisitVarDcl(LanguageParser.VarDclContext context)
    {
        string id = context.ID().GetText();
        ValueWrapper value = Visit(context.expr());
        currentEnvironment.Declare(id, value, context.Start);
        return defaultVoid;
    }

    // VisitExprStmt
    public override ValueWrapper VisitExprStmt(LanguageParser.ExprStmtContext context)
    {
        return Visit(context.expr());
    }

    // VisitPrintStmt
    // public override ValueWrapper VisitPrintStmt(LanguageParser.PrintStmtContext context)
    // {
    //     ValueWrapper value = Visit(context.expr());
    //     // output += value + "\n";
    //     output += value switch
    //     {
    //         IntValue i => i.Value.ToString(),
    //         FloatValue f => f.Value.ToString(),
    //         StringValue s => s.Value,
    //         BoolValue b => b.Value.ToString(),
    //         VoidValue v => "void",
    //         FunctionValue fn => "<fn " + fn.name + ">",
    //         _ => throw new SemanticError("Invalid value", context.Start)
    //     };
    //     output += "\n";

    //     return defaultVoid;
    // }

    // VisitIdentifier
    public override ValueWrapper VisitIdentifier(LanguageParser.IdentifierContext context)
    {
        string id = context.ID().GetText();
        return currentEnvironment.Get(id, context.Start);
    }

    // VisitParens
    public override ValueWrapper VisitParens(LanguageParser.ParensContext context)
    {
        return Visit(context.expr());
    }

    // VisitNegate
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

    // VisitInt
    public override ValueWrapper VisitInt(LanguageParser.IntContext context)
    {
        return new IntValue(int.Parse(context.INT().GetText()));
    }

    // VisitMulDiv
    public override ValueWrapper VisitMulDiv(LanguageParser.MulDivContext context)
    {
        ValueWrapper left = Visit(context.expr(0));
        ValueWrapper right = Visit(context.expr(1));
        var op = context.op.Text;

        return (left, right, op) switch
        {
            (IntValue l, IntValue r, "*") => new IntValue(l.Value * r.Value),
            (IntValue l, IntValue r, "/") => new IntValue(l.Value / r.Value),
            (FloatValue l, FloatValue r, "*") => new FloatValue(l.Value * r.Value),
            (FloatValue l, FloatValue r, "/") => new FloatValue(l.Value / r.Value),
            _ => throw new SemanticError("Invalid operation", context.Start)
        };

    }

    // VisitAddSub
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
            (IntValue l, StringValue r, "+") => new StringValue(l.Value.ToString() + r.Value),
            (StringValue l, IntValue r, "+") => new StringValue(l.Value + r.Value.ToString()),
            _ => throw new SemanticError("Invalid operation", context.Start)
        };
    }


    // VisitFloat
    public override ValueWrapper VisitFloat(LanguageParser.FloatContext context)
    {
        return new FloatValue(float.Parse(context.FLOAT().GetText()));
    }

    // VisitRelational
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
            _ => throw new SemanticError("Invalid operation", context.Start)
        };
    }

    // VisitAssign
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
        return defaultVoid;
    }


    // VisitEquality
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
            (StringValue l, StringValue r, "==") => new BoolValue(l.Value == r.Value),
            (StringValue l, StringValue r, "!=") => new BoolValue(l.Value != r.Value),
            (BoolValue l, BoolValue r, "==") => new BoolValue(l.Value == r.Value),
            (BoolValue l, BoolValue r, "!=") => new BoolValue(l.Value != r.Value),
            _ => throw new SemanticError("Invalid operation", context.Start)
        };
    }


    // VisitBoolean
    public override ValueWrapper VisitBoolean(LanguageParser.BooleanContext context)
    {
        return new BoolValue(bool.Parse(context.BOOL().GetText()));
    }


    // VisitString
    public override ValueWrapper VisitString(LanguageParser.StringContext context)
    {
        return new StringValue(context.STRING().GetText());
    }


    // VisitBlockStmt
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

    // VisitIfStmt
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

    // VisitWhileStmt
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

    // VisitForStmt
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

    // VisitBreakStmt
    public override ValueWrapper VisitBreakStmt(LanguageParser.BreakStmtContext context)
    {
        throw new BreakException();
    }

    // VisitContinueStmt
    public override ValueWrapper VisitContinueStmt(LanguageParser.ContinueStmtContext context)
    {
        throw new ContinueException();
    }

    // VisitReturnStmt
    public override ValueWrapper VisitReturnStmt(LanguageParser.ReturnStmtContext context)
    {
        ValueWrapper value = defaultVoid;

        if (context.expr() != null)
        {
            value = Visit(context.expr());
        }


        throw new ReturnException(value);
    }

    // VisitCallee
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

        // if (context != null && arguments.Count != invocable.Arity())
        // {
        //     throw new SemanticError("Invalid number of arguments", context.Start);
        // }

        return invocable.Invoke(arguments, this);

    }

    public override ValueWrapper VisitFuncDcl(LanguageParser.FuncDclContext context)
    {
        var foreign = new ForeignFunction(currentEnvironment, context);
        currentEnvironment.Declare(context.ID().GetText(), new FunctionValue(foreign, context.ID().GetText()), context.Start);

        return defaultVoid;
    }

    public override ValueWrapper VisitClassDcl(LanguageParser.ClassDclContext context){
        Dictionary<string, LanguageParser.VarDclContext> props = new Dictionary<string, LanguageParser.VarDclContext>();
        Dictionary<string, ForeignFunction> methods = new Dictionary<string, ForeignFunction>();

        foreach(var prop in context.classBody()){
            if (prop.varDcl() != null){
                var vardcl = prop.varDcl();
                props.Add(vardcl.ID().GetText(), vardcl);
            }else if (prop.funcDcl() != null){
                var funcDcl = prop.funcDcl();
                var foreignFunction = new ForeignFunction(currentEnvironment, funcDcl);
                methods.Add(funcDcl.ID().GetText(), foreignFunction);
            }

            

            

        
        }
        LanguageClass languageClass = new LanguageClass(context.ID().GetText(), props, methods);
        currentEnvironment.Declare(context.ID().GetText(), new ClassValue(languageClass), context.Start);
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