package aufgabe6;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * FachNotenListe.
 */
public class FachNotenListe implements Iterable<Leistung> {

    private Element head = null; // leere Liste

    /**
     * Konstruktor.
     */
    public FachNotenListe() {
        super();
    }

    /**
     * F&uuml;gt eine Zahl am Listenanfang ein.
     * @param n die einzuf&uuml;gende Zahl
     * @return die Liste
     */
    public FachNotenListe insert(final Leistung n) {
        this.head = new Element(this.head, n);
        return this;
    }

    /**
     * Element speichert eine einzelne Zahl als Teil einer Liste.
     * Beipiel f&uuml;r eine statisch eingebettete Klasse.
     */
    private static final class Element {
        private final Element next;
        private final Leistung n;

        private Element(final Element e, final Leistung n) {
            this.next = e;
            this.n = n;
        }
    }

    @Override
    public final Iterator<Leistung> iterator() {
        // Beispiel fuer eine anonyme lokale Klasse
        return new Iterator<Leistung>() {
            private Element current = FachNotenListe.this.head;

            @Override
            public boolean hasNext() {
                return this.current != null;
            }

            @Override
            public Leistung next() {
                if (this.current == null) {
                    throw new NoSuchElementException();
                }

                Element e = this.current;
                this.current = this.current.next;
                return e.n;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}