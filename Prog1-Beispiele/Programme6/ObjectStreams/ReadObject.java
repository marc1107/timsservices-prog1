// ReadObject.java

package objectstreams;

import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
* ReadObject zeigt den Umgang mit Object-Streams.
* @author H.Drachenfels
* @version 19.2.2015
*/
public final class ReadObject {
    private ReadObject() { }

    /**
     * Liest ein Objekt aus einer Datei.
     * @param args wird nicht verwendet
     * @throws IOException bei Dateizugriffsfehlern
     * @throws ClassNotFoundException Klasse des gelesenen Objekts unbekannt
     */
    public static void main(final String[] args)
        throws IOException, ClassNotFoundException {

        ObjectInput in =
            new ObjectInputStream(Files.newInputStream(Paths.get(args[0])));

        SerializableObject s = (SerializableObject) in.readObject();
        System.out.println(s);

        in.close();
    }
}

