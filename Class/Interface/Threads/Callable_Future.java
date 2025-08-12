// Σκοπός: Να υπολογίσουμε το άθροισμα των αριθμών από 1 έως 1000 σε ένα ξεχωριστό thread και να εμφανίσουμε το αποτέλεσμα στην κύρια μέθοδο.

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutionException;

// Ορισμός της κλάσης που υλοποιεί το Callable
class SumCallable implements Callable<Integer> {
    private int start;
    private int end;

    public SumCallable(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
            // Προσομοίωση μεγάλου υπολογισμού
            Thread.sleep(10);
        }
        return sum;
    }
}

public class CallableFutureExample {
    public static void main(String[] args) {
        // Δημιουργία του ExecutorService με ένα μόνο thread
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Δημιουργία του Callable task για τον υπολογισμό του αθροίσματος
        Callable<Integer> callableTask = new SumCallable(1, 1000);

        // Υποβολή του task στον ExecutorService
        Future<Integer> future = executor.submit(callableTask);

        try {
            // Ανάκτηση του αποτελέσματος του υπολογισμού
            Integer result = future.get();
            System.out.println("Το άθροισμα των αριθμών από 1 έως 1000 είναι: " + result);
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Σφάλμα κατά την εκτέλεση του task: " + e.getMessage());
        }

        // Κλείσιμο του ExecutorService
        executor.shutdown();
    }
}
