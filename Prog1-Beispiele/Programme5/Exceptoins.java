// Exceptions.java
import java.util.Scanner;
import java.util.NoSuchElementException;

/**
 * Exceptions zeigt den Umgang mit verschiedenen Ausnahmearten.
 * Beispielprogramm zur Programmiertechnik 1, Teil 5.
 * @author H.Drachenfels
 * @version 5.8.2016
 */
public final class Exceptions {
    private Exceptions() {
        // fatale Ausnahme werfen
        throw new AssertionError("illegal class instantiation");
    }

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(final String[] args) {
        try {
            int n = scan(); // evtl. ScanException
            n = sqrt(n); // evtl. IllegalArgumentException
            print(n);
            new Exceptions().print(n); // AssertionError
        } catch (ScanException x) {
            System.err.println(x);
        } catch (IllegalArgumentException x) {
            System.err.println(x);
        } catch (AssertionError e) {
            System.err.println(e); // AssertionError besser nicht fangen!
        }
    }

    private static int scan() throws ScanException {
        try {
            Scanner in = new Scanner(System.in);
            if (in.hasNext() && !in.hasNextInt()) {
                throw new ScanException(in.next());
            }
            return in.nextInt();
        } catch (NoSuchElementException x) {
            // gepruefte Ausnahme werfen
            throw new ScanException(x);
        }
    }

    private static int sqrt(final int n) {
        if (n < 0) {
            // ungepruefte Ausnahme werfen
            throw new IllegalArgumentException("sqrt(int n) with n < 0");
        }
        return (int) Math.sqrt(n);
    }

    private static void print(final int n) {
        System.out.println(n);
    }
}

class ScanException extends Exception {
    ScanException(final String s) {
        super("illegal input " + s);
    }

    ScanException(final Throwable t) {
        super(t);
    }
}

