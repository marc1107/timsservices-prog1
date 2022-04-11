// BinaryDump.java

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
* BinaryDump gibt den Inhalt einer Datei byte-weise bin&auml;r aus.
* @author H.Drachenfels
* @version 19.1.2016
*/
public final class BinaryDump {
    private BinaryDump() { }

    /**
     * @param args optional ein Dateiname
     * @throws IOException bei Lesefehlern
     */
    public static void main(final String[] args) throws IOException {
        InputStream in;

        if (args.length == 0) {
            in = System.in;
        } else {
            in = new FileInputStream(args[0]);
        }

        int b;
        int i = -1;
        while ((b = in.read()) != -1) {
            if (++i % 8 == 0) {
                System.out.println();
            }

            System.out.printf(
                " %08d", Integer.parseInt(Integer.toBinaryString(b)));
        }

        System.out.println();
    }
}

