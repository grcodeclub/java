enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class EnumExample {
    public static void main(String[] args) {
        Day today = Day.FRIDAY;

        switch (today) {
            case MONDAY:
                System.out.println("Σήμερα είναι Δευτέρα.");
                break;
            case FRIDAY:
                System.out.println("Σήμερα είναι Παρασκευή!");
                break;
            case SUNDAY:
                System.out.println("Σήμερα είναι Κυριακή.");
                break;
            default:
                System.out.println("Σήμερα είναι εργάσιμη μέρα.");
                break;
        }
    }
}
