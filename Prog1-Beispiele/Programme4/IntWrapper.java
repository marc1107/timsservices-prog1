// IntWrapper.java

/**
 * IntWrapper zeigt Autoboxing und Autounboxing von ganzen Zahlen.
 * @author H.Drachenfels
 * @version 9.5.2017
 */
public final class IntWrapper {
    private IntWrapper() { }

    /**
     * main ist der Startpunkt des Programms.
     * @param args Feld der L&auml;nge 1
     *             mit String-Darstellung einer ganzen Zahl
     */
    public static void main(final String[] args) {
        if (args.length != 1) {
            System.err.println("Aufruf: java IntWrapper <Zahl>");
            System.exit(1);
        }

        int zahl = Integer.parseInt(args[0]);

        {
            int i1 = zahl;
            int i2 = zahl * 2;
            int i3 = i1 + i1;
            if (i3 == i2) {
                System.out.printf("%d == %d%n", i3, i2);
            } else {
                throw new RuntimeException(i3 + " != " + i2);
            }
        }

        {
            Integer i1 = zahl;     // Integer.valueOf(zahl)
            Integer i2 = zahl * 2; // Integer.valueOf(zahl * 2)
            Integer i3 = i1 + i1;  // Integer.valueOf(i1.intValue() + i1.intV
e())
            if (i3 == i2) { // Identitaet! Richtig waere: i3.equals(i2)
                System.out.printf("%d == %d%n", i3, i2); // von -128 bis +127
            } else {
                throw new RuntimeException(i3 + " != " + i2);
            }
        }

    }
}

