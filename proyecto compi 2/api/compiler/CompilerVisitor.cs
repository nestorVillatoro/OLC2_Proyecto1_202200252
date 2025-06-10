
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
        if (dcl.funcDcl() != null || dcl.classDcl() != null)
        {
            Visit(dcl); 
        }
    }


    if (!currentEnvironment.Exists("main"))
    {
        throw new SemanticError("No se encontró la función 'main'.", null);
    }

    var mainValue = currentEnvironment.Get("main", null);
    if (mainValue is not FunctionValue fn)
    {
        throw new SemanticError("'main' no es una función válida.", null);
    }


    var simbolos = TablaSimbolosExporter.ObtenerSimbolos(currentEnvironment);
    TablaSimbolosExporter.ExportarHTML("wwwroot/tabla_simbolos.html", simbolos);

    return fn.invocable.Invoke(new List<ValueWrapper>(), this);
}



    public override ValueWrapper VisitEVarDcl(LanguageParser.EVarDclContext context)
{
    string id = context.ID().GetText();
    string type = context.TIPOS()?.GetText(); 
    
    ValueWrapper value;


    if (context.GetChild(1).GetText() == "[]")
    {
        value = new LanguageArray().Invoke(new List<ValueWrapper>(), this);
    }
    else if (context.expr() != null)  
    {
        value = Visit(context.expr());
    }
    else
    {
        value = GetDefaultValue(type, context.Start);
    }

    currentEnvironment.Declare(id, value, type, context.Start);
    
    return defaultVoid;
}

private ValueWrapper GetDefaultValue(string type, Antlr4.Runtime.IToken token)
{
    return type switch
    {
        "int" => new IntValue(0),
        "float64" => new FloatValue(0.0f),
        "string" => new StringValue(""),
        "bool" => new BoolValue(false),
        "rune" => new IntValue(0), 
        _ => throw new SemanticError($"Unknown type {type}", token)
    };
}


    public override ValueWrapper VisitIncDec(LanguageParser.IncDecContext context)
    {
        string id = context.ID().GetText();
        ValueWrapper currentValue = currentEnvironment.Get(id, context.Start);
        string op = context.op.Text; 

        if (currentValue is not IntValue intValue)
        {
            throw new SemanticError($"Operator '{op}' is only allowed for integers, but got {currentValue.GetType().Name}", context.Start);
        }


        ValueWrapper newValue = op switch
        {
            "++" => new IntValue(intValue.Value + 1),
            "--" => new IntValue(intValue.Value - 1),
            _ => throw new SemanticError($"Unknown operator {op}", context.Start)
        };

        currentEnvironment.Assign(id, newValue, context.Start);


        return newValue;
    }
private string ProcesarEscape(string input)
{
    return input
        .Replace("\\n", "\n")
        .Replace("\\r", "\r")
        .Replace("\\t", "\t")
        .Replace("\\\"", "\"")
        .Replace("\\\\", "\\");
}


public override ValueWrapper VisitPrintStmt(LanguageParser.PrintStmtContext context)
{
    var output = "";

    if (context.args() != null)
    {
        var values = context.args().expr()
            .Select(Visit)
            .Select(v => v is StringValue sv ? ProcesarEscape(sv.Value) : v?.ToString() ?? "(error: null)");

        output = string.Join(" ", values);
    }

    output += "\n";
    this.output += output;
    Console.Write(output);

    return defaultVoid;
}




public override ValueWrapper VisitSwitchStmt(LanguageParser.SwitchStmtContext context)
{
    ValueWrapper switchValue = Visit(context.expr());
    bool caseMatched = false;

    try
    {
        foreach (var caseBlock in context.caseBlock())
        {
            ValueWrapper caseValue = Visit(caseBlock.expr());

            if (!caseMatched && AreEqual(switchValue, caseValue))
            {
                caseMatched = true;

                foreach (var stmt in caseBlock.stmt())
                {
                    Visit(stmt);
                }

                break; 
            }
        }

        if (!caseMatched && context.defaultBlock() != null)
        {
            foreach (var stmt in context.defaultBlock().stmt())
            {
                Visit(stmt);
            }
        }
    }
    catch (BreakException)
    {
       
    }

    return defaultVoid;
}



private bool AreEqual(ValueWrapper a, ValueWrapper b)
{
    return (a, b) switch
    {
        (IntValue x, IntValue y) => x.Value == y.Value,
        (StringValue x, StringValue y) => x.Value == y.Value,
        (BoolValue x, BoolValue y) => x.Value == y.Value,
        _ => false 
    };
}




    public override ValueWrapper VisitIVarDcl(LanguageParser.IVarDclContext context)
{
    string id = context.ID().GetText();
    ValueWrapper value = Visit(context.expr());

   
    string inferredType = null;
    if (value is InstanceValue sliceInstance && sliceInstance.instance.languageClass.Name.StartsWith("[]"))
    {
        inferredType = sliceInstance.instance.languageClass.Name; 
    }

    currentEnvironment.Declare(id, value, inferredType, context.Start);
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
            "rune" => new IntValue(0), 
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
            "rune" => value is IntValue, 
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
    var result = Visit(context.expr());

    return result;
}



public override ValueWrapper VisitIdentifier(LanguageParser.IdentifierContext context)
{
    string id = context.ID().GetText();
    var value = currentEnvironment.Get(id, context.Start);



    return value;
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
        ValueWrapper left = Visit(context.expr(0));
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
        (FloatValue l, IntValue r, "+=") => new FloatValue(l.Value + r.Value),
        (IntValue l, FloatValue r, "-=") => new FloatValue(l.Value - r.Value),
        (IntValue l, FloatValue r, "+=") => new FloatValue(l.Value + r.Value),
        (FloatValue l, IntValue r, "-=") => new FloatValue(l.Value - r.Value),
        (StringValue l, StringValue r, "+=") => new StringValue(l.Value + r.Value),
        _ => throw new SemanticError($"Invalid operation {op} for types {currentValue.GetType().Name} and {exprValue.GetType().Name}", context.Start)
    };

    currentEnvironment.Assign(id, newValue, context.Start);
    return newValue;
}


public override ValueWrapper VisitForRangeStmt(LanguageParser.ForRangeStmtContext context)
{
    string keyName = context.ID(0).GetText();     
    string valueName = context.ID(1).GetText();   

    ValueWrapper iterable = Visit(context.expr());
    if (iterable is not InstanceValue instance || instance.instance.Properties.Count == 0)
    {
        throw new SemanticError("El valor en 'range' debe ser un slice no vacío.", context.Start);
    }

    var oldEnv = currentEnvironment;
    currentEnvironment = new Environment(oldEnv);

    try
    {
        int length = instance.instance.Properties.Count;

        for (int i = 0; i < length; i++)
        {
            var key = new IntValue(i);
            var value = instance.instance.Get(i.ToString(), context.Start);

            currentEnvironment.AssignOrDeclare(keyName, key, "int", context.Start);
            currentEnvironment.AssignOrDeclare(valueName, value, null, context.Start);

            foreach (var stmt in context.stmt())
            {
                try
                {
                    Visit(stmt);
                }
                catch (ContinueException)
                {
                    break;
                }
                catch (BreakException)
                {
                    return defaultVoid;
                }
            }
        }
    }
    finally
    {
        currentEnvironment = oldEnv;
    }

    return defaultVoid;
}

    public override ValueWrapper VisitFloat(LanguageParser.FloatContext context)
    {
        string floatText = context.FLOAT().GetText();
        float value = float.Parse(floatText, CultureInfo.InvariantCulture); 
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

    if (left is not BoolValue l)
    {
        throw new SemanticError($"Los operadores lógicos requieren valores booleanos, got {left.GetType().Name}", context.Start);
    }
    if (right is not BoolValue r)
    {
        throw new SemanticError($"Los operadores lógicos requieren valores booleanos, got {right.GetType().Name}", context.Start);
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

    if (asignee is LanguageParser.IdentifierContext idContext)
    {
        string id = idContext.ID().GetText();


        if (!currentEnvironment.Exists(id))
        {
            throw new SemanticError($"La variable '{id}' no está declarada antes de asignarle un valor.", context.Start);
        }


        ValueWrapper declaredValue = currentEnvironment.Get(id, context.Start);
        if (declaredValue is InstanceValue declaredSlice && declaredSlice.instance.languageClass.Name.StartsWith("[]"))
        {
            string expectedType = declaredSlice.instance.languageClass.Name;
            if (value is InstanceValue assignedSlice && assignedSlice.instance.languageClass.Name != expectedType)
            {
                throw new SemanticError($"Tipo incorrecto en asignación. Se esperaba {expectedType}, pero se encontró {assignedSlice.instance.languageClass.Name}.", context.Start);
            }
        }

  
        currentEnvironment.Assign(id, value, context.Start);
        return defaultVoid;
    }
    else if (asignee is LanguageParser.ArrayAccessContext arrayAccess)
    {
       
        ValueWrapper arrayValue = Visit(arrayAccess.expr(0)); 
        ValueWrapper indexValue = Visit(arrayAccess.expr(1)); 

        if (arrayValue is not InstanceValue arrayInstance || !arrayInstance.instance.languageClass.Name.StartsWith("[]"))
        {
            throw new SemanticError("Se intentó acceder a un índice en una variable que no es un slice o array.", context.Start);
        }

        if (indexValue is not IntValue intIndex)
        {
            throw new SemanticError("El índice de un slice debe ser un número entero.", context.Start);
        }

        var instance = arrayInstance.instance;


        if (!instance.Properties.ContainsKey(intIndex.Value.ToString()))
        {
            throw new SemanticError($"Índice fuera de rango: {intIndex.Value}", context.Start);
        }

        instance.Set(intIndex.Value.ToString(), value);
        return defaultVoid;
    }
    else
    {
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

    try
    {
        foreach (var stmt in context.dcl())
        {
            Visit(stmt);
        }
    }
    catch (BreakException)
    {
        throw; 
    }
    finally
    {
        currentEnvironment = previousEnvironment;
    }

    return defaultVoid;
}


public override ValueWrapper VisitIfStmt(LanguageParser.IfStmtContext context)
{
    ValueWrapper condition = Visit(context.expr());

    if (condition is not BoolValue)
    {
        throw new SemanticError("Invalid condition", context.Start);
    }

    try
    {
        if ((condition as BoolValue).Value)
        {
            Visit(context.stmt(0));
        }
        else if (context.stmt().Length > 1)
        {
            Visit(context.stmt(1));
        }
    }
    catch (BreakException)
    {
   
        throw;
    }

    return defaultVoid;
}


    public override ValueWrapper VisitWhileStmt(LanguageParser.WhileStmtContext context)
{
    Environment previousEnvironment = currentEnvironment;
    currentEnvironment = new Environment(previousEnvironment);

    try
    {
        while (true)
        {
            ValueWrapper condition = Visit(context.expr());

            if (condition is not BoolValue boolCondition)
            {
                throw new SemanticError("La condición del for debe ser booleana", context.Start);
            }

            if (!boolCondition.Value) break;

            try
            {
                foreach (var stmt in context.stmt())
                {
                    Visit(stmt);
                }
            }
            catch (ContinueException)
            {
                continue;
            }
            catch (BreakException)
            {
                break;
            }
        }
    }
    finally
    {
        currentEnvironment = previousEnvironment; 
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
public ValueWrapper VisitCall(Invocable invocable, LanguageParser.ArgsContext context)
{
    List<ValueWrapper> arguments = new();

    if (context != null)
    {
        foreach (var expr in context.expr())
        {
            arguments.Add(Visit(expr));
        }
    }

    return invocable.Invoke(arguments, this);
}
public override ValueWrapper VisitCallee(LanguageParser.CalleeContext context)
{
    ValueWrapper callee = Visit(context.expr());

    foreach (var call in context.call())
    {
        if (call is LanguageParser.FuncCallContext funcCall)
        {
            if (callee is FunctionValue functionValue)
            {
                callee = VisitCall(functionValue.invocable, funcCall.args());
            }
            else
            {
                throw new SemanticError("Invalid function call", context.Start);
            }
        }
        else if (call is LanguageParser.GetContext getContext)
        {
            if (callee is InstanceValue instanceValue)
            {
                callee = instanceValue.instance.Get(getContext.ID().GetText(), getContext.Start);
            }
            else
            {
               
                if (callee is FunctionValue fn)
                {
                    
                    callee = fn;
                }
                else
                {
                    throw new SemanticError("Invalid property access", context.Start);
                }
            }
        }
        else
        {
            throw new SemanticError("Unknown call structure", context.Start);
        }
    }

    return callee;
}






public override ValueWrapper VisitArrayAccess(LanguageParser.ArrayAccessContext context)
{
    ValueWrapper arrayValue = Visit(context.expr(0)); 
    ValueWrapper indexValue = Visit(context.expr(1)); 

    if (arrayValue is not InstanceValue arrayInstance || !arrayInstance.instance.languageClass.Name.StartsWith("[]"))
    {
        throw new SemanticError("Se intentó acceder a un índice en una variable que no es un slice o array.", context.Start);
    }

    if (indexValue is not IntValue intIndex)
    {
        throw new SemanticError("El índice de un slice debe ser un número entero.", context.Start);
    }

    var instance = arrayInstance.instance;

    if (!instance.Properties.ContainsKey(intIndex.Value.ToString()))
    {
        throw new SemanticError($"Índice fuera de rango: {intIndex.Value}", context.Start);
    }


    ValueWrapper retrievedValue = instance.Get(intIndex.Value.ToString(), context.Start);

    if (retrievedValue == null)
    {
        throw new SemanticError($"El índice {intIndex.Value} contiene un valor nulo.", context.Start);
    }

    return retrievedValue;
}


public override ValueWrapper VisitMatrixLiteral(LanguageParser.MatrixLiteralContext context)
{
    string elementType = context.TIPOS().GetText();
    List<ValueWrapper> rows = new List<ValueWrapper>();

    foreach (var row in context.matrixRows().args())
    {
        List<ValueWrapper> elements = row.expr().Select(Visit).ToList();
        

        foreach (var element in elements)
        {
            if (!ValidateMatrixType(elementType, element))
            {
                throw new SemanticError($"Tipo incorrecto en matriz. Se esperaba {elementType}, pero se encontró {element.GetType().Name}", context.Start);
            }
        }
        
        InstanceValue rowInstance = (InstanceValue) new LanguageArray().Invoke(elements, this);
        rows.Add(rowInstance);
    }

    InstanceValue matrixInstance = (InstanceValue) new LanguageArray().Invoke(rows, this);
    matrixInstance.instance.languageClass.Name = $"[][]{elementType}";
    return matrixInstance;
}
private bool ValidateMatrixType(string expectedType, ValueWrapper value)
{
    return expectedType switch
    {
        "int" => value is IntValue,
        "float64" => value is FloatValue || value is IntValue,
        "string" => value is StringValue,
        "bool" => value is BoolValue,
        _ => false
    };
}

public override ValueWrapper VisitMatrixAccess(LanguageParser.MatrixAccessContext context)
{
    ValueWrapper arrayValue = Visit(context.expr(0));
    ValueWrapper rowIndexValue = Visit(context.expr(1));
    ValueWrapper colIndexValue = Visit(context.expr(2));

    if (arrayValue is not InstanceValue matrixInstance || !matrixInstance.instance.languageClass.Name.StartsWith("[][]"))
    {
        throw new SemanticError("El objeto no es una matriz.", context.Start);
    }

    if (rowIndexValue is not IntValue rowIndex || colIndexValue is not IntValue colIndex)
    {
        throw new SemanticError("Los índices deben ser enteros.", context.Start);
    }

    if (!matrixInstance.instance.Properties.ContainsKey(rowIndex.Value.ToString()))
    {
        throw new SemanticError("Índice de fila fuera de rango.", context.Start);
    }

    ValueWrapper rowValue = matrixInstance.instance.Get(rowIndex.Value.ToString(), context.Start);
    
    if (rowValue is not InstanceValue rowInstance)
    {
        throw new SemanticError("Error interno: fila corrupta.", context.Start);
    }

    if (!rowInstance.instance.Properties.ContainsKey(colIndex.Value.ToString()))
    {
        throw new SemanticError("Índice de columna fuera de rango.", context.Start);
    }

    return rowInstance.instance.Get(colIndex.Value.ToString(), context.Start);
}

public override ValueWrapper VisitAppendExpr(LanguageParser.AppendExprContext context)
{
    string matrixName = context.ID().GetText();
    ValueWrapper matrixValue = currentEnvironment.Get(matrixName, context.Start);
    ValueWrapper rowValue = Visit(context.expr());

    if (matrixValue is not InstanceValue matrixInstance || !matrixInstance.instance.languageClass.Name.StartsWith("[][]"))
    {
        throw new SemanticError($"La variable '{matrixName}' no es una matriz válida.", context.Start);
    }

    if (rowValue is not InstanceValue rowInstance || !rowInstance.instance.languageClass.Name.StartsWith("[]"))
    {
        throw new SemanticError("El segundo argumento de append debe ser un slice unidimensional.", context.Start);
    }

    int index = matrixInstance.instance.Properties.Count;
    matrixInstance.instance.Set(index.ToString(), rowValue);

    return matrixInstance;
}



    

public override ValueWrapper VisitFuncDcl(LanguageParser.FuncDclContext context)
{
    string funcName = context.ID().GetText();


    var placeholder = new FunctionValue(null!, funcName);
    currentEnvironment.Declare(funcName, placeholder, null, context.Start);


    var realFunction = new ForeignFunction(currentEnvironment, context);
    var realValue = new FunctionValue(realFunction, funcName);


    currentEnvironment.Assign(funcName, realValue, context.Start);

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

public override ValueWrapper VisitArray(LanguageParser.ArrayContext context)
{
    List<ValueWrapper> elements = new List<ValueWrapper>();


    if (context.args() != null)
    {
        foreach (var arg in context.args().expr())
        {
            elements.Add(Visit(arg));
        }
    }

    return new LanguageArray().Invoke(elements, this);
}





public override ValueWrapper VisitSliceIndex(LanguageParser.SliceIndexContext context)
{
    List<ValueWrapper> args = context.args().expr().Select(Visit).ToList();
    return new IndexEmbeded().Invoke(args, this);
}

public override ValueWrapper VisitSliceLen(LanguageParser.SliceLenContext context)
{
    List<ValueWrapper> args = context.args().expr().Select(Visit).ToList();
    return new LenEmbeded().Invoke(args, this);
}

public override ValueWrapper VisitSliceAppend(LanguageParser.SliceAppendContext context)
{
    List<ValueWrapper> args = context.args().expr().Select(Visit).ToList();
    return new AppendEmbeded().Invoke(args, this);
}

public override ValueWrapper VisitStringsJoin(LanguageParser.StringsJoinContext context)
{
    List<ValueWrapper> args = context.args().expr().Select(Visit).ToList();
    return new JoinEmbeded().Invoke(args, this);
}

public override ValueWrapper VisitSliceLiteral(LanguageParser.SliceLiteralContext context)
{
    string sliceType = context.TIPOS().GetText(); 
    List<ValueWrapper> elements = new List<ValueWrapper>();

    if (context.args() != null)
    {
        foreach (var arg in context.args().expr())
        {
            elements.Add(Visit(arg));
        }
    }

    foreach (var element in elements)
    {
        if (!ValidateSliceType(sliceType, element))
        {
            throw new SemanticError($"Tipo incorrecto en slice. Se esperaba {sliceType}, pero se encontró {element.GetType().Name}", context.Start);
        }
    }


    ValueWrapper sliceInstance = new LanguageArray().Invoke(elements, this);


    if (sliceInstance is InstanceValue instanceValue)
    {
        instanceValue.instance.languageClass.Name = $"[]{sliceType}"; 
    }
    else
    {
        throw new SemanticError("Error interno: el slice no se creó correctamente", context.Start);
    }

    return sliceInstance;
}


private bool ValidateSliceType(string expectedType, ValueWrapper value)
{
    return expectedType switch
    {
        "int" => value is IntValue,
        "float64" => value is FloatValue,
        "string" => value is StringValue,
        "bool" => value is BoolValue,
        _ => false
    };
}




}