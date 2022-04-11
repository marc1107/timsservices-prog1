package aufgabe5;
import java.util.NoSuchElementException;

/**
 * FachNotenListe beinhaltet Noten und ihre Fachnamen.
 */
public class FachNotenListeBonus {

    private Element head = null; // leere Liste
    /**
     * F&uuml;gt eine Zahl am Listenanfang ein.
     * Der heimliche Paramter this verweist auf das Objekt des Aufrufs.
     * @param n die einzuf&uuml;gende Zahl
     * @return die Liste
     */
    public FachNotenListeBonus insert(final FachNoteBonus n) {
        this.head = new Element(this.head, n);
        return this;
    }

    /**
     * Element speichert eine einzelne Zahl als Teil einer Liste.
     * Beipiel f&uuml;r eine statisch eingebettete Klasse.
     */
    private static final class Element {
        private final Element next;
        private final FachNoteBonus n;

        private Element(/* final Element this, */
                        final Element e, final FachNoteBonus n) {
            this.next = e;
            this.n = n;
        }
    }

    /**
     * Iterator speichert den aktuellen Zustand einer Listeniteration.
     * Beipiel f&uuml;r eine innere Klasse.
     */
    public final class Iterator {
        // private FachNotenListe FachNotenListe.this;
        private Element current = FachNotenListeBonus.this.head;

        /**
         * pr&uuml;t, ob das Listenende erreicht ist.
         * Der heimliche Paramter this verweist auf das Objekt des Aufrufs.
         * @return true, wenn das Listenende erreicht ist, sonst false.
         */
        public boolean hasNext(/* final Iterator this */) {
            return this.current != null;
        }

        /**
         * liefert die aktuelle Zahl und iteriert zum n&auml;chsten Jahr.
         * Aufruf am Listenende liefert NoSuchElementException.
         * Der heimliche Paramter this verweist auf das Objekt des Aufrufs.
         * @return die aktuelle Zahl
         */
        public FachNoteBonus next(/* final Iterator this */) {
            if (this.current == null) {
                throw new NoSuchElementException();
            }

            Element e = this.current;
            this.current = this.current.next;
            return e.n;
        }
    }
}