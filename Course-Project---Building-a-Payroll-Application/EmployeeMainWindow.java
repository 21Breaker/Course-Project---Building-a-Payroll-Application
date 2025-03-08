import java.awt.*;
import javax.swing.*;

public class EmployeeMainWindow extends JFrame {
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

        panel.add(buttonPanel, BorderLayout.CENTER);

        hoursWorkedButton.addActionListener(e -> enterHoursWorked());
        ptoButton.addActionListener(e -> enterPTO());
        paycheckButton.addActionListener(e -> calculatePaycheck());
    }

    private void enterHoursWorked() {
        // Implement hours worked entry logic
        JOptionPane.showMessageDialog(this, "Hours Worked Entry Screen");
    }

    private void enterPTO() {
        // Implement PTO entry logic
        JOptionPane.showMessageDialog(this, "PTO Entry Screen");
    }

    private void calculatePaycheck() {
        // Implement paycheck calculation logic
        JOptionPane.showMessageDialog(this, "Paycheck Calculation Screen");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmployeeMainWindow mainWindow = new EmployeeMainWindow();
            mainWindow.setVisible(true);
        });
    }
}