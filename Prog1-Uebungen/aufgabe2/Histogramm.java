// Histogramm.java
package aufgabe2;

import java.util.Scanner;

/**
 * Histogramm liest ganze Zahlen zwischen 1 und 6 ein und
 * gibt deren H&auml;ufigkeitsverteilung als Histogramm aus.
 * @author Tim Koehler
 * @version 30.10.18
 */
public final class Histogramm {
    private Histogramm() { }

    private static final Scanner EINGABE = new Scanner(System.in);

    private static final int MAX_NUMBER = 6;
    private static final int DELIMETER_COUNT = 5;
    private static final int TERMINAL_SIZE = 50;

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(final String[] args) {

        int[] counter = new int[MAX_NUMBER];

        //-------------------------------------------------- Zahlen einlesen
        System.out.println("Ganze Zahlen zwischen 1 und 6 eingeben "
                    + "(Ende mit Strg-D):");

        while (EINGABE.hasNext()) {
            int number = EINGABE.nextInt();

            if (number >= 1 && number <= MAX_NUMBER) {
                counter[number - 1] += 1;
            } else {
                System.out.println("Falsche Eingabe wird ignoriert: "
                    + number);
            }
        }

        //---------------------------------------------- Histogramm ausgeben

        System.out.println("Histogram:");

        standard(counter);
        System.out.println("------------------------------------------");
        bonus1(counter);
        System.out.println("------------------------------------------");
        bonus2(counter);
        System.out.println("------------------------------------------");
        bonus3(counter);
    }

    private static void standard(final int[] counter) {

        for (int i = 0; i < counter.length; i++) {

            for (int x = 0; x < counter[i]; x++) {

                if ((x + 1) % DELIMETER_COUNT == 0) {
                    System.out.print("$");
                } else {
                    System.out.printf("%d", i + 1);
                }
            }
            System.out.printf(" (%d)%n", counter[i]);
        }
    }

    private static void bonus1(final int[] counter) {

        int max = counter[0];
        for (int i = 1; i < counter.length; i++) {
            if (max < counter[i]) {
                max = counter[i];
            }
        }

        int n = max / TERMINAL_SIZE + 1;

        for (int i = 0; i < counter.length; i++) {
            for (int x = 0; x < counter[i] / n; x++) {
                if ((x + 1) % DELIMETER_COUNT == 0) {
                    System.out.print("$");
                } else {
                    System.out.printf("%d", i + 1);
                }
            }
            System.out.printf(" (%d)%n", counter[i]);
        }
    }

    private static void bonus2(final int[] counter) {

        int min = counter[0];
        for (int i = 1; i < counter.length; i++) {
            if (min > counter[i]) {
                min = counter[i];
            }
        }

        min--;

        for (int i = 0; i < counter.length; i++) {

            for (int x = min; x < counter[i]; x++) {

                if ((x + 1) % DELIMETER_COUNT == 0) {
                    System.out.print("$");
                } else {
                    System.out.printf("%d", i + 1);
                }
            }
            System.out.printf(" (%d)%n", counter[i]);
        }
    }

    private static void bonus3(final int[] counter) {

        int i = 1;

        while (counter[0] > 0 || counter[1] > 0 ||  counter[2] > 0
            ||  counter[3] > 0 ||  counter[4] > 0 ||  counter[5] > 0) {
            for (int x = 0; x < counter.length; x++) {
                if (counter[x] > 0) {
                    System.out.printf("%d ", x + 1);
                    counter[x] -= 1;
                } else {
                    System.out.print("  ");
                }
            }
            System.out.printf("   (%d)%n", i);
            i++;
        }
    }
}
