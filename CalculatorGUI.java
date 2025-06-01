import javax.swing.*;         // For GUI components like JFrame, JButton, JTextField, etc.
import java.awt.*;            // For layout managers and colors
import java.awt.event.*;      // For handling events like button clicks

public class CalculatorGUI extends JFrame implements ActionListener {
    
    // Declare UI components
    JTextField inputField;
    JButton addButton, subButton, mulButton, divButton, clearButton;
    JLabel resultLabel;

    public CalculatorGUI() {
        // Set title and default behavior
        setTitle("Simple Calculator");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Input text field
        inputField = new JTextField(20);
        add(inputField);

        // Create buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        clearButton = new JButton("Clear");

        // Add buttons to frame
        add(addButton);
        add(subButton);
        add(mulButton);
        add(divButton);
        add(clearButton);

        // Result label
        resultLabel = new JLabel("Result: ");
        add(resultLabel);

        // Add action listeners for buttons
        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        clearButton.addActionListener(this);

        // Set the window to visible
        setVisible(true);
    }

    // Action handler for button clicks
    public void actionPerformed(ActionEvent e) {
        try {
            // Get input and split into two numbers
            String input = inputField.getText();
            String[] parts = input.split(" ");

            if (parts.length != 2) {
                resultLabel.setText("Enter two numbers separated by space");
                return;
            }

            double num1 = Double.parseDouble(parts[0]);
            double num2 = Double.parseDouble(parts[1]);
            double result = 0;

            // Determine which button was clicked
            if (e.getSource() == addButton) {
                result = num1 + num2;
            } else if (e.getSource() == subButton) {
                result = num1 - num2;
            } else if (e.getSource() == mulButton) {
                result = num1 * num2;
            } else if (e.getSource() == divButton) {
                if (num2 == 0) {
                    resultLabel.setText("Cannot divide by zero");
                    return;
                }
                result = num1 / num2;
            } else if (e.getSource() == clearButton) {
                inputField.setText("");
                resultLabel.setText("Result: ");
                return;
            }

            resultLabel.setText("Result: " + result);

        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input!");
        }
    }

    public static void main(String[] args) {
        new CalculatorGUI();  // Create the GUI window
    }
}
