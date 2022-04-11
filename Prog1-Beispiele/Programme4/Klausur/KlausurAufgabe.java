// KlausurAufgabe.java
package klausur;

/**
 * KlausurAufgabe ist Element einer Liste von Klausuraufgaben.
 * Beispielprogramm zur Programmiertechnik 1, Teil 4.
 * Achtung: &ouml;ffentliche Instanzvariablen ohne final
 *          sind nicht nachahmenswert.
 * @author H.Drachenfels
 * @version 25.11.2016
 */
public final class KlausurAufgabe {
    /** Instanzvariable f&uuml;r die Listenverkettung. */
    public KlausurAufgabe naechste;

    /** Instanzvariable speichert die Aufgabennummmer. */
    public int aufgabe;

    /** Instanzvariable speichert die erreichbaren Punkte. */
    public int punkte;
}

