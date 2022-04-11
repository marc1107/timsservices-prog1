// FallunterscheidungMonth.java

import java.util.Scanner;
import java.util.NoSuchElementException;
import static java.lang.System.in;
import static java.lang.System.out;
import static java.lang.System.err;

/**
 * FallunterscheidungMonth gibt die Anzahl der Tage eines Monats aus.
 * Beispielprogramm zur Programmiertechnik 1, Teil 3.
 * @author H.Drachenfels
 * @version 18.2.2011
 */
public final class FallunterscheidungMonth {
    private FallunterscheidungMonth() { }

    private enum Month {
        JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC
    }

    private static final Scanner EINGABE = new Scanner(in);

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(final String[] args) {
        out.print("Monat eingeben [ ");
        for (Month m : Month.values()) {
            out.printf("%s ", m);
        }
        out.print("]: ");

        try {
            Month m = Month.valueOf(EINGABE.next());

            switch (m) {
            case FEB:
                out.println("28 oder 29 Tage");
                break;
            case APR:
            case JUN:
            case SEP:
            case NOV:
                out.println("30 Tage");
                break;
            default:
                out.println("31 Tage");
            }
        } catch (NoSuchElementException x) {
            err.println("Fehler: keine Eingabe");
        } catch (IllegalArgumentException x) {
            err.println("Fehler: kein Monat");
        }
    }
}

