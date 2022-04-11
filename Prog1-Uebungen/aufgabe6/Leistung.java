// Leistung.java
package aufgabe6;

/**
 * Leistung kapselt ein Fach mit Note als Entit&auml;t.
 * @author H.Drachenfels
 * @version 26.9.2018
 */
public abstract class Leistung {
    private final String fach;

    /**
     * initialisiert die Fachnote mit einem Namen.
     * <p>
     * Wirft eine Ausnahme <code>IllegalArgumentException</code>, wenn das Fach
     * laut {@link Faecher#istZulaessig} nicht zul&auml;ssig ist.</p>
     * @param f der Fachname
     */
    protected Leistung(final String f) {
        if (!Faecher.istZulaessig(f)) {
            throw new IllegalArgumentException("unzulaessiges Fach " + f);
        }

        this.fach = f;
    }

    /**
     * liefert den Namen des Fachs.
     * @return den Fachnamen
     */
    public final String getFach() {
        return this.fach;
    }

    /**
     * liefert die Note des Fachs in numerischer Schreibweise.
     * <p>
     * Wenn {@link #istBenotet} <code>true</code> zur&uuml;ckgibt,
     * muss die Methode in der Unterklasse so &uuml;berschrieben werden,
     * dass sie die Note in numerischer Schreibweise liefert,
     * also Strings "1,0", "1,3" usw.
     * @return leerer String &quot;&quot;
     */
    public String getNote() {
        assert !istBenotet() : this.getClass().getName()
                               + " muss getNote() ueberschreiben";
        return "";
    }

    /**
     * liefert die Note des Fachs in Worten.
     * <p>
     * Wenn {@link #istBenotet} <code>true</code> zur&uuml;ckgibt,
     * muss die Methode in der Unterklasse &uuml;berschrieben werden.
     * Der geliefert String h&auml;ngt dann davon ab,
     * welches Notensystem die Unterklasse verwendet.
     * @return "bestanden", wenn {@link #istBestanden} true liefert,
     *         sonst "nicht bestanden".
     */
    public String getNoteInWorten() {
        assert !istBenotet() : this.getClass().getName()
                               + " muss getNoteInWorten() ueberschreiben";
        if (istBestanden()) {
            return "bestanden";
        }

        return "nicht bestanden";
    }

    /**
     * fragt ab, ob das Fach bestanden ist.
     * Wenn {@link #istBenotet} <code>true</code> zur&uuml;ckgibt,
     * h&auml;ngt es vom Notensystem der Unterklasse ab,
     * welche Noten als bestanden und welche als nicht bestanden gelten.
     * @return <code>true</code>, wenn bestanden, sonst <code>false</code>
     */
    public abstract boolean istBestanden();

    /**
     * fragt ab, ob das Fach benotet oder unbenotet ist.
     * <p>
     * Darf nur <code>true</code> liefern, wenn die Methoden
     * {@link #getNote} und {@link #getNoteInWorten}
     * so &uuml;berschreiben sind, dass sie eine Note liefern.</p>
     * @return <code>true</code>, wenn benotet, sonst <code>false</code>
     */
    public abstract boolean istBenotet();
}

