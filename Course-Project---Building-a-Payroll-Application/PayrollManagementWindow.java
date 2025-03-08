import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class PayrollManagementWindow extends JFrame {
    private JTextField employeeIdText;
    private JTextField hoursWorkedText;
    private JTextField hourlyRateText;
    private JTextArea payrollInfo;
    private final Map<String, Double> payrollData;

    public PayrollManagementWindow() {
        setTitle("Payroll Management");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        payrollData = new HashMap<>();

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel employeeIdLabel = new JLabel("Employee ID:");
        employeeIdLabel.setBounds(10, 20, 100, 25);
        panel.add(employeeIdLabel);

        employeeIdText = new JTextField(20);
        employeeIdText.setBounds(120, 20, 165, 25);
        panel.add(employeeIdText);

        JLabel hoursWorkedLabel = new JLabel("Hours Worked:");
        hoursWorkedLabel.setBounds(10, 50, 100, 25);
        panel.add(hoursWorkedLabel);

        hoursWorkedText = new JTextField(20);
        hoursWorkedText.setBounds(120, 50, 165, 25);
        panel.add(hoursWorkedText);

        JLabel hourlyRateLabel = new JLabel("Hourly Rate:");
        hourlyRateLabel.setBounds(10, 80, 100, 25);
        panel.add(hourlyRateLabel);

        hourlyRateText = new JTextField(20);
        hourlyRateText.setBounds(120, 80, 165, 25);
        panel.add(hourlyRateText);

        JButton calculateButton = new JButton("Calculate Payroll");
        calculateButton.setBounds(10, 110, 150, 25);
        panel.add(calculateButton);

        JButton viewPayrollButton = new JButton("View Payroll Info");
        viewPayrollButton.setBounds(170, 110, 150, 25);
        panel.add(viewPayrollButton);

        payrollInfo = new JTextArea();
        payrollInfo.setBounds(10, 150, 560, 200);
        panel.add(payrollInfo);

        calculateButton.addActionListener(e -> calculatePayroll());
        viewPayrollButton.addActionListener(e -> viewPayrollInfo());
    }

    private void calculatePayroll() {
        String employeeId = employeeIdText.getText();
        try {
            double hoursWorked = Double.parseDouble(hoursWorkedText.getText());
            double hourlyRate = Double.parseDouble(hourlyRateText.getText());
            double payrollAmount = hoursWorked * hourlyRate;
            payrollData.put(employeeId, payrollAmount);
            JOptionPane.showMessageDialog(this, "Payroll calculated for Employee ID: " + employeeId);
            employeeIdText.setText("");
            hoursWorkedText.setText("");
            hourlyRateText.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for hours worked and hourly rate.");
        }
    }

    private void viewPayrollInfo() {
        payrollInfo.setText("");
        for (Map.Entry<String, Double> entry : payrollData.entrySet()) {
            payrollInfo.append("Employee ID: " + entry.getKey() + ", Payroll Amount: $" + entry.getValue() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PayrollManagementWindow window = new PayrollManagementWindow();
            window.setVisible(true);
        });
    }
}