// ListFiles.java

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
* ListFiles zeigt den Umgang mit Verzeichnissen.
* @author H.Drachenfels
* @version 19.2.2015
*/
public final class ListFiles {
    private ListFiles() { }

    /**
     * Listet Verzeichnisse mit ihren Unterverzeichnissen auf.
     * @param args Verzeichnisnamen
     * @throws IOException wegen Files.newDirectoryStream(Path)
     */
    public static void main(final String[] args) throws IOException {
        for (String s : args) {
            Path p = Paths.get(s);
            if (Files.exists(p)) {
                list(p);
            }
        }
    }

    private static void list(final Path p) throws IOException {
        System.out.println(p);

        if (Files.isDirectory(p)) {
            try (
                DirectoryStream<Path> d = Files.newDirectoryStream(p);
            ) {
                for (Path entry : d) {
                    list(entry);
                }
            }
        }
    }
}

