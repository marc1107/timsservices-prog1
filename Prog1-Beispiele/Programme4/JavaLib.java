// JavaLib.java

/**
 * JavaLib zeigt den Umgang mit Klassenmethoden der Java-Bibliothek.
 * Beispielprogramm zur Programmiertechnik 1, Teil 4.
 * @author H.Drachenfels
 * @version 28.11.2011
 */
public final class JavaLib {
    private JavaLib() { }

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(final String[] args) {
        long start = System.currentTimeMillis();

        double sinPiHalbe = Math.sin(Math.PI / 2);
        System.out.println(sinPiHalbe);

        double wurzelZwei = Math.sqrt(2);
        System.out.println(wurzelZwei);

        int[] feld = new int[] {10, 11};
        System.out.println(feld); // oder: feld.toString(), String.valueOf(fe

        String feldAlsString = java.util.Arrays.toString(feld);
        System.out.println(feldAlsString);

        int[][] matrix = new int[][] {{10, 11}, {20, 21}};
        System.out.println(matrix.toString());
        String matrixAlsString = java.util.Arrays.toString(matrix);
        System.out.println(matrixAlsString);
        matrixAlsString = java.util.Arrays.deepToString(matrix);
        System.out.println(matrixAlsString);
        System.out.flush();

        long stopp = System.currentTimeMillis();
        System.out.println(stopp - start);
    }
}

