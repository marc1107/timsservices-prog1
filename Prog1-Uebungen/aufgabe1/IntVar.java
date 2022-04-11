// IntVar.java

package aufgabe1;

import java.util.Scanner;

/**
 * IntVar zeigt den Umgang mit Variablen vom Typ int.
 * %Uuml;bungsaufgabe 1 zur Programmiertechnik 1.
 * @author Tim Koehler
 * @version 22.10.18
 */
public final class IntVar {
    private IntVar() { }

    private static final Scanner EINGABE = new Scanner(System.in);

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(final String[] args) {

        /* Konstanten min und max definieren */
        final int min = Integer.MIN_VALUE;
        final int max = Integer.MAX_VALUE;


        /* Eingabeaufforderung ausgeben */
        System.out.printf("Zwei ganze Zahlen zwischen %d"
            + " und %d eingeben: %n", min, max);


        /* zwei ganze Zahlen einlesen */
        long num1 = 0;
        long num2 = 0;
        long ergebnis = 0;

        if (EINGABE.hasNextInt()) {
            num1 = EINGABE.nextInt();
        } else {
            System.out.println("Fehlerhafte eingabe!");
            return;
        }

        if (EINGABE.hasNextInt()) {
            num2 = EINGABE.nextInt();
        } else {
            System.out.println("Fehlerhafte eingabe!");
            return;
        }

        /* die beiden Zahlen dezimal, okatal und
        hexadezimal ausgeben */
        System.out.printf("%d ist oktal %o und hexadezimal %x%n",
            num1, num1, num1);
        System.out.printf("%d ist oktal %o und hexadezimal %x%n",
            num2, num2, num2);

        System.out.print("Operator eingeben: ");
        String operator = EINGABE.next();

        switch (operator) {
        case "+":
            ergebnis = num1 + num2;
            break;
        case "-":
            ergebnis = num1 - num2;
            break;
        case "*":
            ergebnis = num1 * num2;
            break;
        case "/":
            ergebnis = num1 / num2;
            break;
        case "%":
            ergebnis = num1 % num2;
            break;
        case "==":
            System.out.printf("%d == %d ist %b%n", num1, num2, num1 == num2);
            break;
        case "!=":
            System.out.printf("%d != %d ist %b%n", num1, num2, num1 != num2);
            break;
        case "<":
            System.out.printf("%d < %d ist %b%n", num1, num2, num1 < num2);
            break;
        case "<=":
            System.out.printf("%d <= %d ist %b%n", num1, num2, num1 <= num2);
            break;
        case ">":
            System.out.printf("%d > %d ist %b%n", num1, num2, num1 > num2);
            break;
        case ">=":
            System.out.printf("%d >= %d ist %b%n", num1, num2, num1 >= num2);
            break;
        default:
            System.out.println("Fehlerhafte Eingabe!");
            return;
        }

        if (ergebnis != 0) {
            if (ergebnis > Integer.MAX_VALUE || ergebnis < Integer.MIN_VALUE) {
                System.out.println("Ergebnis zu groß oder zu "
                    + "klein um als Integer dargestelt zu werden!");
            } else {
                if (!operator.equals("%")) {
                    System.out.printf("%d " + operator + " %d ist %d%n",
                        num1, num2, ergebnis);
                } else {
                    System.out.printf("%d %% %d ist %d%n",
                        num1, num2, ergebnis);
                }
            }
        }
    }
}
