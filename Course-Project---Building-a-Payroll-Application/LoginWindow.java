import java.awt.*;
import java.awt.event.ActionEvent;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class LoginWindow extends JFrame {
    private JTextField userText;
    private JPasswordField passwordText;
    private JComboBox<String> userTypeCombo;
    private final Map<String, String> userCredentials;

    public LoginWindow() {
        setTitle("ABC Company Payroll System - Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        userCredentials = new HashMap<>();
        // Add user credentials (user ID and hashed password)
        userCredentials.put("HR0001", hashPassword("Jolly202050+!"));
        userCredentials.put("john.doe@example.com", hashPassword("19850115"));
        userCredentials.put("jane.smith@example.com", hashPassword("19900220"));
        userCredentials.put("alice.johnson@example.com", hashPassword("19870330"));
        userCredentials.put("bob.brown@example.com", hashPassword("19881210"));
        userCredentials.put("charlie.davis@example.com", hashPassword("19910505"));
        userCredentials.put("diana.evans@example.com", hashPassword("19860625"));
        userCredentials.put("ethan.foster@example.com", hashPassword("19930315"));
        userCredentials.put("fiona.green@example.com", hashPassword("19891120"));
        userCredentials.put("george.harris@example.com", hashPassword("19870410"));
        userCredentials.put("hannah.irving@example.com", hashPassword("19901230"));
        userCredentials.put("ian.jackson@example.com", hashPassword("19880525"));
        userCredentials.put("julia.king@example.com", hashPassword("19920715"));

        JPanel panel = new JPanel(new GridBagLayout());
        add(panel);
        placeComponents(panel);
    }

    private void placeComponents(JPanel panel) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel userLabel = new JLabel("User ID:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(userLabel, gbc);

        userText = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(userText, gbc);

        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(passwordLabel, gbc);

        passwordText = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(passwordText, gbc);

        JLabel userTypeLabel = new JLabel("User Type:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(userTypeLabel, gbc);

        userTypeCombo = new JComboBox<>(new String[]{"Admin", "Employee"});
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(userTypeCombo, gbc);

        JButton loginButton = new JButton("Login");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(loginButton, gbc);

        loginButton.addActionListener((ActionEvent e) -> {
            String userID = userText.getText();
            String password = new String(passwordText.getPassword());
            String userType = (String) userTypeCombo.getSelectedItem();
            if (validateLogin(userID, password)) {
                JOptionPane.showMessageDialog(panel, "Login Successful");
                openMainWindow(userType);
            } else {
                JOptionPane.showMessageDialog(panel, "Invalid User ID or Password");
            }
        });
    }

    private boolean validateLogin(String userID, String password) {
        if (userCredentials.containsKey(userID)) {
            String storedHash = userCredentials.get(userID);
            return hashPassword(password).equals(storedHash);
        }
        return false;
    }

    private void openMainWindow(String userType) {
        if ("Admin".equals(userType)) {
            AdminMainWindow adminMainWindow = new AdminMainWindow();
            adminMainWindow.setVisible(true);
        } else {
            EmployeeMainWindow employeeMainWindow = new EmployeeMainWindow();
            employeeMainWindow.setVisible(true);
        }
        dispose();
    }

    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginWindow loginWindow = new LoginWindow();
            loginWindow.setVisible(true);
        });
    }
}