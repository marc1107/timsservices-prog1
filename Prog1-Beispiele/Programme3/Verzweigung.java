// Verzweigung.java

import java.util.Scanner;
import static java.lang.System.out;
import static java.lang.System.in;

/**
 * Verzweigung liesst zwei Zahlen ein und gibt das Maximum aus.
 * Beispielprogramm zur Programmiertechnik 1, Teil 3.
 * @author H.Drachenfels
 * @version 18.2.2011
 */
public final class Verzweigung {
    private Verzweigung() { }

    private static final Scanner EINGABE = new Scanner(in);

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(final String[] args) {
        out.print("Zwei Zahlen eingeben: ");
        int m = EINGABE.nextInt();
        int n = EINGABE.nextInt();

        if (m == n) {
            out.println("Beide Zahlen sind gleich!");
        } else if (m > n) {
            out.printf("Maximum: %d%n", m);
        } else {
            out.printf("Maximum: %d%n", n);
        }
    }
}

