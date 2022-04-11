// Notenstatistik.java
package aufgabe4;

import java.util.Locale;
import java.util.Scanner;
import aufgabe4.schweiz.Noten;

/**
 * erstellt eine Notenstatistik.
 * <p>
 * Das Programm erwartet Pr&uuml;fungsnoten im Format
 * <code>Ganze,Zehntel</code> oder <code>Ganze.Zehntel</code>,
 * wobei <code>Ganze</code> und <code>Zehntel</code> nur aus
 * je einer Dezimalziffer bestehen d&uuml;rfen.
 * Andere Eingaben werden wegen Formatfehler ignoriert.
 * </p>
 * <p>
 * Das Programm gibt die folgende Statistik aus:
 * </p>
 * <ul>
 * <li>die Anzahl der ber&uuml;cksichtigten Noten</li>
 * <li>die Anzahl der Bestandenen</li>
 * <li>die beste Note</li>
 * <li>die schlechteste Note</li>
 * <li>den Durchschnitt der Bestandenen</li>
 * <li>die Durchfallquote in Prozent</li>
 * </ul>
 * <p>
 * Es werden in der Statistik nur die nach HTWG-Pr&uuml;fungsordnung
 * zul&auml;ssigen Noten (1,0 1,3 1,7 2,0 2,3 2,7 3,0 3,3 3,7 4,0 5,0)
 * ber&uuml;cksichtigt.
 * Andere Eingaben werden wegen falscher Vorkommastelle oder
 * falscher Nachkommastelle ignoriert.
 * Alle Noten bis 4,0 gelten als bestandenDurchschnitt,
 *     nur die 5,0 als durchgefallen.
 * </p>
 *
 * @author Tim Koehler
 * @version 23.11.18
 */
public final class KlausurErgebnisBonus {
    private KlausurErgebnisBonus() { }

    private static final Scanner EINGABE = new Scanner(System.in);

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(final String[] args) {
        Locale.setDefault(Locale.GERMANY);
        //--------------------------------------------------- Noten einlesen
        System.out.println("Noten im Format Ganze,Zehntel "
                           + "oder Ganze.Zehntel eingeben (Ende mit Strg-D):");

        final float hundretPercent = 100.0f;
        int beruecksichtigteNoten = 0;
        int bestanden = 0;
        int durchgefallen = 0;

        double summeAllerNoten = 0.0f;
        double besteNote = Noten.SCHLECHTESTE;
        double schlechtesteNote = Noten.BESTE;

        while (EINGABE.hasNext()) {
            String note = EINGABE.next();

            if (!Noten.istZulaessig(note)) {
                System.out.println("Unzulaessige Note " + note
                    + " wird ignoriert!");
                continue;
            }

            //---------------------------------------------Note erfassen
            note = note.replace(',', '.');

            double currentNote = Noten.toDouble(note);

            schlechtesteNote = Noten.schlechtere(currentNote, schlechtesteNote);

            besteNote = Noten.bessere(currentNote, besteNote);

            if (Noten.istBestanden(currentNote)) {
                summeAllerNoten += currentNote;
                bestanden++;
            } else {
                durchgefallen++;
            }

            beruecksichtigteNoten++;
        }

        //---------------------------------------Notenstatistik ausgeben
        System.out.println("");
        System.out.println("Anzahl beruecksichtigter Noten: "
            + beruecksichtigteNoten);
        System.out.println("Anzahl Bestandene: " + bestanden);

        if (beruecksichtigteNoten <= 0) {
            return;
        }

        System.out.printf("Beste Note: %.1f%n", besteNote);
        System.out.printf("Schlechteste Note: %.1f%n",
            schlechtesteNote);
        System.out.printf("Durchschnitt Bestandene: %.1f%n",
            summeAllerNoten / bestanden);
        System.out.printf("Durchfallquote: %.1f%%%n",
            (((double) durchgefallen
                / beruecksichtigteNoten) * hundretPercent));
    } // main
}
