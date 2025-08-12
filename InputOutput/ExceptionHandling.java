// Διαχείριση Εξαιρέσεων (Exception Handling)
public class ExceptionHandling {
    public static void main(String[] args) {
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Πρόσβαση σε μη έγκυρο δείκτη πίνακα: " + e.getMessage());
        } finally {
            System.out.println("Το μπλοκ finally εκτελείται πάντα.");
        }
    }
}
