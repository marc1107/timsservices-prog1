package aufgabe6;

import java.io.PrintWriter;

/**
 * TextFormat.
 */
public final class TextFormat {

    private TextFormat() { }

    private static final int OFFSET = 5;

    /**
     * Schreibt die Ausgabe in eine HTML-Datei.
     * @param pw PrintWrite Object
     * @param name Name des Schuelers
     * @param fnl FachNotenListe Object
     */
    public static void ausgeben(final PrintWriter pw, final String[] name,
        final FachNotenListe fnl) {

        int maxFach = 0;
        for (Leistung var : fnl) {
            if (var.getFach().length() > maxFach) {
                maxFach = var.getFach().length();
            }
        }

        int offset = maxFach + OFFSET;

        pw.printf("Notenspiegel für %s %s%n", name[0], name[1]);
        pw.printf("%-" + offset + "s%-10s%-20s%n", "Fach:", "Art:", "Note:");

        for (Leistung var : fnl) {

            if (var.istBestanden()) {
                if (var.istBenotet()) {
                    pw.printf("%-" + offset + "s%-10s%s (%s)%n",
                        var.getFach(), "L", var.getNoteInWorten(),
                            var.getNote());
                } else {
                    pw.printf("%-" + offset + "s%-10s%s%n",
                        var.getFach(), "S", var.getNoteInWorten());
                }
            } else {
                if (var.istBenotet()) {
                    pw.printf("%-" + offset + "s%-10s%s (%s)%n", var.getFach(),
                        "L", var.getNoteInWorten(), var.getFach());
                } else {
                    pw.printf("%-" + offset + "s%-10s%s%n",
                        var.getFach(), "S", var.getNoteInWorten());
                }
            }
        }

        pw.printf("%nL = Leistungsnachweis, S = Schein%n");
    }
}
