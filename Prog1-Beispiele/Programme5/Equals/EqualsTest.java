// EqualsTest.java
package equals;
import equals.variante1.Datum;
import equals.variante1.DatumMitZeit;

/**
 * EqualsTest testet equals-Implementierungen auf Reflexivit&auml;t,
 * Symmetrie und Transitivit&auml;t.
 * Beispielprogramm zur Programmiertechnik 1, Teil 5.
 * Testet die Implementierungsvarianten 1, 2, 3 und 4 von equals
 * in den Klassen Datum und DatumMitZeit.
 * @author H.Drachenfels
 * @version 14.12.2017
 */
public final class EqualsTest {
    private EqualsTest() { }

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(final String[] args) {
        Object[][] datumFelder = {
            {
                Datum.valueOf(14, 12, 2017),
                Datum.valueOf(14, 12, 2017),
                Datum.valueOf(14, 12, 2017),
                Datum.valueOf(15, 12, 2017)
            },
            {
                DatumMitZeit.valueOf(14, 12, 2017, 16, 30),
                DatumMitZeit.valueOf(14, 12, 2017, 16, 30),
                DatumMitZeit.valueOf(14, 12, 2017, 16, 30),
                DatumMitZeit.valueOf(14, 12, 2017, 16, 45)
            },
            {
                Datum.valueOf(14, 12, 2017),
                DatumMitZeit.valueOf(14, 12, 2017, 16, 30),
                DatumMitZeit.valueOf(14, 12, 2017, 16, 45)
            }
        };

        for (Object[] datumFeld : datumFelder) {
            // reflexiv?
            for (Object o : datumFeld) {
                if (!o.equals(o)) {
                    throw new AssertionError("equals nicht reflexiv: " + o);
                }
            }

            System.out.println("equals ist reflexiv"); // alle Varianten: ja

            // symmetrisch?
            for (int i = 0; i < datumFeld.length - 1; ++i) {
                Object a = datumFeld[i];
                Object b = datumFeld[i + 1];
                if (a.equals(b) != b.equals(a)) {
                    throw new AssertionError("equals nicht symmetrisch: "
                                             + a + " " + b);
                }
            }

            System.out.println("equals ist symmetrisch"); // Variante 1: nein

            // hashCode kompatible mit equals?
            for (int i = 0; i < datumFeld.length - 1; ++i) {
                Object a = datumFeld[i];
                Object b = datumFeld[i + 1];
                if (a.equals(b) && a.hashCode() != b.hashCode()) {
                    System.out.println("Fehler: Hashcodes nicht gleich: "
                                       + a + " " + b); // Variante 1 und 2
                }
            }

            // transitiv?
            Object a = datumFeld[1];
            Object b = datumFeld[0];
            Object c = datumFeld[2];
            if (a.equals(b) && b.equals(c)) {
                if (!a.equals(c)) {
                    throw new AssertionError("equals nicht transistiv: "
                                             + a + " " + b + " " + c);
                }

                System.out.println("equals ist transitiv"); // Variante 2: ne

            } else {
                System.out.println("transitiv nicht testbar");
            }
        }

        /*
         * Nur die Varianten 3 und 4 setzen die Spezifikation von
         * equals und hashCode richtig um.
         *
         * Variante 3 verletzt allerdings das Substitutionsprinzip der
         * Objektorientierung. Ein Oberklasse-Objekt (hier Datum) soll
         * danach ohne Funktionalitaetsverlust durch ein Unterklasse-Objekt
         * (hier DatumMitZeit) ersetzt werden koennen. Bei Variante 3 geht
         * dabei aber die Vergleichbarkeit mit equals verloren.
         *
         * Konsequenzen:
         * equals und hashCode nur in final oder abstract markierten Klassen
         * ueberschreiben, die keine (abgesehen von Object) oder nur abstrakt

         * Oberklassen haben.
         */
    }
}

