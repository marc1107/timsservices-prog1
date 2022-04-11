package aufgabe6;

/**
 * UnbenoteteLeistung.
 */
public class UnbenoteteLeistung extends Leistung {

    private final boolean bestanden;

    /**
     * Konstruktor.
     * @param fach Fach
     * @param bestanden ob bestanden
     */
    public UnbenoteteLeistung(final String fach,
        final boolean bestanden) {

        super(fach);

        this.bestanden = bestanden;
    }

    @Override
    public boolean istBenotet() {
        return false;
    }

    @Override
    public boolean istBestanden() {
        return bestanden;
    }
}