public class Environment
{
    public Dictionary<string, ValueWrapper> variables = new Dictionary<string, ValueWrapper>();
    public Dictionary<string, Antlr4.Runtime.IToken> tokens = new();

    public Environment? parent;

    public Environment(Environment? parent)
    {
        this.parent = parent;
    }

    public ValueWrapper Get(string id, Antlr4.Runtime.IToken token)
    {
        if (variables.ContainsKey(id))
        {
            return variables[id];
        }

        if (parent != null)
        {
            return parent.Get(id, token);
        }

        throw new SemanticError("Variable " + id + " not found", token);
    }

    public void Declare(string id, ValueWrapper value, string? type, Antlr4.Runtime.IToken? token)
    {
        if (variables.ContainsKey(id))
    {
        if (token != null) throw new SemanticError("Variable " + id + " already declared", token);
    }
    else
    {
        variables[id] = value;
        if (token != null)
        {
            tokens[id] = token;
        }
    }
    }




    public ValueWrapper Assign(string id, ValueWrapper value, Antlr4.Runtime.IToken token)
    {
        if (variables.ContainsKey(id))
        {
            variables[id] = value;
            return value;
        }

        if (parent != null)
        {
            return parent.Assign(id, value, token);
        }

        throw new SemanticError("Variable " + id + " not found", token);
    }

    public bool Exists(string id)
    {
        if (variables.ContainsKey(id))
        {
            return true;
        }

        return parent?.Exists(id) ?? false;
    }
    public void AssignOrDeclare(string id, ValueWrapper value, string? type, Antlr4.Runtime.IToken? token)
{
    if (variables.ContainsKey(id))
    {
        Assign(id, value, token);
    }
    else
    {
        Declare(id, value, type, token);
    }
}

}
