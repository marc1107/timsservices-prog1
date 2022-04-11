// SerializableObject.java

package objectstreams;

import java.util.Arrays;
import java.util.Date;
import java.io.Serializable;

/**
* SerializableObject ist eine per Object-Stream serialisierbare Klasse.
* @author H.Drachenfels
* @version 6.5.2011
*/
public final class SerializableObject implements Serializable {
    private final Date created;
    private final String[] args;

    /**
     * Initialisiert ein Objekt mit der aktuellen Zeit und einem Stringfeld.
     * @param args das Stringfeld
     */
    public SerializableObject(final String[] args) {
        this.args = args.clone();
        this.created = new Date(); // aktuelle Zeit
    }

    /**
     * Stellt das Objekt als String dar.
     * @return die String-Darstellung
     */
    public String toString() {
        return new StringBuilder()
               .append("SerializableObject")
               .append(' ')
               .append(Arrays.toString(this.args))
               .append(' ')
               .append(this.created)
               .toString();
    }
}

