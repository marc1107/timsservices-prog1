// KlausurListe.java
package klausur;

/**
 * KlausurListe gibt eine Punkteliste f&uuml;r Klausuraufgaben aus.
 * Beispielprogramm zur Programmiertechnik 1, Teil 4.
 * Siehe zum Vergleich KlausurArray in Teil 2.
 * @author H.Drachenfels
 * @version 23.11.2016
 */
public final class KlausurListe {
    private KlausurListe() { }

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(final String[] args) {
        int[] punkte = {12, 8, 10};

        //--------------------------------------------- Klausurliste anlegen
        KlausurAufgabe listenAnfang = null;  // leere Liste

        for (int i = punkte.length; i > 0; --i) {
            KlausurAufgabe a = new KlausurAufgabe(); // neues Listenelement
            a.naechste = listenAnfang; // alten Listenanfang kopieren
            a.aufgabe = i;
            a.punkte = punkte[i - 1]; // Feldelement kopieren

            listenAnfang = a; // neues Element wird Listenanfang
        }

        //-------------------------------------------- Klausurliste ausgeben
        for (KlausurAufgabe a = listenAnfang; a != null; a = a.naechste) {
            System.out.printf("Aufgabe %d: %d Punkte%n", a.aufgabe, a.punkte)

        }
    }
}

