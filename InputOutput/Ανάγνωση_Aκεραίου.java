import java.util.Scanner;                  
public class Main {
    public static void main(String[] args) {
        // Δημιουργία ενός αντικειμένου Scanner για την ανάγνωση από το πληκτρολόγιο
        Scanner scanner = new Scanner(System.in);                            
        // Εμφάνιση μηνύματος για την εισαγωγή ενός ακεραίου
        System.out.print("Εισάγετε έναν ακέραιο αριθμό: ");
        // Ανάγνωση του ακεραίου από το πληκτρολόγιο
        int number = scanner.nextInt();
        // Εμφάνιση του ακεραίου που εισήχθη
        System.out.println("Ο αριθμός που εισαγάγατε είναι: " + number);
        // Κλείσιμο του αντικειμένου Scanner
        scanner.close();
    }
}
