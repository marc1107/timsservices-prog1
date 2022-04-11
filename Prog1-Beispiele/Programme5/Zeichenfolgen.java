// Zeichenfolgen.java

/**
 * Zeichenfolgen zeigt den Umgang mit der Schnittstelle CharSequence.
 * Beispielprogramm zur Programmiertechnik 1, Teil 5.
 * @author H.Drachenfels
 * @version 5.8.2016
 */
public final class Zeichenfolgen {
    private Zeichenfolgen() { }

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwnedet
     */
    public static void main(final String[] args) {
        CharSequence[] beispiele = {
            "Hallo",
            new StringBuilder("Hi"),
            new LeereZeichenfolge()
        };

        for (CharSequence cs : beispiele) {
            System.out.println(cs.length());
            if (cs.length() > 0) {
                System.out.printf("%c%s%n",
                                  cs.charAt(0),
                                  cs.subSequence(1, cs.length()));
            }
        }
    }
}

/**
 * LeereZeichenfolgen zeigt die Implementierung der Schnittstelle CharSequenc

 */
final class LeereZeichenfolge implements CharSequence {
    @Override
    public char charAt(final int index) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public CharSequence subSequence(final int start, final int end) {
        if (start != 0 || end != 0) {
            throw new IndexOutOfBoundsException();
        }

        return this;
    }

    @Override
    public String toString() {
        return "";
    }
}

