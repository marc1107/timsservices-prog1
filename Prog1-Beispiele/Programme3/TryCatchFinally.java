// TryCatchFinally.java
import java.util.Scanner;

/**
 * TryCatchFinally testet die try-catch-finally-Anweisung.
 * Beispielprogramm zur Programmiertechnik 1, Teil 3.
 * @author H.Drachenfels
 * @version 7.11.2018
 */
public final class TryCatchFinally {
    private TryCatchFinally() { }

    private static final Scanner EINGABE = new Scanner(System.in);

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(final String[] args) {
        try {
            System.out.print("Eingabe: ");
            int n = EINGABE.nextInt();
            if (n >= 0) {
                System.out.println(1);
            } else {
                System.out.println(2);
                return;
            }
        } catch (Exception x) {
            if (EINGABE.hasNext()) {
                System.out.println(3);
            } else {
                System.out.println(4);
                return;
            }
        } finally {
            System.out.println(5);
        }

        System.out.println(6);
    }
}

