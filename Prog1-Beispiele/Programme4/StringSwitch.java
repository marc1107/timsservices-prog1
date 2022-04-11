// StringSwitch.java

/**
 * Testprogramm zur Java 7 String-switch-Anweisung.
 * @author H.Drachenfels
 * @version 9.12.2013
 */
public final class StringSwitch {
    private StringSwitch() { }

    /**
     * Startpunkt des Programms.
     * @param args args[0] wird als Test-String verwendet
     */
    public static void main(final String[] args) {
        for (String s : args) {
            System.out.printf("\"%s\".hashCode() = %d%n", s, s.hashCode());

            // Java 7 String switch
            switch (s) {
            case "A?":
                System.out.println("case \"A?\"");
                break;
            case "B ":
                System.out.println("case \"B \"");
                break;
            case "C@":
            case "D!":
            case "EF":
                System.out.println("case \"C@\" und \"D!\" und \"EF\"");
                break;
            default:
                System.out.println("default");
            }

            // Implementierungstechnik fuer Java 7 String switch
            {
                int ordinal = -1;
                switch (s.hashCode()) {
                // case 'A' * 31 + '?':
                // case 'B' * 31 + ' ':
                case 2078:
                    if (s.equals("A?")) {
                        ordinal = 0;
                    } else if (s.equals("B ")) {
                        ordinal = 1;
                    }
                    break;
                // case 'C' * 31 + '@':
                // case 'D' * 31 + '!':
                case 2141:
                    if (s.equals("C@")) {
                        ordinal = 2;
                    } else if (s.equals("D!")) {
                        ordinal = 3;
                    }
                    break;
                // case 'E' * 31 + 'F':
                case 2209:
                    if (s.equals("EF")) {
                        ordinal = 4;
                    }
                    break;
                default:
                }

                switch (ordinal) {
                case 0:
                    System.out.println("case \"A?\"");
                    break;
                case 1:
                    System.out.println("case \"B \"");
                    break;
                case 2:
                case 3:
                case 4:
                    System.out.println("case \"C@\" und \"D@\" und \"EF\"");
                    break;
                default:
                    System.out.println("default");
                }
            }
        }
    }
}

