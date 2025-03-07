import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class EmployeeManagementWindow extends JFrame {
    private JTextField nameText;
    private JTextField idText;
    private JTextArea employeeList;
    private final Map<String, String> employees;

    public EmployeeManagementWindow() {
        setTitle("Employee Management");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        employees = new HashMap<>();

        JPanel panel = new JPanel(new BorderLayout());
        add(panel);
        placeComponents(panel);
    }

    private void placeComponents(JPanel panel) {
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel nameLabel = new JLabel("Name:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(nameLabel, gbc);

        nameText = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        inputPanel.add(nameText, gbc);

        JLabel idLabel = new JLabel("Employee ID:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(idLabel, gbc);

        idText = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        inputPanel.add(idText, gbc);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;

        JButton addButton = new JButton("Add");
        gbc.gridy = 0;
        buttonPanel.add(addButton, gbc);

        JButton editButton = new JButton("Edit");
        gbc.gridy = 1;
        buttonPanel.add(editButton, gbc);

        JButton deleteButton = new JButton("Delete");
        gbc.gridy = 2;
        buttonPanel.add(deleteButton, gbc);

        employeeList = new JTextArea();
        employeeList.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(employeeList);

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.add(scrollPane, BorderLayout.SOUTH);

        addButton.addActionListener((ActionEvent e) -> {
            addEmployee();
        });

        editButton.addActionListener((ActionEvent e) -> {
            editEmployee();
        });

        deleteButton.addActionListener((ActionEvent e) -> {
            deleteEmployee();
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