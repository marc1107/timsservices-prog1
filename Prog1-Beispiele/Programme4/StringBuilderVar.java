// StringBuilderVar.java

/**
 * StringBuilderVar zeigt den Umgang mit der Klasse StringBuilder.
 * Beispielprogramm zur Programmiertechnik 1, Teil 4.
 * @author H.Drachenfels
 * @version 4.8.2016
 */
public final class StringBuilderVar {
    private StringBuilderVar() { }

    /**
     * main ist der Startpunkt des Programms.
     * @param args darf beliebige Zeichenketten enthalten.
     */
    public static void main(final String[] args) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < args.length; ++i) {
            if (i > 0) {
                sb.append(',');
            }

            sb.append(i).append(":\"").append(args[i]).append('\"');
        }

        System.out.println(sb.toString());
    }
}

