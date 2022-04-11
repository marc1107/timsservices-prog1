// CopyFileCompiled.java

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
* CopyFileCompiled zeigt die Bedeutung von try-with-resources.
* Vergleich mit Beispiel CopyFile.java aus Teil 6.
* @author H.Drachenfels
* @version 8.8.2016
*/
public final class CopyFileCompiled {
    private CopyFileCompiled() { }

    /**
     * Kopiert eine Datei.
     * @param args Quell- und Zieldateinamen
     * @throws IOException bei Dateizugriffsfehlern
     */
    public static void main(final String[] args) throws IOException {
        /*try*/ {
            InputStream in = Files.newInputStream(Paths.get(args[0]));
            Throwable x = null;

            try {
                OutputStream out = Files.newOutputStream(Paths.get(args[1]));

                try {
                    int b;
                    while ((b = in.read()) != -1) {
                        out.write(b);
                    }
                } catch (Throwable t) {
                    x = t;
                    throw t;
                } finally {
                    if (x != null) {
                        try {
                            out.close();
                        } catch (Throwable t) {
                            x.addSuppressed(t);
                        }
                    } else {
                        out.close();
                    }
                }
            } catch (Throwable t) {
                x = t;
                throw t;
            } finally {
                if (x != null) {
                    try {
                        in.close();
                    } catch (Throwable t) {
                        x.addSuppressed(t);
                    }
                } else {
                    in.close();
                }
            }
        }
    }
}

