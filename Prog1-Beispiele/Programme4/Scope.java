// Scope.java

/**
 * Scope zeigt den G&uuml;ltigkeitsbereich von Variablen.
 * Beispielprogramm zur Programmiertechnik 1, Teil 4.
 * @author H.Drachenfels
 * @version 18.11.2014
 */
public final class Scope {
    private Scope() { }

    private static int i = 1; // globale Variable mit Scope Klasse

    static {
        System.out.println(i); // gibt 1 aus
    }

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(final String[] args) {
        int i = 2; // lokale Variable mit Scope Methodenrumpf

        for (int ii = 3; ii <= 3; ++ii) { // lokale Variable mit Scope Schlei


            {
                int iii = 4; // lokale Variable mit Scope Anweisungsblock
                System.out.printf("%d %d %d %d%n",
                                  iii, ii, i, Scope.i); // gibt 4 3 2 1 aus
            }

            // kein iii mehr
            System.out.printf("%d %d %d%n", ii, i, Scope.i); // gibt 3 2 1 au

        }

        // kein ii mehr
        System.out.printf("%d %d%n", i, Scope.i); // gibt 2 1 aus

        m(5);
        m();
    }

    private static void m(final int i) { // Parameter mit Scope Methodenrumpf
        System.out.printf("%d %d%n", i, Scope.i); // gibt 5 1 aus
    }

    private static void m() {
        System.out.println(i); // gibt 1 aus
    }
}

