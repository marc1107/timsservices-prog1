// Notenstatistik.java
package aufgabe3;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

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
 * Alle Noten bis 4,0 gelten als bestandenDurchschnitt, nur die 5,0 als
 * durchgefallen.
 * </p>
 *
 * @author Tim Koehler
 * @version 14.11.18
 */
public final class NotenstatistikBonus {
    private NotenstatistikBonus() { }

    private static final Scanner EINGABE = new Scanner(System.in);

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(final String[] args) {
        Locale.setDefault(Locale.GERMANY);

        //----------------------------------------------Noten einlesen
        System.out.println("Noten im Format Ganze,Zehntel "
                           + "oder Ganze.Zehntel eingeben "
                               + "(Ende mit Strg-D):");
        final float note4 = 4.0f;
        final float note5 = 5.0f;
        final int maxAllowedChars = 3;
        final float hundretPercent = 100.0f;
        int beruecksichtigteNoten = 0;
        int bestanden = 0;
        float summeAllerNoten = 0.0f;
        float besteNote = note5;
        float schlechtesteNote = 1.0f;
        float durchgefallen = 0;

        while (EINGABE.hasNext()) {

            String note  = EINGABE.next();

            try {

                if (note.length() > maxAllowedChars || note.length() <= 0) {
                    throw new InputMismatchException("Note " + note
                        + " wird wegen Formatfehler ignoriert!");
                }

                if (note.length() == maxAllowedChars) {

                    if (note.charAt(1) != '.'
                        && note.charAt(1) != ',') {
                        throw new InputMismatchException("Note "
                            + note
                                + " wird wegen Formatfehler "
                                    + "ignoriert!");
                    }

                    if (!Character.isDigit(note.charAt(0))
                        || !Character.isDigit(note.charAt(2))) {
                        throw new InputMismatchException("Note "
                            + note + "wird wegen Formatfehler "
                                + "ignoriert!");
                    }

                } else if (note.length() == 2) {
                    if (!Character.isDigit(note.charAt(0))) {
                        throw new InputMismatchException("Note "
                            + note + " wird wegen Formatfehler "
                                + "ignoriert!");
                    }

                    if (note.charAt(1) != '+'
                        && note.charAt(1) != '-') {
                        throw new InputMismatchException("Note "
                            + note + " wird wegen Formatfehler "
                                + "ignoriert!");
                    }

                    int vorKomma = Integer.parseInt(note.charAt(0)
                        + "");

                    if (note.charAt(1) == '+') {
                        vorKomma--;
                        note = vorKomma + ".7";
                    } else {
                        note = vorKomma + ".3";
                    }

                } else {
                    if (!Character.isDigit(note.charAt(0))) {
                        throw new InputMismatchException("Note "
                            + note + " wird wegen Formatfehler "
                                + "ignoriert!");
                    }

                    note = note.charAt(0) + ".0";
                }

                switch (note.charAt(0)) {
                case '1':
                case '2':
                case '3':
                    if (note.charAt(2) == '0'
                        || note.charAt(2) == '3'
                            || note.charAt(2) == '7') {
                        break;
                    } else {
                        throw new InputMismatchException("Note "
                            + note + " wird wegen Nachkommastelle "
                                + note.charAt(2) + " ignoriert!");
                    }
                case '4':
                case '5':
                    if ((note.charAt(2) == '0')) {
                        break;
                    } else {
                        throw new InputMismatchException("Note "
                            + note + " wird wegen Nachkommastelle "
                               + note.charAt(2) + " ignoriert!");
                    }
                default:
                    throw new InputMismatchException("Note "
                        + note + " wird wegen Vorkommastelle "
                            + note.charAt(0) + " ignoriert!");
                }

            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                continue;
            }
            //-------------------------------------------Note erfassen
            note = note.replace(',', '.');
            float currentNote = Float.parseFloat(note);

            if (currentNote > schlechtesteNote) {
                schlechtesteNote = currentNote;
            }

            if (currentNote < besteNote) {
                besteNote = currentNote;
            }

            if (currentNote <= note4) {
                summeAllerNoten += currentNote;
                bestanden++;
            }
            if (currentNote == note5) {
                durchgefallen++;
            }
            beruecksichtigteNoten++;
        } // while
        //--------------------------------------Notenstatistik ausgeben
        System.out.println("");
        System.out.println("Anzahl beruecksichtigter Noten: "
            + beruecksichtigteNoten);
        System.out.println("Anzahl Bestandene: "
            + bestanden);

        if (beruecksichtigteNoten <= 0) {
            return;
        }
        System.out.printf("Beste Note: %.1f%n", besteNote);
        System.out.printf("Schlechteste Note: %.1f%n", schlechtesteNote);
        System.out.printf("Durchschnitt Bestandene: %.1f%n",
            summeAllerNoten / bestanden);
        System.out.printf("Durchfallquote: %.1f%%%n",
            ((durchgefallen / beruecksichtigteNoten) * hundretPercent));
    } // main
}
