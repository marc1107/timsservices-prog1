// IntLiteral.java

/**
 * IntLiteral zeigt die Ausgabe von Zahlenliteralen auf der Konsole.
 * Beispielprogramm zur Programmiertechnik 1, Teil 2.
 * @author H.Drachenfels
 * @version 16.2.2011
 */
public final class IntLiteral {
    private IntLiteral() { }

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(final String[] args) {
        System.out.println(12);
        System.out.println(012);
        System.out.println(0x12);
        System.out.printf("%x%n", 12);
        System.out.printf("%d%n", 012);
        System.out.printf("%o%n", 0x12);
    }
}