// Copy.java

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.InvalidPathException;
import java.nio.file.FileAlreadyExistsException;

/**
* Copy kopiert eine Datei.
* @author H.Drachenfels
* @version 24.6.2015
*/
public final class Copy {
    private Copy() { }

    /**
     * Legt eine Zieldatei (Name args[0])
     * als Kopie einer Quelldatei (Name args[1]) an.
     * @param args Quelldatei und Zieldatei
     */
    public static void main(final String[] args) {

        if (args.length != 2) {
            System.err.println("Aufruf: java Copy Quelldatei Zieldatei");
            System.exit(1);
        }

        try {
            // Quelle pruefen
            Path quelle = Paths.get(args[0]);

            if (Files.notExists(quelle)) {
                System.err.printf("Quelle existiert nicht: %s%n", quelle);
                System.exit(1);
            }

            if (!Files.isRegularFile(quelle)) {
                System.err.printf("Quelle ist keine normale Datei: %s%n",
                                  quelle);
                System.exit(1);
            }

            if (!Files.isReadable(quelle)) {
                System.err.printf("Quelle ist nicht lesbar: %s%n", quelle);
                System.exit(1);
            }

            // Kopieren
            Path ziel = Paths.get(args[1]);
            Files.copy(quelle, ziel);

        } catch (InvalidPathException x) {
            System.err.printf("Ungueltiger Dateiname: %s%n", x.getMessage());
            System.exit(1);
        } catch (FileAlreadyExistsException x) {
            System.err.printf("Ziel existiert bereits: %s%n", x.getMessage())

            System.exit(1);
        } catch (IOException x) {
            System.err.printf("Kopierfehler: %s%n", x.getMessage());
            System.exit(1);
        }
    }
}

