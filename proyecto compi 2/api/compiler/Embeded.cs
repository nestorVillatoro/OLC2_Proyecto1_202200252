using analyzer;
using System.Globalization;


public class Embeded
{
    public static void Generate(Environment env)
    {
        env.Declare("append", new FunctionValue(new AppendEmbeded(), "append"), null, null);
        env.Declare("len", new FunctionValue(new LenEmbeded(), "len"), null, null);
        env.Declare("slices.Index", new FunctionValue(new IndexEmbeded(), "slices.Index"), null, null);
        env.Declare("strings.Join", new FunctionValue(new JoinEmbeded(), "strings.Join"), null, null);
        env.Declare("strconv", StrconvEmbeded.Crear(), null, null); 
        env.Declare("reflect", ReflectEmbeded.Crear(), null, null);

    }
}

public class AppendEmbeded : Invocable
{
    public int Arity() => 2;
    public ValueWrapper Invoke(List<ValueWrapper> args, CompilerVisitor visitor)
    {
        if (args.Count != 2 || args[0] is not InstanceValue arrayInstance)
            throw new SemanticError("append requiere un array y un valor", null);

        var instance = arrayInstance.instance;
        int index = instance.Properties.Count;
        instance.Set(index.ToString(), args[1]);

        return arrayInstance;
    }
}

public class LenEmbeded : Invocable
{
    public int Arity() => 1;
    public ValueWrapper Invoke(List<ValueWrapper> args, CompilerVisitor visitor)
    {
        if (args.Count != 1 || args[0] is not InstanceValue arrayInstance)
            throw new SemanticError("len requiere un array", null);

        return new IntValue(arrayInstance.instance.Properties.Count);
    }
}

public class IndexEmbeded : Invocable
{
    public int Arity() => 2;
    public ValueWrapper Invoke(List<ValueWrapper> args, CompilerVisitor visitor)
    {
        if (args.Count != 2 || args[0] is not InstanceValue arrayInstance)
            throw new SemanticError("slices.Index requiere un array y un valor", null);

        var instance = arrayInstance.instance;
        var searchValue = args[1];

        for (int i = 0; i < instance.Properties.Count; i++)
        {
            if (instance.Get(i.ToString(), null).Equals(searchValue))
                return new IntValue(i);
        }

        return new IntValue(-1);
    }
}

public class JoinEmbeded : Invocable
{
    public int Arity() => 2;
    public ValueWrapper Invoke(List<ValueWrapper> args, CompilerVisitor visitor)
    {
        if (args.Count != 2 || args[0] is not InstanceValue arrayInstance || args[1] is not StringValue sep)
            throw new SemanticError("strings.Join requiere un array de strings y un separador", null);

        var elements = arrayInstance.instance.Properties.Values
            .Select(v => v.ToString())
            .ToArray();

        return new StringValue(string.Join(sep.Value, elements));
    }
}

public class AtoiEmbeded : Invocable
{
    public int Arity() => 1;
    public ValueWrapper Invoke(List<ValueWrapper> args, CompilerVisitor visitor)
    {
        if (args.Count != 1 || args[0] is not StringValue strVal)
        {
            throw new SemanticError("strconv.Atoi requiere un solo argumento de tipo string.", null);
        }

        string input = strVal.Value;

        if (!int.TryParse(input, out int result) || input.Contains("."))
        {
            throw new SemanticError($"strconv.Atoi falló: '{input}' no es un entero válido.", null);
        }

        return new IntValue(result);
    }
}


public static class StrconvEmbeded
{
    public static InstanceValue Crear()
    {
        var methods = new Dictionary<string, ForeignFunction>
{
    { "Atoi", new ForeignFunction(new AtoiEmbeded()) },
    { "ParseFloat", new ForeignFunction(new ParseFloatEmbeded()) }
};


        var props = new Dictionary<string, LanguageParser.VarDclContext>();
        var classDef = new LanguageClass("strconv", props, methods);
        return new InstanceValue(new Instance(classDef, inst => "strconv"));
    }
    public class ParseFloatEmbeded : Invocable
{
    public int Arity() => 1;

    public ValueWrapper Invoke(List<ValueWrapper> args, CompilerVisitor visitor)
    {
        if (args.Count != 1 || args[0] is not StringValue strVal)
        {
            throw new SemanticError("strconv.ParseFloat requiere un solo argumento de tipo string.", null);
        }

        string input = strVal.Value;

        if (!float.TryParse(input, NumberStyles.Float, CultureInfo.InvariantCulture, out float result))
        {
            throw new SemanticError($"strconv.ParseFloat falló: '{input}' no es un número válido.", null);
        }

        return new FloatValue(result);
    }
}




}
public static class ReflectEmbeded
{
    public static InstanceValue Crear()
    {
        var methods = new Dictionary<string, ForeignFunction>
        {
            { "TypeOf", new ForeignFunction(new ReflectTypeOfEmbeded()) }
        };

        var props = new Dictionary<string, LanguageParser.VarDclContext>();
        var classDef = new LanguageClass("reflect", props, methods);

        return new InstanceValue(new Instance(classDef, inst => "reflect"));
    }

    public class ReflectTypeOfEmbeded : Invocable
{
    public int Arity() => 1;

    public ValueWrapper Invoke(List<ValueWrapper> args, CompilerVisitor visitor)
    {
        if (args.Count != 1)
            throw new SemanticError("reflect.TypeOf requiere un argumento", null);

        var value = args[0];
        string tipo = value switch
        {
            IntValue => "int",
            FloatValue => "float64",
            StringValue => "string",
            BoolValue => "bool",
            RuneValue => "rune",
            InstanceValue iv => iv.instance.languageClass.Name,
            ClassValue cv => $"class {cv.languageClass.Name}",
            FunctionValue => "function",
            VoidValue => "void",
            _ => "unknown"
        };

        return new StringValue(tipo);
    }
}
}