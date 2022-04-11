// Datum.java
package comparator;
import java.util.Calendar;

/**
 * Datum ist ein Bauplan f&uuml;r Datumswerte.
 * Beispielprogramm zur Programmiertechnik 1, Teil 4.
 * @author H.Drachenfels
 * @version 8.8.2016
 */
public final class Datum implements Comparable<Datum> {
    /** Instanzvariable speichert den Tag im Monat. */
    public final int tag;
    /** Instanzvariable speichert den Monat im Jahr. */
    public final int monat;
    /** Instanzvariable speichert das Jahr. */
    public final int jahr;

    private Datum(final int tag, final int monat, final int jahr) {
        this.tag = tag;
        this.monat = monat;
        this.jahr = jahr;
    }

    /**
     * Fabrikmethode, die ein value object mit dem angegebenen Datum liefert.
     * @param tag ist der Tag im Monat
     * @param monat ist der Monat im Jahr
     * @param jahr ist das Jahr
     * @return Referenz auf das value object
     */
    public static Datum valueOf(final int tag,
                                final int monat,
                                final int jahr) {
        // Datum pruefen (stark vereinfacht)
        if (tag < 1 || tag > 31 || monat < 1 || monat > 12) {
            throw new IllegalArgumentException("ungueltiges Datum");
        }

        // value object erzeugen
        return new Datum(tag, monat, jahr);
    }

    /**
     * Fabrikmethode, die ein value object mit dem aktuellen Datum liefert.
     * @return Referenz auf das value object
     */
    public static Datum heute() {
        // Systemkalender ablesen
        Calendar c = Calendar.getInstance();

        // value object erzeugen
        return new Datum(c.get(Calendar.DAY_OF_MONTH),
                         c.get(Calendar.MONTH) + 1,
                         c.get(Calendar.YEAR));
    }

    @Override
    public String toString() {
        return String.format("%d-%02d-%02d", this.jahr, this.monat, this.tag)

    }

    @Override
    public boolean equals(final Object o) {
        if (o instanceof Datum) {
            Datum that = (Datum) o;
            return this.tag == that.tag
                   && this.monat == that.monat
                   && this.jahr == that.jahr;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return (this.jahr << 9) + (this.monat << 5) + this.tag;
    }

    @Override
    public int compareTo(final Datum d) {
        if (this.jahr < d.jahr) {
            return -1;
        }

        if (this.jahr > d.jahr) {
            return 1;
        }

        if (this.monat < d.monat) {
            return -1;
        }

        if (this.monat > d.monat) {
            return 1;
        }

        if (this.tag < d.tag) {
            return -1;
        }

        if (this.tag > d.tag) {
            return 1;
        }

        return 0;
    }
}

