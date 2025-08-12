// Αυτό το παράδειγμα δημιουργεί και εκτελεί ένα thread που εκτυπώνει μηνύματα.

class SimpleThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread εκτελείται: " + i);
            try {
                Thread.sleep(1000); // Αναμονή για 1 δευτερόλεπτο
            } catch (InterruptedException e) {
                System.out.println("Σφάλμα: " + e.getMessage());
            }
        }
    }
}

public class SimpleThreadExample {
    public static void main(String[] args) {
        SimpleThread thread = new SimpleThread();
        thread.start(); // Εκκίνηση του thread

        for (int i = 0; i < 5; i++) {
            System.out.println("Κύριο νήμα: " + i);
            try {
                Thread.sleep(500); // Αναμονή για 0.5 δευτερόλεπτο
            } catch (InterruptedException e) {
                System.out.println("Σφάλμα: " + e.getMessage());
            }
        }
    }
}
