import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Εισάγετε τον πρώτο αριθμό: ");
        int num1 = scanner.nextInt();

        System.out.print("Εισάγετε τον δεύτερο αριθμό: ");
        int num2 = scanner.nextInt();

        int sum = num1 + num2;

        System.out.println("Το άθροισμα είναι: " + sum);
    }
}
