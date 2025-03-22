public class Embeded
{
    public static void Generate(Environment env)
    {
        env.Declare("time", new FunctionValue(new TimeEmbeded(), "time"),null, null);
        env.Declare("Println", new FunctionValue(new PrintEmbeded(), "Println"),null, null);
    }
}

public class TimeEmbeded : Invocable
{
    public int Arity()
    {
        return 0;
    }

    public ValueWrapper Invoke(List<ValueWrapper> args, CompilerVisitor visitor)
    {
        return new StringValue(DateTime.Now.ToString());
    }
}

public class PrintEmbeded : Invocable
{
    public int Arity()
    {
        return 1;
    }

    public ValueWrapper Invoke(List<ValueWrapper> args, CompilerVisitor visitor)
    {

        var output = "";

        foreach (var arg in args)
        {
            output += arg.ToString();
        }


        output += "\n";

        visitor.output += output;

        return visitor.defaultVoid;
    }
}