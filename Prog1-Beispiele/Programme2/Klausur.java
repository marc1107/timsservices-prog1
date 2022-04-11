// Klausur.java

/**
 * Klausur gibt eine Punkteliste f&uuml;r Klausuraufgaben aus.
 * Beispielprogramm zur Programmiertechnik 1, Teil 2.
 * @author H.Drachenfels
 * @version 1.4.2015
 */
public final class Klausur {
    private Klausur() { }

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(final String[] args) {
        int punkteAufgabe_1 = 12;
        int punkteAufgabe_2 = 8;
        int punkteAufgabe_3 = 10;

        System.out.printf("Aufgabe 1: %d Punkte%n", punkteAufgabe_1);
        System.out.printf("Aufgabe 2: %d Punkte%n", punkteAufgabe_2);
        System.out.printf("Aufgabe 3: %d Punkte%n", punkteAufgabe_3);
    }
}