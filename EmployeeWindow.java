import javax.swing.*;

public class EmployeeWindow {
    public EmployeeWindow() {
        JFrame frame = new JFrame("Employee Dashboard");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JButton hoursWorkedButton = new JButton("Enter Hours Worked");
        hoursWorkedButton.setBounds(10, 20, 200, 25);
        panel.add(hoursWorkedButton);

        JButton ptoButton = new JButton("PTO");
        ptoButton.setBounds(10, 50, 200, 25);
        panel.add(ptoButton);

        JButton paycheckButton = new JButton("Calculate Paycheck");
        paycheckButton.setBounds(10, 80, 200, 25);
        panel.add(paycheckButton);
    }
}
