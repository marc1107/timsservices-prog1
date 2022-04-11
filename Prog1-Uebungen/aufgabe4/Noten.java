package aufgabe4;

import java.util.regex.Pattern;

/**
 * .
 * <p>
 *
 * </p>
 *
 * @author Tim Koehler
 * @version 23.11.18
 */
public final class Noten {

    private Noten() { }

    /**
     * Beste moegliche Note.
    */
    public static final double BESTE = 1.0;

    /**
     * Schlechteste moegliche Note.
     */
    public static final double SCHLECHTESTE = 5.0;

    /**
     * Maximale laenge des input Strings.
     */
    public static final int MAX_CHARS = 3;

    /**
     * Ueberprueft ob der uebergebene String eine zulaessige Note ist.
     * @param note Zu ueberuefender String
     * @return true wenn der String eine zulaessige Note ist
     */
    public static boolean istZulaessig(final String note) {

        return Pattern.matches("(^[1-3][,.][037]$)|(^[45][,.]0$)", note);
        
        // Solution without regex
        /*
        if (note.length() != MAX_CHARS) {
            return false;
        }

        if (note.charAt(1) != '.' && note.charAt(1) != ',') {
            return false;
        }

        if (!Character.isDigit(note.charAt(0))
                || !Character.isDigit(note.charAt(2))) {
            return false;
        }

        switch (note.charAt(0)) {
        case '1':
        case '2':
        case '3':
            if (note.charAt(2) == '0' || note.charAt(2) == '3'
                || note.charAt(2) == '7') {
                break;
            } else {
                return false;
            }
        case '4':
        case '5':
            if ((note.charAt(2) == '0')) {
                break;
            } else {
                return false;
            }
        default:
            return false;
        }
        return true;*/
    }

    /**
     * Konvertiert String zu double.
     * @param s Zu konvertierender String
     * @return String als double
     */
    public static double toDouble(final String s) {

        if (istZulaessig(s)) {
            return Double.parseDouble(s);
        }
        throw new IllegalArgumentException();
    }

    /**
     * Konvertiert double zu String.
     * @param d Zu konvertierender double
     * @return double als String
     */
    public static String toString(final double d) {

        if (istZulaessig(String.valueOf(d))) {
            return String.format("%.1f", d);
        }
        throw new IllegalArgumentException();
    }

    /**
     * Ueberprueft ob die uebergebene note bestanden hat.
     * @param note zu ueberpuefende Note
     * @return true wenn note bestanden hat
     */
    public static boolean istBestanden(final double note) {

        if (note <= SCHLECHTESTE - 1.0) {
            return true;
        }

        return false;
    }

    /**
     * Gibt die bessere der beiden Noten zurueck.
     * @param note1 Note1
     * @param note2 Note2
     * @return Die bessere der beiden Noten
     */
    public static double bessere(final double note1, final double note2) {
        return Math.min(note1, note2);
    }

    /**
     * Gibt die schlechtere der beiden Noten zurueck.
     * @param note1 Note1
     * @param note2 Note2
     * @return Die schlechtere der beiden Noten
     */
    public static double schlechtere(final double note1, final double note2) {

        return Math.max(note1, note2);
    }
}