// HtmlNotenspiegel.java
package aufgabe6;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Die Main-Klasse HtmlNotenspiegel liest die Namen von F&auml;chern
 * mit den zugeh&ouml;rigen Noten in eine verkettete Liste ein und
 * gibt dann einen Notenspiegel im HTML-Format aus.
 * Aufruf mit dem Namen des Studenten als Argument(e)
 * @author H.Drachenfels
 * @version 23.10.2018
 */
public final class HtmlNotenspiegel {
    private HtmlNotenspiegel() { }

    /**
     * main muss mit mindestens zwei Argumenten aufgerufen werden.
     * @param args Vorname(n) Nachname
     * @throws IOException bei Einleseproblemen
     */
    public static void main(final String[] args) throws IOException {
        if (args.length < 2) {
            System.err.println(
                "Aufruf: java HtmlNotenspiegel Vorname(n) Nachname");
            System.exit(1);
        }

        FachNotenListe notenListe = new FachNotenListe();
        einlesen(notenListe);
        ausgeben(args, notenListe);
    }

    /**
     * liest die Namen von F&auml;chern mit den zugeh&ouml;rigen Beurteilungen
     * in eine verkettete Liste ein.<br>
     * Jede Eingabezeile muss einen Fachnamen und eine Beurteilung enthalten.
     * <p>
     * Fachnamen m&uuml;ssen laut
     * {@link aufgabe6.Faecher#istZulaessig} erlaubt sein.</p>
     * <p>
     * Bei unbenoteten F&auml;chern muss die Beurteilung
     * <code>BE</code> f&uuml;r bestanden oder
     * <code>NB</code> f&uuml;r nicht bestanden lauten.</p>
     * <p>
     * Bei benoteten F&auml;chern muss die Note laut
     * {@link aufgabe4.Noten#istZulaessig} erlaubt sein.</p>
     * @param notenListe die Liste, in die die Fachnoten einzulesen sind
     * @throws IOException bei Einleseproblemen
     */
    private static void einlesen(final FachNotenListe notenListe)
        throws IOException {

        System.err.println("Faecher mit Noten eingeben (Ende mit Strg-D):");
        final BufferedReader eingabe
            = new BufferedReader(new InputStreamReader(System.in));

        String zeile;
        while ((zeile = eingabe.readLine()) != null) {
            zeile = zeile.trim();
            if (zeile.length() == 0) {
                continue; // Leerzeile
            }

            try {
                String[] woerter = zeile.split("\\s+");
                if (woerter.length < 2) {
                    throw new IllegalArgumentException(
                        "unvollstaendige Zeile " + zeile);
                }

                String note = woerter[woerter.length - 1];
                String fach = zeile.substring(0, zeile.lastIndexOf(note));

                Leistung fachnote;
                if (note.equals("BE")) {
                    fachnote = new UnbenoteteLeistung(fach.trim(), true);
                } else if (note.equals("NB")) {
                    fachnote = new UnbenoteteLeistung(fach.trim(), false);
                } else {
                    fachnote = new BenoteteLeistung(fach.trim(), note);
                }

                notenListe.insert(fachnote);
            } catch (IllegalArgumentException x) {
                System.err.printf("Falscheingabe ignoriert: %s%n",
                                  x.getMessage());
                continue;
            }
        }
    }

    /**
     * schreibt einen Notenspiegel im HTML-Format.
     * @param name Vorname(n) und Nachname
     * @param notenListe die Fachnoten
     */
    private static void ausgeben(final String[] name,
                                 final FachNotenListe notenListe)
        throws IOException {

        StringBuilder sb = new StringBuilder();
        for (String s : name) {
            sb.append(s);
        }

        try {
            PrintWriter ausgabe
                = new PrintWriter(sb.toString() + ".html", "UTF-8");
            HtmlFormat.ausgeben(ausgabe, name, notenListe);
            ausgabe.close();

            ausgabe = new PrintWriter(sb.toString() + ".txt", "UTF-8");
            TextFormat.ausgeben(ausgabe, name, notenListe);
            ausgabe.close();
        } catch (FileNotFoundException x) {
            System.err.println(x.getMessage());
            System.exit(1);
        }
    }
}

