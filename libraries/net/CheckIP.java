import java.net.InetAddress;  // Εισαγωγή κλάσης για την αναπαράσταση και επεξεργασία διευθύνσεων IP
import java.util.Scanner;  // Εισαγωγή κλάσης Scanner για την ανάγνωση της εισόδου από τον χρήστη

public class CheckIP {  // Ορισμός της κύριας κλάσης του προγράμματος
    public static void main(String[] args){  // Η κύρια μέθοδος που εκτελείται κατά την εκκίνηση του προγράμματος
        try {  // Ξεκινάει μπλοκ try-catch για να διαχειριστεί πιθανές εξαιρέσεις
            System.out.println("Give IP:");  // Εκτυπώνει το μήνυμα που ζητά από τον χρήστη να εισάγει μια διεύθυνση IP

            Scanner input_ip = new Scanner(System.in);  // Δημιουργεί ένα αντικείμενο Scanner για την ανάγνωση της εισόδου από την κονσόλα
            String data = input_ip.next();  // Διαβάζει την εισαγωγή του χρήστη και την αποθηκεύει στην μεταβλητή "data"

            InetAddress ip = InetAddress.getByName(data);  // Χρησιμοποιεί την κλάση InetAddress για να μετατρέψει τη συμβολοσειρά "data" σε αντικείμενο διεύθυνσης IP

            // Εκτυπώνει διάφορους ελέγχους για την διεύθυνση IP
            System.out.print("\nLocal Address : " + ip.isAnyLocalAddress());  // Ελέγχει αν η διεύθυνση είναι τοπική διεύθυνση
            System.out.print("\nLink Local Address : " + ip.isLinkLocalAddress());  // Ελέγχει αν η διεύθυνση είναι link-local (χρησιμοποιείται μόνο εντός τοπικού δικτύου)
            System.out.print("\nLoopback Address : " + ip.isLoopbackAddress());  // Ελέγχει αν η διεύθυνση είναι loopback (αναφέρεται στον ίδιο υπολογιστή)
            System.out.print("\nMulticast Address : " + ip.isMulticastAddress());  // Ελέγχει αν η διεύθυνση είναι multicast (χρησιμοποιείται για αποστολή σε πολλές συσκευές ταυτόχρονα)
            System.out.print("\nSite Local Address : " + ip.isSiteLocalAddress());  // Ελέγχει αν η διεύθυνση είναι site-local (χρησιμοποιείται για επικοινωνία σε περιορισμένο δίκτυο)

        } catch (Exception e) {  // Εάν παρουσιαστεί εξαίρεση, την πιάνει και εκτυπώνει το μήνυμα λάθους
            System.out.println(e);  // Εκτυπώνει το μήνυμα εξαίρεσης (αν υπάρχει)
        }  
    }  
}