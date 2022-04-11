// Increment.java

/**
 * Increment testet den Operator ++.
 * Beispielprogramm zur Programmiertechnik 1, Teil 3.
 * @author H.Drachenfels
 * @version 5.4.2012
 */
public final class Increment {
    private Increment() { }

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(final String[] args) {
        int i = 1;
        System.out.println(++i); // 2
        System.out.println(i++); // 2
        System.out.println(i);   // 3

        // das gleiche ohne Kurzschreibweise ++:
        i = 1;
        System.out.println(i = i + 1);    // 2
        System.out.println(i); i = i + 1; // 2
        System.out.println(i);            // 3

        // mehrfache Anwendung funktioniert nicht (nur auf Variablen anwendba

        //System.out.println(++++i);
        //System.out.println(i++++);
        //System.out.println(++i++);
        //System.out.println((++i)++);

        double d = 1.2;
        System.out.println(++d); // 2.2

        char c = 'a';
        System.out.println(++c); // b
    }
}

