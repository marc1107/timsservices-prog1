package aufgabe6;
/**
 * Faecher.
 */
public final class Faecher {

    private static final String[] FAECHER = {"Mathematik 1",
                                             "Programmiertechnik 1",
                                             "Digitaltechnik",
                                             "Konsolidierung",
                                             "FMSM",
                                             "SM2"};

    private Faecher() {
        super();
    }

    /**
     * Ueberprueft ob das uebergebene Fach in dem Array liegt.
     * @param fach Fach
     * @return true wenn zulaessig
     */
    public static boolean istZulaessig(final String fach) {
        for (String s : FAECHER) {
            if (s.equals(fach)) {
                return true;
            }
        }
        return false;
    }

}