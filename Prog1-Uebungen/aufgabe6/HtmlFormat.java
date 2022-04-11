package aufgabe6;

import java.io.PrintWriter;

/**
 * HtmlFormat.
 */
public final class HtmlFormat {

    private HtmlFormat() { }

    /**
     * Schreibt die Ausgabe in eine HTML-Datei.
     * @param pw PrintWrite Object
     * @param name Name des Schuelers
     * @param fnl FachNotenListe Object
     */
    public static void ausgeben(final PrintWriter pw, final String[] name,
        final FachNotenListe fnl) {
        pw.println("<!DOCTYPE html>");
        pw.println("<html lang=\"de\">");
        pw.println("<head>");
        pw.println("<meta charset=\"utf-8\">");
        pw.println("<meta name=\"viewport\" content=\"width=device-width, "
            + " initial-scale=1.0\">");
        pw.println("<style>");
        pw.println("table { width:100%; }");
        pw.println("th { text-align:left; }");
        pw.println("</style>");
        pw.println("<title>Notenspiegel</title>");
        pw.println("</head>");
        pw.println("<body>");
        pw.println("<h1>Notenspiegel f&uuml;r");
        for(String s : name)
        {
            pw.println(s);
        }
        pw.println("</h1>");
        pw.println("<hr>");
        pw.println("<table>");
        pw.println("<tr><th>Fach:</th><th>Art:</th><th>Note:</th></tr>");

        for (Leistung var : fnl) {

            if (var.istBestanden()) {
                if (var.istBenotet()) {
                    pw.printf("<tr><td>%s</td><td>L</td><td>%s (%s)</td>"
                        + "</tr>%n",
                            var.getFach(), var.getNoteInWorten(),
                                var.getNote());
                } else {
                    pw.printf("<tr><td>%s</td><td>S</td><td>%s</td></tr>%n",
                        var.getFach(), var.getNoteInWorten());
                }
            } else {
                if (var.istBenotet()) {
                    pw.printf("<tr><td style=\"color:red\">%s</td><td>L</td>"
                        + "<td>%s (%s)</td></tr>", var.getFach(),
                            var.getNoteInWorten(), var.getNote());
                } else {
                    pw.printf("<tr><td style=\"color:red\">%s</td><td>S</td>"
                        + "<td>%s</td></tr>", var.getFach(),
                            var.getNoteInWorten());
                }
            }
        }

        pw.println("</table>");
        pw.println("<hr>");
        pw.println("L = Leistungsnachweis, S = Schein");
        pw.println("</body>");
        pw.println("</html>");
    }
}
