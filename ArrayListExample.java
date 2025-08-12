import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");
        
        System.out.println("Πρώτο στοιχείο: " + list.get(0));
        
        System.out.println("Όλα τα στοιχεία:");
        for (String item : list) {
            System.out.println(item);
        }
        
        list.remove("Banana");
        
        System.out.println("Μετά την αφαίρεση:");
        for (String item : list) {
            System.out.println(item);
        }
    }
}
