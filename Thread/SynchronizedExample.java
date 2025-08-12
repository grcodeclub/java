// Συγχρονισμός Μεταβλητών με synchronized
class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}

class CounterTask extends Thread {
    private Counter counter;

    public CounterTask(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

public class SynchronizedExample {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread t1 = new CounterTask(counter);
        Thread t2 = new CounterTask(counter);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Σφάλμα: " + e.getMessage());
        }

        System.out.println("Τελική τιμή του counter: " + counter.getCount());
    }
}
