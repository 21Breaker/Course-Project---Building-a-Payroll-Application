import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public MainWindow() {
        setTitle("ABC Company Payroll System - Main");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(new GridLayout(3, 2));

        JButton employeeButton = new JButton("Employee Management");
        JButton payrollButton = new JButton("Payroll Management");
        JButton reportButton = new JButton("Generate Reports");

        panel.add(employeeButton);
        panel.add(payrollButton);
        panel.add(reportButton);

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
    }
}
