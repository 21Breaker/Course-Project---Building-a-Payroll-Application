import javax.swing.*;

public class AdminWindow {
    public AdminWindow() {
        // Create the admin frame
        JFrame frame = new JFrame("Admin Dashboard");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);

        // Create and add the panel to the frame
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true); // Display the frame
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null); // Use null layout for custom positioning

        // Create and add buttons for admin functionalities
        JButton employeeButton = new JButton("Employee Demographics");
        employeeButton.setBounds(10, 20, 200, 25);
        panel.add(employeeButton);

        JButton payrollButton = new JButton("Payroll Information");
        payrollButton.setBounds(10, 50, 200, 25);
        panel.add(payrollButton);

        JButton addEditDeleteButton = new JButton("Add/Edit/Delete Employee");
        addEditDeleteButton.setBounds(10, 80, 200, 25);
        panel.add(addEditDeleteButton);

        JButton searchButton = new JButton("Employee Search");
        searchButton.setBounds(10, 110, 200, 25);
        panel.add(searchButton);

        JButton reportButton = new JButton("Reporting");
        reportButton.setBounds(10, 140, 200, 25);
        panel.add(reportButton);

        JButton appInfoButton = new JButton("Application Information");
        appInfoButton.setBounds(10, 170, 200, 25);
        panel.add(appInfoButton);
    }
}
