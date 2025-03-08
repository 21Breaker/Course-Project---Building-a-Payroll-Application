import java.awt.*;
import javax.swing.*;

public class EmployeeMainWindow extends JFrame {
    private JTextField hoursWorkedText;
    private JTextField ptoText;
    private JLabel paycheckLabel;

    public EmployeeMainWindow() {
        setTitle("ABC Company Payroll System - Employee");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        add(panel);
        placeComponents(panel);
    }

    private void placeComponents(JPanel panel) {
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JButton hoursWorkedButton = new JButton("Enter Hours Worked");
        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonPanel.add(hoursWorkedButton, gbc);

        JButton ptoButton = new JButton("Enter PTO");
        gbc.gridx = 0;
        gbc.gridy = 1;
        buttonPanel.add(ptoButton, gbc);

        JButton paycheckButton = new JButton("Calculate Paycheck");
        gbc.gridx = 0;
        gbc.gridy = 2;
        buttonPanel.add(paycheckButton, gbc);

        JButton submitButton = new JButton("Submit");
        gbc.gridx = 0;
        gbc.gridy = 3;
        buttonPanel.add(submitButton, gbc);

        panel.add(buttonPanel, BorderLayout.CENTER);

        hoursWorkedButton.addActionListener(e -> enterHoursWorked());
        ptoButton.addActionListener(e -> enterPTO());
        paycheckButton.addActionListener(e -> calculatePaycheck());
        submitButton.addActionListener(e -> submitHoursWorked());

        JPanel inputPanel = new JPanel(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(new JLabel("Hours Worked:"), gbc);

        hoursWorkedText = new JTextField(10);
        gbc.gridx = 1;
        inputPanel.add(hoursWorkedText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(new JLabel("PTO (hours):"), gbc);

        ptoText = new JTextField(10);
        gbc.gridx = 1;
        inputPanel.add(ptoText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        paycheckLabel = new JLabel("Paycheck: $0.00");
        inputPanel.add(paycheckLabel, gbc);

        panel.add(inputPanel, BorderLayout.NORTH);
    }

    private void enterHoursWorked() {
        String hoursWorked = JOptionPane.showInputDialog(this, "Enter Hours Worked:");
        if (hoursWorked != null) {
            hoursWorkedText.setText(hoursWorked);
        }
    }

    private void enterPTO() {
        String pto = JOptionPane.showInputDialog(this, "Enter PTO (hours):");
        if (pto != null) {
            ptoText.setText(pto);
        }
    }

    private void calculatePaycheck() {
        try {
            int hoursWorked = Integer.parseInt(hoursWorkedText.getText());
            int pto = Integer.parseInt(ptoText.getText());
            double hourlyRate = 20.0; // Example hourly rate
            double paycheck = (hoursWorked + pto) * hourlyRate;
            paycheckLabel.setText(String.format("Paycheck: $%.2f", paycheck));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for hours worked and PTO.");
        }
    }

    private void submitHoursWorked() {
        String hoursWorked = hoursWorkedText.getText();
        if (hoursWorked.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter hours worked before submitting.");
        } else {
            JOptionPane.showMessageDialog(this, "Hours logged successfully.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmployeeMainWindow mainWindow = new EmployeeMainWindow();
            mainWindow.setVisible(true);
        });
    }
}