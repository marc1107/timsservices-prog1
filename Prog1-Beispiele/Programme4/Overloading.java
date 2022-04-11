// Overloading.java

/**
 * Overloading zeigt das Ueberladen von Methoden.
 * Beispielprogramm zur Programmiertechnik 1, Teil 4.
 * @author H.Drachenfels
 * @version 21.12.2009
 */
public final class Overloading {
    /** Es soll keine Instanzen der Klasse geben. */
    private Overloading() { }

    /**
     * max bildet das Maximum zweier ganzer Zahlen.
     * @param a ist die eine ganze Zahl.
     * @param b ist die andere ganze Zahl.
     * @return das Maximum der beiden Argumente.
     */
    private static int max(final int a, final int b) {
        return a > b ? a : b;
    }

    /**
     * max bildet das Maximum dreier ganzer Zahlen.
     * @param a ist die erste ganze Zahl.
     * @param b ist die zweite ganze Zahl.
     * @param c ist die dritte ganze Zahl.
     * @return das Maximum der drei Argumente.
     */
    private static int max(final int a, final int b, final int c) {
        return max(a, max(b, c));
    }

    /**
     * max bildet das Maximum zweier Gleitkommazahlen.
     * @param a ist die eine Gleitkommazahl.
     * @param b ist die andere Gleitkommazahl.
     * @return das Maximum der beiden Argumente.
     */
    private static double max(final double a, final double b) {
        return a > b ? a : b;
    }

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(final String[] args) {
        System.out.println(max(1, 2));
        System.out.println(max(1, 2, 3));
        System.out.println(max(1, 2.3));
    }
}

