

public abstract record ValueWrapper;


public record IntValue(int Value) : ValueWrapper
{
    
    public override string ToString()
    {

        return Value.ToString();
    }
}
public record FloatValue(float Value) : ValueWrapper
{
    public override string ToString()
    {
        return Value.ToString("F16");
    }
}
public record StringValue(string Value) : ValueWrapper
{
    public override string ToString()
    {
        return Value;
    }
}
public record BoolValue(bool Value) : ValueWrapper
{
    public override string ToString()
    {
        return Value.ToString();
    }
}

public record RuneValue(bool Value) : ValueWrapper
{
    public override string ToString()
    {
        return Value.ToString();
    }
}

public record FunctionValue(Invocable invocable, string name) : ValueWrapper
{
    public override string ToString()
    {
        return name;
    }
}

public record InstanceValue(Instance instance) : ValueWrapper
{
    public override string ToString()
    {
        return instance.ToString();
    }
}

public record ClassValue(LanguageClass languageClass) : ValueWrapper
{
    public override string ToString()
    {
        return "class " + languageClass.Name;
    }
}


public record VoidValue : ValueWrapper
{
    public override string ToString()
    {
        return "void";
    }
}

