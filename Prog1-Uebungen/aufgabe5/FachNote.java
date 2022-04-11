package aufgabe5;

/**
 * Klasse die eine Note mit einem bestimmten Fach verbindet.
 */
public class FachNote {

    /**
     * Name des Fachs.
     */
    public final String fach;

    /**
     * Note in diesem Fach.
     */
    public final Note note;

    /**
     * Konstruktor der FachNote.
     * @param fach Name des Fachs
     * @param note Note in dem angegebenen Fach
     */
    public FachNote(final String fach, final Note note) {
        super();

        if (fach == null || note == null || fach.length() == 0) {
            throw new IllegalArgumentException();
        }

        this.fach = fach;
        this.note = note;
    }
}