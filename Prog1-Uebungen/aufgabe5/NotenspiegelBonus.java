// Notenspiegel.java
package aufgabe5;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Notenspiegel liest die Namen von F&auml;chern mit den zugeh&ouml;rigen Noten
 * in eine verkettete Liste ein und gibt dann einen Notenspiegel aus.
 * @author Tim Koehler
 * @version 10.12.18
 */
public final class NotenspiegelBonus {
    private NotenspiegelBonus() { }

    private static final Scanner EINGABE = new Scanner(System.in);

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(final String[] args) {
        FachNotenListeBonus liste = new FachNotenListeBonus(); // leere Liste

        //--------------------------------------------- Notenspiegel einlesen
        System.err.println("Fach und Note eingeben (Ende mit Strg-D):");

        while (EINGABE.hasNext()) {
            try {
                String fach = EINGABE.next();
                NoteBonus note = NoteBonus.valueOf(EINGABE.nextInt());

                if (EINGABE.hasNextInt()) {
                    note = NoteBonus.valueOf(note,
                        NoteBonus.valueOf(EINGABE.nextInt()));
                }

                FachNoteBonus fn = new FachNoteBonus(fach, note);

                liste.insert(fn);

            } catch (IllegalArgumentException x) {
                System.err.printf("Eingabefehler: %s%n", x.getMessage());
                continue;
            } catch (InputMismatchException x) {
                System.err.printf("Eingabefehler: %s%n", EINGABE.next());
                continue;
            } catch (NoSuchElementException x) {
                System.err.println("Fach ohne Note ignoriert!");
                break;
            }
        }

        //--------------------------------------------- Notenspiegel ausgeben

        FachNotenListeBonus.Iterator ite = liste.new Iterator();

        System.out.println("NOTENSPIEGEL");
       
        int laengsterString = 0;
        while (ite.hasNext()) {

            String fach = ite.next().fach;

            if(fach.length() > laengsterString) {
                laengsterString = fach.length();
            }  
        }       

        ite = liste.new Iterator();

        while (ite.hasNext()) {
            FachNoteBonus fn = ite.next();
            System.out.printf("%-" + (laengsterString + 7) + "s%-10s", fn.fach, fn.note);

            if (fn.note.istBestanden()) {
                if (fn.note.istBestanden()) {
                    if (fn.note.equals(fn.note.BESTE)) {
                        System.out.println("mit Bestnote bestanden");
                    } else {
                        System.out.println("bestanden");
                    }
                } else {
                    System.out.println("nicht bestanden");
                }
            }
        }
    } // main
}

