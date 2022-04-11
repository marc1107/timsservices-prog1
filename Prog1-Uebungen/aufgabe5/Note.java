package aufgabe5;

/**
 * Note Klasse.
 */
public final class Note {

    /**
     * Beste mögliche Note.
     */
    public static final Note BESTE = new Note(10);

    /**
     * Schlechteste mögliche Note.
     */
    public static final Note SCHLECHTESTE = new Note(50);

    private int wert;

    private Note(final int wert) {
        super();

        this.wert = wert;
    }

    /**
     * Fabrikmethode zum erzeugen einer Note.
     * @param n Interger zwischen 10 und 50
     * @return Gibt ein neues Objekt von Note zurück;
     */
    public static Note valueOf(final int n) {

        if (!istZulaessig(n)) {
            throw new IllegalArgumentException("unzulaessige Note " + n);
        }

        return new Note(n);
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
    public boolean equals(final Object o) {
        if (o instanceof Note) {
            Note that = (Note) o;
            return this.wert == that.wert;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.intValue();
    }
}