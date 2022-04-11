// BooleanVar.java

/**
 * BooleanVar zeigt den Umgang mit Variablen vom Typ boolean.
 * Beispielprogramm zur Programmiertechnik 1, Teil 2.
 * @author H.Drachenfels
 * @version 1.2.2016
 */
public final class BooleanVar {
    private BooleanVar() { }

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(final String[] args) {
        boolean aBool = true;

        System.out.printf("%b%n", 1 < 2);
        System.out.printf("%b%n", aBool);
        System.out.printf("%b%n", !aBool);
        System.out.println(aBool && !aBool);
        System.out.println(aBool || !aBool);

        if (aBool) {
            System.out.println("aBool ist true");
        } else {
            System.out.println("aBool ist false");
        }
    }
}