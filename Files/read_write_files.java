// Ανάγνωση και Εγγραφή Αρχείων
import java.io.*;

public class FileIOExample {
    public static void main(String[] args) {
        // Εγγραφή σε αρχείο
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("example.txt"))) {
            writer.write("Αυτό είναι ένα παράδειγμα εγγραφής.");
        } catch (IOException e) {
            System.out.println("Σφάλμα κατά την εγγραφή στο αρχείο: " + e.getMessage());
        }

        // Ανάγνωση από αρχείο
        try (BufferedReader reader = new BufferedReader(new FileReader("example.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Διαβάστηκε: " + line);
            }
        } catch (IOException e) {
            System.out.println("Σφάλμα κατά την ανάγνωση από το αρχείο: " + e.getMessage());
        }
    }
}
