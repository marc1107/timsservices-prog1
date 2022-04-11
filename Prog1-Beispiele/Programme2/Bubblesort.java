// Bubblesort.java

import java.util.Scanner;
import static java.lang.System.out;
import static java.lang.System.in;

/**
 * Bubblesort liest ganze Zahlen ein und sortiert sie aufsteigend.
 * Beispielprogramm zur Programmiertechnik 1, Teil 2.
 * @author H.Drachenfels
 * @version 4.8.2010
 */
public final class Bubblesort {
    private Bubblesort() { }

    private static final Scanner EINGABE = new Scanner(in);

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(final String[] args) {
        //----------------------------------------------- Feldgroesse einlesen
        int anIntArraySize;
        out.print("Anzahl zu sortierender Werte eingeben: ");
        anIntArraySize = EINGABE.nextInt();

        //---------------------------------------------------- Zahlen einlesen
        int[] anIntArray = new int[anIntArraySize];
        out.printf("%d ganze Zahlen eingeben: ", anIntArraySize);

        for (int i = 0; i < anIntArray.length; ++i) {
            anIntArray[i] = EINGABE.nextInt();
        }

        //--------------------------------------------------- Zahlen sortieren
        for (int i = anIntArray.length; i > 1; i--) {
            // groessten Wert nach hinten schieben
            for (int j = 0; j < i - 1; ++j) {
                if (anIntArray[j] > anIntArray[j + 1]) {
                    // Werte tauschen
                    int tmp = anIntArray[j + 1];
                    anIntArray[j + 1] = anIntArray[j];
                    anIntArray[j] = tmp;
                }
            }
        }

        //---------------------------------------------------- Zahlen ausgeben
        out.print("Sortierte Zahlenfolge: ");

        for (int i = 0; i < anIntArray.length; ++i) {
            out.printf("%d ", anIntArray[i]);
        }

        out.println();
    }
}