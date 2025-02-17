import javax.swing.*;

public class LoginWindow {
    public LoginWindow() {
        // Create the login frame
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 200);

        // Create and add the panel to the frame
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true); // Display the frame
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null); // Use null layout for custom positioning

        // Create and add user ID label and text field
        JLabel userLabel = new JLabel("User ID:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        // Create and add password label and text field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        // Create and add login button
        JButton loginButton = new JButton("Login");
       (10, 80, 80, 25);
        loginButton.addActionListener(e -> {
            String userId = userText.getText();
            String password = new String(passwordText.getPassword());
            // Check credentials and open appropriate window
            if (userId.equals("HR0001") && password.equals("securePassword")) {
                new AdminWindow();
            } else {
                new EmployeeWindow();
            }
            ((JFrame) SwingUtilities.getWindowAncestor(panel)).dispose(); // Close login window
        });
        panel.add(loginButton);
    }
}
