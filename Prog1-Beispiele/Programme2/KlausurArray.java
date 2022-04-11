// KlausurArray.java

/**
 * KlausurArray gibt eine Punkteliste f&uuml;r Klausuraufgaben aus.
 * Beispielprogramm zur Programmiertechnik 1, Teil 2.
 * @author H.Drachenfels
 * @version 5.2.2016
 */
public final class KlausurArray {
    private KlausurArray() { }

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(final String[] args) {
        int[] punkte = {12, 8, 10};

        for (int i = 0; i < punkte.length; ++i) {
            System.out.printf("Aufgabe %d: %d Punkte%n", i + 1, punkte[i]);
        }
    }
}