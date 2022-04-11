// ByteVar.java

package aufgabe1;

import java.util.Scanner;

/**
 * ByteVar zeigt den Umgang mit Variablen vom Typ byte.
 * %Uuml;bungsaufgabe 1 zur Programmiertechnik 1.
 * @author Tim Koehler
 * @version 23.10.18
 */
public final class ByteVar {
    private ByteVar() { }

    private static final Scanner EINGABE = new Scanner(System.in);

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(final String[] args) {

        /* Konstanten min und max definieren */
        final byte min = Byte.MAX_VALUE;
        final byte max = Byte.MIN_VALUE;


        /* Eingabeaufforderung ausgeben */
        System.out.printf("Zwei ganze Zahlen zwischen %d"
            + " und %d eingeben: %n", min, max);


        /* zwei ganze Zahlen einlesen */
        byte num1 = EINGABE.nextByte();
        byte num2 = EINGABE.nextByte();


        /* die beiden Zahlen dezimal, okatal und
          hexadezimal ausgeben */
        System.out.printf("%d ist oktal %o und hexadezimal %x%n",
            num1, num1, num1);
        System.out.printf("%d ist oktal %o und hexadezimal %x%n",
            num2, num2, num2);

        /* alle zweistelligen arithmetischen Operatoren ausprobieren */
        System.out.printf("%d + %d ist %d%n", num1, num2, num1 + num2);
        System.out.printf("%d - %d ist %d%n", num1, num2, num1 - num2);
        System.out.printf("%d * %d ist %d%n", num1, num2, num1 * num2);
        System.out.printf("%d / %d ist %d%n", num1, num2, num1 / num2);
        System.out.printf("%d %% %d ist %d%n", num1, num2, num1 % num2);


        /* alle Vergleichsoperatoren ausprobieren */
        System.out.printf("%d == %d ist %b%n", num1, num2, num1 == num2);
        System.out.printf("%d != %d ist %b%n", num1, num2, num1 != num2);
        System.out.printf("%d < %d ist %b%n", num1, num2, num1 < num2);
        System.out.printf("%d <= %d ist %b%n", num1, num2, num1 <= num2);
        System.out.printf("%d > %d ist %b%n", num1, num2, num1 > num2);
        System.out.printf("%d >= %d ist %b%n", num1, num2, num1 >= num2);
    }
}

