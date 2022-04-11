// Termin.java
package comparator;

/**
 * Termin ist ein Bauplan f&uuml;r Terminentit&auml;ten.
 * Termin kann als Oberklasse verwendet werden.
 * Beispielprogramm zur Programmiertechnik 1, Teil 5.
 * @author H.Drachenfels
 * @version 8.8.2016
 */
public class Termin {
    private Datum wann;
    private final String was;

    /**
     * Konstruktor zum Initialisieren einer neuen Terminentit&auml;t.
     * @param wann ist das Datum des Termins (darf nicht null sein)
     * @param was ist die Beschreibung des Termins (darf nicht null sein)
     */
    public Termin(final Datum wann, final String was) {
        if (wann == null || was == null) {
            throw new IllegalArgumentException("sinnloser Termin");
        }
        this.wann = wann;
        this.was = was;
    }

    /**
     * Instanzmethode zum &Auml;ndern des Datums eines Termins.
     * @param wohin ist das neue Datum des Termins (darf nicht null sein)
     */
    public final void verschieben(final Datum wohin) {
        if (wohin == null) {
            throw new IllegalArgumentException("sinnloser Termin");
        }
        this.wann = wohin;
    }

    /**
     * Instanzmethode zum Abfragen des Datums eines Termins.
     * @return das Datum des Termins
     */
    public final Datum getDatum() {
        return this.wann;
    }

    /**
     * Instanzmethode zum Abfragen der Beschreibung eines Termins.
     * @return die Beschreibung des Termins
     */
    public final String getBeschreibung() {
        return this.was;
    }

    @Override
    public String toString() {
        return String.format("%s, %s", this.wann, this.was);
    }
}

