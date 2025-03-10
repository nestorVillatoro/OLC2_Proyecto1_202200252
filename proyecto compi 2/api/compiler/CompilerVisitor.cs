using analyzer;

class CompilerVisitor : LanguageBaseVisitor<int>
{

    public string output = "";
    private Environment currentEnvironment = new Environment();
    public override int VisitProgram(LanguageParser.ProgramContext context)
    {
        foreach (var dcl in context.dcl())
        {
            Visit(dcl);
        }
        return 0;
    }

    public override int VisitVarDcl(LanguageParser.VarDclContext context)
    {
        string id = context.ID().GetText();
        int value = Visit(context.expr());
        currentEnvironment.SetVariable(id, value); // agregamos una variable
        return 0;
    }

    public override int VisitExprStmt(LanguageParser.ExprStmtContext context)
    {
        return Visit(context.expr());
    }

    public override int VisitPrintStmt(LanguageParser.PrintStmtContext context)
    {
        int value = Visit(context.expr());
        output += value + "\n";
        return 0;
    }

    public override int VisitIdentifier(LanguageParser.IdentifierContext context)
    {
        string id = context.ID().GetText();
        return currentEnvironment.GetVariable(id); // obtenemos valor de una varible
    }

    public override int VisitParens(LanguageParser.ParensContext context)
    {
        return Visit(context.expr());
    }
    
    public override int VisitNegate(LanguageParser.NegateContext context)
    {
        return -Visit(context.expr());
    }

    public override int VisitAddSub(LanguageParser.AddSubContext context)
    {
        int left = Visit(context.expr(0));
        int right = Visit(context.expr(1));

        return context.GetChild(1).GetText() == "+" ? left + right : left - right;
    }

    public override int VisitMulDiv(LanguageParser.MulDivContext context)
    {
        int left = Visit(context.expr(0));
        int right = Visit(context.expr(1));

        return context.GetChild(1).GetText() == "*" ? left * right : left / right;
    }

    public override int VisitNumber(LanguageParser.NumberContext context)
    {
        return int.Parse(context.INT().GetText());
    }


}