import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class EmployeeManagementWindow extends JFrame {
    private JTextField nameText;
    private JTextField idText;
    private JTextArea employeeList;
    private Map<String, String> employees;

    public EmployeeManagementWindow() {
        setTitle("Employee Management");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        employees = new HashMap<>();

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);

        nameText = new JTextField(20);
        nameText.setBounds(100, 20, 165, 25);
        panel.add(nameText);

        JLabel idLabel = new JLabel("Employee ID:");
        idLabel.setBounds(10, 50, 80, 25);
        panel.add(idLabel);

        idText = new JTextField(20);
        idText.setBounds(100, 50, 165, 25);
        panel.add(idText);

        JButton addButton = new JButton("Add");
        addButton.setBounds(10, 80, 80, 25);
        panel.add(addButton);

        JButton editButton = new JButton("Edit");
        editButton.setBounds(100, 80, 80, 25);
        panel.add(editButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setBounds(190, 80, 80, 25);
        panel.add(deleteButton);

        employeeList = new JTextArea();
        employeeList.setBounds(10, 120, 560, 200);
        panel.add(employeeList);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEmployee();
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editEmployee();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteEmployee();
            }
        });
    }

    private void addEmployee() {
        String name = nameText.getText();
        String id = idText.getText();
        if (!name.isEmpty() && !id.isEmpty()) {
            employees.put(id, name);
            updateEmployeeList();
            nameText.setText("");
            idText.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Name and Employee ID cannot be empty.");
        }
    }

    private void editEmployee() {
        String id = idText.getText();
        if (employees.containsKey(id)) {
            String name = nameText.getText();
            if (!name.isEmpty()) {
                employees.put(id, name);
                updateEmployeeList();
                nameText.setText("");
                idText.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Name cannot be empty.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Employee ID not found.");
        }
    }

    private void deleteEmployee() {
        String id = idText.getText();
        if (employees.containsKey(id)) {
            employees.remove(id);
            updateEmployeeList();
            nameText.setText("");
            idText.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Employee ID not found.");
        }
    }

    private void updateEmployeeList() {
        employeeList.setText("");
        for (Map.Entry<String, String> entry : employees.entrySet()) {
            employeeList.append("ID: " + entry.getKey() + ", Name: " + entry.getValue() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmployeeManagementWindow window = new EmployeeManagementWindow();
            window.setVisible(true);
        });
    }
}
