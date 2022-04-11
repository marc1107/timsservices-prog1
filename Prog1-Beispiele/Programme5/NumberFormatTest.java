// NumberFormatTest.java
import java.text.NumberFormat;
import java.util.Locale;

/**
 * NumberFormatTest zeigt den Umgang mit der Klasse java.text.NumberFormat.
 * Beispielprogramm zur Programmiertechnik 1, Teil 5.
 * @author H.Drachenfels
 * @version 5.8.2016
 */
public final class NumberFormatTest {
    private NumberFormatTest() { }

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwnedet
     */
    public static void main(final String[] args) {

        NumberFormat[] zahlFormate = {
            NumberFormat.getInstance(),
            NumberFormat.getIntegerInstance(),
            NumberFormat.getPercentInstance(),
            NumberFormat.getCurrencyInstance(),
            NumberFormat.getInstance(Locale.GERMAN),
            NumberFormat.getIntegerInstance(Locale.GERMAN),
            NumberFormat.getPercentInstance(Locale.GERMAN),
            NumberFormat.getCurrencyInstance(Locale.GERMAN),
            //NumberFormat.getCurrencyInstance(Locale.GERMANY),
            NumberFormat.getInstance(Locale.ENGLISH),
            NumberFormat.getIntegerInstance(Locale.ENGLISH),
            NumberFormat.getPercentInstance(Locale.ENGLISH),
            NumberFormat.getCurrencyInstance(Locale.ENGLISH),
            //NumberFormat.getCurrencyInstance(Locale.UK),
            //NumberFormat.getCurrencyInstance(Locale.US),
        };

        for (NumberFormat nf : zahlFormate) {
            System.out.printf("%s %s%n", nf.format(12.34), nf.format(5.678));
        }
    }
}

