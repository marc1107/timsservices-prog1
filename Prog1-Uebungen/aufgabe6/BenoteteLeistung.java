package aufgabe6;

import aufgabe5.Note;

/**
 * BenoteteLeistung.
 */
public class BenoteteLeistung extends Leistung {

    private final Note note;

    /**
     * Konstruktor.
     * @param fach Fach
     * @param note Note
     */
    public BenoteteLeistung(final String fach, final String note) {
        super(fach);
        this.note = Note.valueOf(Integer.parseInt(note));
    }

    @Override
    public String getNote() {
        if (istBenotet()) {
            return this.note.toString();
        }
        return "";
    }

    @Override
    public String getNoteInWorten() {
        if (istBenotet()) {
            if (istBestanden()) {
                if (note.intValue() >= 10 && note.intValue() <= 15) {
                    return "sehr gut";
                } else if (note.intValue() >= 16 && note.intValue() <= 25) {
                    return "gut";
                } else if (note.intValue() >= 26 && note.intValue() <= 35) {
                    return "befriedigend";
                } else if (note.intValue() >= 36 && note.intValue() <= 40) {
                    return "ausreichend";
                }
            } else {
                return "nicht ausreichend";
            }
        }
        return "";
    }

    @Override
    public boolean istBenotet() {
        return true;
    }

    @Override
    public boolean istBestanden() {
        if (this.note.istBestanden()) {
            return true;
        }
        return false;
    }
}