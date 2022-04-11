package aufgabe5;

/**
 * Note Klasse.
 */
public final class NoteBonus {

    /**
     * Beste mögliche Note.
     */
    public static final NoteBonus BESTE = new NoteBonus(10);

    /**
     * Schlechteste mögliche Note.
     */
    public static final NoteBonus SCHLECHTESTE = new NoteBonus(50);

    private int wert;

    private NoteBonus(final int wert) {
        super();

        this.wert = wert;
    }

    /**
     * Fabrikmethode zum erzeugen einer Note.
     * @param n Interger zwischen 10 und 50
     * @return Gibt ein neues Objekt von Note zurück;
     */
    public static NoteBonus valueOf(final int n) {

        if (!istZulaessig(n)) {
            throw new IllegalArgumentException("unzulaessige Note " + n);
        }

        return new NoteBonus(n);
    }

    /**
     * Fabrikmethode zum erzeugen einer Note aus dem Mittelwert der beiden 
     * uebergebenen Noten.
     * @param n1 Objekt vom Typ Note.
     * @param n2 Objekt vom Typ Note.
     * @return Gibt ein neues Objekt von Note zurück;
     */
    public static NoteBonus valueOf(NoteBonus n1, NoteBonus n2) {
        return new NoteBonus((n1.wert + n2.wert) / 2);
    }


    private static boolean istZulaessig(final int n) {
        int[] valid = {10, 13, 17, 20, 23, 27, 30, 33, 37, 40, 50};

        for (int var : valid) {
            if (n == var) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gibt die Note zurück.
     * @return Note als Integer.
     */
    public int intValue() {
        return this.wert;
    }

    /**
     * Ueberprueft ob Note zulaessig ist.
     * @return True wenn zulaessig.
     */
    public boolean istBestanden() {
        return this.wert <= 40;
    }

    @Override
    public String toString() {
        return String.format(this.wert / 10 + "," + this.wert % 10);
    }

    @Override
    public boolean equals(final Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return this.intValue();
    }
}