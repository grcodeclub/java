// Εισαγωγή των απαραίτητων πακέτων για GUI και events
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    private final JTextField display;                               // Δημιουργία μεταβλητής για την οθόνη εμφάνισης
    private double num1 = 0, num2 = 0, result = 0;                  // Μεταβλητές για αποθήκευση αριθμών και αποτελέσματος
    private String operator = "";                                   // Μεταβλητή για αποθήκευση του επιλεγμένου τελεστή

    public Calculator() {                                           // Κατασκευαστής της αριθμομηχανής
        setTitle("Αριθμομηχανή");                                   // Τίτλος του παραθύρου
        setSize(350, 500);                                          // Μέγεθος του παραθύρου
        setLocationRelativeTo(null);                                // Κεντράρει το παράθυρο στην οθόνη
        setDefaultCloseOperation(EXIT_ON_CLOSE);                    // Ορίζει την ενέργεια όταν ο χρήστης κλείσει το παράθυρο
        setLayout(new BorderLayout(10, 10));                        // Ορίζει layout διατάξεων του κύριου παραθύρου
        display = new JTextField();                                 // Δημιουργεί το πεδίο εμφάνισης αποτελεσμάτων
        display.setEditable(false);                                 // Κάνει το πεδίο μη επεξεργάσιμο από πληκτρολόγιο
        display.setFont(new Font("Arial", Font.BOLD, 28));          // Ορίζει το font της οθόνης
        display.setHorizontalAlignment(JTextField.RIGHT);           // Ευθυγράμμιση κειμένου δεξιά
        display.setMargin(new Insets(10, 10, 10, 10));              // Ορίζει padding
        add(display, BorderLayout.NORTH);                           // Προσθέτει το display στο πάνω μέρος
        JPanel panel = new JPanel(new GridLayout(4, 4, 10, 10));    // Δημιουργεί πίνακα κουμπιών με πλέγμα 4x4
        String[] buttons = {                                        // Ορισμός των ετικετών των κουμπιών
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        for (String text : buttons) {                               // Δημιουργία και προσθήκη κουμπιών στο πάνελ
            JButton button = new JButton(text);                     // Δημιουργία κουμπιού         
            button.setFont(new Font("Arial", Font.BOLD, 24));       // Ορισμός font
            button.addActionListener(this);                         // Καταχώρηση ακροατή (listener)
            
            if ("/*-+=C".contains(text)) {                          // Χρωματισμός τελεστών για καλύτερη διάκριση
                button.setBackground(new Color(220, 220, 220));
            } else {
                button.setBackground(Color.WHITE);
            }

            panel.add(button);                                      // Προσθήκη κουμπιού στο πάνελ
        }

        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));    // Περιθώριο γύρω από το πάνελ κουμπιών
        add(panel, BorderLayout.CENTER);                            // Προσθέτει το πάνελ κουμπιών στο κεντρικό μέρος του παραθύρου
        setVisible(true);                                           // Εμφανίζει το παράθυρο
    }

    public void actionPerformed(ActionEvent e) {                    // Μέθοδος που εκτελείται όταν πατηθεί κάποιο κουμπί
        String input = e.getActionCommand();                        // Λήψη του κειμένου του κουμπιού που πατήθηκε

        if (input.matches("[0-9]")) {                               // Αν είναι ψηφίο (0–9), προστίθεται στο display
            display.setText(display.getText() + input);

        } else if (input.matches("[\\+\\-\\*/]")) {                 // Αν είναι τελεστής +, -, *, /
            try {
                num1 = Double.parseDouble(display.getText());       // Αποθήκευση του πρώτου αριθμού
                operator = input;                                   // Αποθήκευση τελεστή
                display.setText("");                                // Καθαρισμός οθόνης για τον δεύτερο αριθμό
            } catch (NumberFormatException ex) {
                display.setText("Σφάλμα");
            }
        } else if (input.equals("=")) {                             // Αν πατήθηκε "=" υπολογίζεται το αποτέλεσμα
            try {
                num2 = Double.parseDouble(display.getText());       // Ανάγνωση του δεύτερου αριθμού
                switch (operator) {                                 // Υπολογισμός με βάση τον τελεστή
                    case "+": result = num1 + num2; break;
                    case "-": result = num1 - num2; break;
                    case "*": result = num1 * num2; break;
                    case "/":
                        if (num2 == 0) {
                            display.setText("Άπειρο");
                            return;
                        }
                        result = num1 / num2; break;
                }
                display.setText(String.valueOf(result));            // Εμφάνιση του αποτελέσματος
            } catch (NumberFormatException ex) {
                display.setText("Σφάλμα");
            }
        } else if (input.equals("C")) {                             // Αν πατήθηκε "C", καθαρίζει τα πάντα
            display.setText("");                                    // Καθαρισμός οθόνης
            num1 = num2 = result = 0;                               // Μηδενισμός αριθμών
            operator = "";                                          // Καθαρισμός τελεστή
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calculator());         // Εκτέλεση της αριθμομηχανής με thread-safe τρόπο
    }
}