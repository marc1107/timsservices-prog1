// WriteObject.java

package objectstreams;

import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
* WriteObject zeigt den Umgang mit Object-Streams.
* @author H.Drachenfels
* @version 19.2.2015
*/
public final class WriteObject {
    private WriteObject() { }

    private static final String FILENAME = "SerializableObject.ser";

    /**
     * Erzeugt ein Objekt und schreibt es in eine Datei.
     * @param args Daten f&uuml;r das Objekt
     * @throws IOException bei Dateizugriffsfehlern
     */
    public static void main(final String[] args) throws IOException {
        SerializableObject s = new SerializableObject(args);
        System.out.println(s);

        ObjectOutput out =
            new ObjectOutputStream(Files.newOutputStream(Paths.get(FILENAME))

        out.writeObject(s);
        out.close();
    }
}

