import java.awt.*;
import javax.swing.*;

public class AdminMainWindow extends JFrame {
    public AdminMainWindow() {
        setTitle("ABC Company Payroll System - Admin");
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

        JButton employeeButton = new JButton("Employee Management");
        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonPanel.add(employeeButton, gbc);

        JButton payrollButton = new JButton("Payroll Management");
        gbc.gridx = 0;
        gbc.gridy = 1;
        buttonPanel.add(payrollButton, gbc);

        JButton reportButton = new JButton("Generate Reports");
        gbc.gridx = 0;
        gbc.gridy = 2;
        buttonPanel.add(reportButton, gbc);

        panel.add(buttonPanel, BorderLayout.CENTER);

        employeeButton.addActionListener(e -> openEmployeeManagement());
        payrollButton.addActionListener(e -> openPayrollManagement());
        reportButton.addActionListener(e -> generateReports());
    }

    private void openEmployeeManagement() {
        EmployeeManagementWindow employeeWindow = new EmployeeManagementWindow();
        employeeWindow.setVisible(true);
    }

    private void openPayrollManagement() {
        PayrollManagementWindow payrollWindow = new PayrollManagementWindow();
        payrollWindow.setVisible(true);
    }

    private void generateReports() {
        // Implement report generation logic
        JOptionPane.showMessageDialog(this, "Report Generation Screen");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AdminMainWindow mainWindow = new AdminMainWindow();
            mainWindow.setVisible(true);
        });
    }
}