package aufgabe4.schweiz;

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
public final class Noten 
{
    private Noten() { }

    public static final double BESTE = 6.0;
    public static final double SCHLECHTESTE = 1.0;
    public static final int MAX_CHARS = 3;

    /**
     * Ueberprueft ob der uebergebene String eine zulaessige Note ist.
     * @param note Zu ueberuefender String
     * @return true wenn der String eine zulaessige Note ist
     */
    public static boolean istZulaessig(final String note) {

        return Pattern.matches("(^[1-6][,.][5]$)|(^[1-6]$)", note);
        
        //Solutions without regex
        /*if(note.length() == MAX_CHARS) {


            if (note.charAt(1) != '.' && note.charAt(1) != ',') {
                return false;
            }

            if (!Character.isDigit(note.charAt(0))
                    || !Character.isDigit(note.charAt(2))) {
                return false;
            }

            switch (note.charAt(0)) {
            case '6':
            case '5':
            case '4':
            case '3':
            case '2':
            case '1':
                if (note.charAt(2) == '5') {
                    break;
                } else {
                    return false;
                }
            default:
                return false;
            }
            return true;
        }
        else if (note.length() == 1) {

            if (!Character.isDigit(note.charAt(0))) {
                return false;
            }

            int noteAsNumber = Character.getNumericValue(note.charAt(0));
            if(noteAsNumber >= 1 && noteAsNumber <= 6) {
                return true;
            }

            return false;
        } else {
            return false;
        }*/
    }

    /**
     * Konvertiert String zu double.
     * @param s Zu konvertierender String
     * @return String als double
     */
    public static double toDouble(final String s) {

        if(istZulaessig(s)) {
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
        
        if(istZulaessig(String.valueOf(d))) {
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
        
        if(note >= BESTE - 2.0) {
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
        
        return Math.max(note1, note2);
    }

    /**
     * Gibt die schlechtere der beiden Noten zurueck.
     * @param note1 Note1
     * @param note2 Note2
     * @return Die schlechtere der beiden Noten
     */
    public static double schlechtere(final double note1, final double note2) {
        
        return Math.min(note1, note2);
    }
}