// ObjectInit.java
import static java.lang.System.out;

/**
 * ObjectInit zeigt Varianten von Intialisierungscode.
 * Beispielprogramm zur Programmiertechnik 1, Teil 4.
 * @author H.Drachenfels
 * @version 28.4.2017
 */
public final class ObjectInit {
    private ObjectInit() { }

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(final String[] args) {
        Beispiel x = new Beispiel();
        Beispiel y = new Beispiel(4);

        out.printf("%s: %d%d%d%d%n", x, x.a, x.b, x.c, x.d);
        out.printf("%s: %d%d%d%d%n", y, y.a, y.b, y.c, y.d);
    }
}

final class Beispiel {
    public int a; // implizit = 0
    public int b = a + 1; // explizite Variableninitialisierung
    public int c; // implizit = 0
    public int d; // implizit = 0

    // Initialisierungsblock
    {
        c = b + 1;
    }

    /**
     * Standardkonstruktor.
     */
    public Beispiel() {
        // super();
        // a = 0;     (Standardwert)
        // b = a + 1; (explizite Variableninitialisierung)
        // c = 0;     (Standardwert)
        // d = 0;     (Standardwert)
        // c = b + 1; (Initialisierungsblock)
        d = c + 1;
    }

    /**
     * Konstruktor mit Parameter.
     * @param i eine ganze Zahl.
     */
    public Beispiel(final int i) {
        // super();
        // a = 0;     (Standardwert)
        // b = a + 1; (explizite Variableninitialisierung)
        // c = 0;     (Standardwert)
        // d = 0;     (Standardwert)
        // c = b + 1; (Initialisierungsblock)
        a = i;
        d = a + 1;
    }
}

