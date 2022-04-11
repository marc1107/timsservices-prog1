// GroupedFormat.java
package format;

import java.text.NumberFormat;

/**
 * GroupedFormat ist eine Formatierer f&uuml;r ganze Zahlen.
 * Beispielprogramm zur Programmiertechnik 1, Teil 5.
 * @author H.Drachenfels
 * @version 5.8.2016
 */
public final class GroupedFormat implements Formatter {
    /**
     * format formatiert ganze Zahlen dezimal mit Tausenderpunktierung.
     * @param n eine ganze Zahl.
     * @return eine String mit der dezimalen Darstellung von n.
     */
    @Override
    public String format(final int n) {
        NumberFormat nf = NumberFormat.getIntegerInstance();
        nf.setGroupingUsed(true);
        return nf.format(n);
    }
}

