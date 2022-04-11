// LeereAnweisung.java

import static java.lang.System.out;

/**
 * LeereAnweisung zeigt Fehlerquelle durch leere Anweisung.
 * Beispielprogramm zur Programmiertechnik 1, Teil 3.
 * @author H.Drachenfels
 * @version 31.10.2011
 */
public final class LeereAnweisung {
    private LeereAnweisung() { }

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(final String[] args) {
        int[] a = {10, 20, 30, 40};

        // for (int i = 0; i < a.length; ++i); // bewirkt Syntaxfehler
        for (int i = 0; i < a.length; ++i)
            out.println(a[i]);

        int i;
        for (i = 0; i < a.length; ++i); // bewirkt Laufzeitfehler
            out.println(a[i]);
    }
}

