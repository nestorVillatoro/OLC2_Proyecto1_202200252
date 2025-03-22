public class Environment
{

    public Dictionary<string, ValueWrapper> variables = new Dictionary<string, ValueWrapper>();
    public Dictionary<string, string> variableTypes = new Dictionary<string, string>();
    private Environment? parent;

    public Environment(Environment? parent){
        this.parent = parent;
    }

    public ValueWrapper Get(string id, Antlr4.Runtime.IToken token){
        if (variables.ContainsKey(id)){
            return variables[id];
        }

        if (parent != null){
            return parent.Get(id, token);
        }

        throw new SemanticError("Variable " + id + " not found", token);
    }

    public void Declare(string id, ValueWrapper value, string type, Antlr4.Runtime.IToken? token){
        if (variables.ContainsKey(id)){
            if (token != null) throw new SemanticError("Variable " + id + " already declared", token);
        }
        else{
            variables[id] = value;
            variableTypes[id] = type;
        }
    }

    public ValueWrapper Assign(string id, ValueWrapper value, Antlr4.Runtime.IToken token){
        if (variables.ContainsKey(id)){
            var storedType = variableTypes[id];
            ValidateType(storedType, value, token);
            variables[id] = value;
            return value;
        }

        if (parent != null){
            return parent.Assign(id, value, token);
        }

        throw new SemanticError("Variable " + id + " not found", token);
    }
private void ValidateType(string expectedType, ValueWrapper value, Antlr4.Runtime.IToken token){
    bool isValid = expectedType switch{
        "int" => value is IntValue,
        "float64" => value is FloatValue,
        "string" => value is StringValue,
        "bool" => value is BoolValue,
        "rune" => value is RuneValue, 
        _ => throw new SemanticError($"Unknown type {expectedType}", token)
    };

    if (!isValid){
        throw new SemanticError($"Type mismatch: expected {expectedType}, got {value.GetType().Name}", token);
    }
}

    
}