using analyzer;

public class LanguageArray : Invocable
{
    public Dictionary<string, ForeignFunction> Methods { get; set; }
    public Dictionary<string, LanguageParser.VarDclContext> Props { get; }
    private LanguageClass equivalentClass;

    public LanguageArray()
    {
        Props = new Dictionary<string, LanguageParser.VarDclContext>();
        Methods = new Dictionary<string, ForeignFunction>();

        Methods["append"] = new ForeignFunction(Append);
        Methods["len"] = new ForeignFunction(Len);
        Methods["index"] = new ForeignFunction(Index);

        equivalentClass = new LanguageClass("[]", Props, Methods);
    }

    public int Arity()
    {
        return 100; 
    }

    public ValueWrapper Invoke(List<ValueWrapper> args, CompilerVisitor visitor)
    {
        var newInstance = new Instance(equivalentClass, instance =>
        {
            var output = "[";
            foreach (var prop in instance.Properties)
            {
                output += prop.Value.ToString() + ", ";
            }
            if (output.Length > 1)
            {
                output = output.TrimEnd(',', ' ');
            }
            output += "]";
            return output;
        });

        for (int i = 0; i < args.Count; i++)
        {
            newInstance.Set(i.ToString(), args[i]);
        }

        return new InstanceValue(newInstance);
    }

    private static ValueWrapper Append(List<ValueWrapper> args, CompilerVisitor visitor)
    {
        if (args.Count != 2 || args[0] is not InstanceValue arrayInstance)
            throw new SemanticError("append requiere un array y un valor a agregar", null);

        var instance = arrayInstance.instance;
        int index = instance.Properties.Count;
        instance.Set(index.ToString(), args[1]);

        return arrayInstance;
    }

    private static ValueWrapper Len(List<ValueWrapper> args, CompilerVisitor visitor)
    {
        if (args.Count != 1 || args[0] is not InstanceValue arrayInstance)
            throw new SemanticError("len requiere un array", null);

        return new IntValue(arrayInstance.instance.Properties.Count);
    }

    private static ValueWrapper Index(List<ValueWrapper> args, CompilerVisitor visitor)
    {
        if (args.Count != 2 || args[0] is not InstanceValue arrayInstance)
            throw new SemanticError("slices.Index requiere un array y un valor a buscar", null);

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
