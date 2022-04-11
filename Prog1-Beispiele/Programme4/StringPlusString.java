// StringPlusString.java

/**
 * StringPlusString zeigt den impliziten Umgang mit der Klasse StringBuilder.
 * Dieses Programm ist <b>nicht nachahmenswert</b>,
 * weil es viele Hilfsobjekte der Klassen StringBuilder und String erzeugt
 * und die zu erstellenden Zeichenkette st&auml;ndig von einem Hilfsobjekt
 * zum n&auml;chsten kopiert (siehe auch Fehlermeldung von spotbugs).
 * Die explizite Version StringBuilderVar.java braucht weniger Heap-Speicher
 * und ist deutlich schneller, weil sie keine derartigen Hilfsobjekte braucht

 * Beispielprogramm zur Programmiertechnik 1, Teil 4.
 * @author H.Drachenfels
 * @version 28.11.2018
 */
public final class StringPlusString {
    private StringPlusString() { }

    /**
     * main ist der Startpunkt des Programms.
     * @param args darf beliebige Zeichenketten enthalten.
     */
    public static void main(final String[] args) {
        String s = "";

        for (int i = 0; i < args.length; ++i) {
            if (i > 0) {
                s += ',';
            }

            s = s + i + ":\"" + args[i] + '\"';
        }

        System.out.println(s);
    }
}

