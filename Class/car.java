class Car {
    String brand;
    String model;
    int year;

    Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    void startEngine() {
        System.out.println("Ο κινητήρας του " + brand + " " + model + " ξεκίνησε.");
    }

    void stopEngine() {
        System.out.println("Ο κινητήρας του " + brand + " " + model + " σταμάτησε.");
    }

    void displayInfo() {
        System.out.println("Μάρκα: " + brand);
        System.out.println("Μοντέλο: " + model);
        System.out.println("Έτος: " + year);
    }
}

public class CarExample {
    public static void main(String[] args) {
        Car myCar = new Car("Toyota", "Corolla", 2020);
        myCar.displayInfo();
        myCar.startEngine();
        myCar.stopEngine();
    }
}
