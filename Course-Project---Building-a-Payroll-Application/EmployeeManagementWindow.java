import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class EmployeeManagementWindow extends JFrame {
    private JTextField nameText;
    private JTextField idText;
    private JTextArea employeeList;
    private final Map<String, Employee> employees;

    public EmployeeManagementWindow() {
        setTitle("Employee Management");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        employees = new HashMap<>();
        addTestEmployees();

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

        updateEmployeeList();
    }

    private void addTestEmployees() {
        employees.put("E001", new Employee("John Doe", "john.doe@example.com", "19850115"));
        employees.put("E002", new Employee("Jane Smith", "jane.smith@example.com", "19900220"));
        employees.put("E003", new Employee("Alice Johnson", "alice.johnson@example.com", "19870330"));
        employees.put("E004", new Employee("Bob Brown", "bob.brown@example.com", "19881210"));
        employees.put("E005", new Employee("Charlie Davis", "charlie.davis@example.com", "19910505"));
        employees.put("E006", new Employee("Diana Evans", "diana.evans@example.com", "19860625"));
        employees.put("E007", new Employee("Ethan Foster", "ethan.foster@example.com", "19930315"));
        employees.put("E008", new Employee("Fiona Green", "fiona.green@example.com", "19891120"));
        employees.put("E009", new Employee("George Harris", "george.harris@example.com", "19870410"));
        employees.put("E010", new Employee("Hannah Irving", "hannah.irving@example.com", "19901230"));
        employees.put("E011", new Employee("Ian Jackson", "ian.jackson@example.com", "19880525"));
        employees.put("E012", new Employee("Julia King", "julia.king@example.com", "19920715"));
    }

    private void addEmployee() {
        String name = nameText.getText();
        String id = idText.getText();
        if (!name.isEmpty() && !id.isEmpty()) {
            employees.put(id, new Employee(name, "", ""));
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
                employees.get(id).setName(name);
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
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            employeeList.append("ID: " + entry.getKey() + ", Name: " + employee.getName() + ", Email: " + employee.getEmail() + ", DOB: " + employee.getDob() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmployeeManagementWindow window = new EmployeeManagementWindow();
            window.setVisible(true);
        });
    }
}

class Employee {
    private String name;
    private final String email;
    private final String dob;

    public Employee(String name, String email, String dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getDob() {
        return dob;
    }
}