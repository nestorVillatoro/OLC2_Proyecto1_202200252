using System.Text;
using System.Collections.Generic;
using System.IO;

public class Simbolo
{
    public string Id { get; set; }
    public string SimboloTipo { get; set; }
    public string TipoDato { get; set; }
    public string Ambito { get; set; }
    public int Linea { get; set; }
    public int Columna { get; set; }

    public Simbolo(string id, string simboloTipo, string tipoDato, string ambito, int linea, int columna)
    {
        Id = id;
        SimboloTipo = simboloTipo;
        TipoDato = tipoDato;
        Ambito = ambito;
        Linea = linea;
        Columna = columna;
    }
}

public static class TablaSimbolosExporter
{
    public static string GenerarHTML(List<Simbolo> simbolos)
    {
        var html = new StringBuilder();
        html.AppendLine("<table border='1'>");
        html.AppendLine("<tr><th>ID</th><th>Tipo</th><th>Tipo Dato</th><th>Ámbito</th><th>Línea</th><th>Columna</th></tr>");

        foreach (var s in simbolos)
        {
            html.AppendLine($"<tr><td>{s.Id}</td><td>{s.SimboloTipo}</td><td>{s.TipoDato}</td><td>{s.Ambito}</td><td>{s.Linea}</td><td>{s.Columna}</td></tr>");
        }

        html.AppendLine("</table>");
        return html.ToString();
    }

    public static string GenerarDOT(List<Simbolo> simbolos)
    {
        var dot = new StringBuilder();
        dot.AppendLine("digraph TablaSimbolos {");
        dot.AppendLine("node [shape=plaintext];");
        dot.AppendLine("tabla [label=<");
        dot.AppendLine("<table border='1' cellborder='1' cellspacing='0'>");
        dot.AppendLine("<tr><td><b>ID</b></td><td><b>Tipo</b></td><td><b>Tipo Dato</b></td><td><b>Ámbito</b></td><td><b>Línea</b></td><td><b>Columna</b></td></tr>");

        foreach (var s in simbolos)
        {
            dot.AppendLine($"<tr><td>{s.Id}</td><td>{s.SimboloTipo}</td><td>{s.TipoDato}</td><td>{s.Ambito}</td><td>{s.Linea}</td><td>{s.Columna}</td></tr>");
        }

        dot.AppendLine("</table>>];");
        dot.AppendLine("}");

        return dot.ToString();
    }

    public static void ExportarHTML(string ruta, List<Simbolo> simbolos)
    {
        File.WriteAllText(ruta, GenerarHTML(simbolos));
    }

    public static void ExportarDOT(string ruta, List<Simbolo> simbolos)
    {
        File.WriteAllText(ruta, GenerarDOT(simbolos));
    }

    public static List<Simbolo> ObtenerSimbolos(Environment entorno, string ambito = "Global")
    {
        var lista = new List<Simbolo>();
        foreach (var entry in entorno.variables)
        {
            string tipoDato = "desconocido";
            string tipoSimbolo = "Variable";
            int linea = 0;
            int columna = 0;

            if (entry.Value is IntValue) tipoDato = "int";
            else if (entry.Value is FloatValue) tipoDato = "float64";
            else if (entry.Value is StringValue) tipoDato = "string";
            else if (entry.Value is BoolValue) tipoDato = "bool";
            else if (entry.Value is RuneValue) tipoDato = "rune";
            else if (entry.Value is ClassValue cv) { tipoDato = cv.languageClass.Name; tipoSimbolo = "Clase"; }
            else if (entry.Value is FunctionValue) tipoSimbolo = "Función";

            if (entorno.tokens.ContainsKey(entry.Key))
            {
                var token = entorno.tokens[entry.Key];
                linea = token.Line;
                columna = token.Column;
            }

            lista.Add(new Simbolo(
                entry.Key,
                tipoSimbolo,
                tipoDato,
                ambito,
                linea,
                columna
            ));
        }

        if (entorno.parent != null)
        {
            lista.AddRange(ObtenerSimbolos(entorno.parent, "Global"));
        }

        return lista;
    }
}
