import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import org.mindrot.jbcrypt.BCrypt;

public class LoginWindow extends JFrame {
    private JTextField userText;
    private JPasswordField passwordText;

    public LoginWindow() {
        setTitle("ABC Company Payroll System - Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

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

        JButton loginButton = new JButton("Login");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(loginButton, gbc);

        loginButton.addActionListener((ActionEvent e) -> {
            String userID = userText.getText();
            String password = new String(passwordText.getPassword());
            if (validateLogin(userID, password)) {
                JOptionPane.showMessageDialog(panel, "Login Successful");
                openMainWindow();
            } else {
                JOptionPane.showMessageDialog(panel, "Invalid User ID or Password");
            }
        });
    }

    private boolean validateLogin(String userID, String password) {
        // Dummy hashed password for demonstration purposes
        String storedHash = "$2a$10$DowJ8J8J8J8J8J8J8J8J8uJ8J8J8J8J8J8J8J8J8J8J8J8J8J8J8";
        return userID.equals("admin") && BCrypt.checkpw(password, storedHash);
    }

    private void openMainWindow() {
        MainWindow mainWindow = new MainWindow();
        mainWindow.setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginWindow loginWindow = new LoginWindow();
            loginWindow.setVisible(true);
        });
    }
}