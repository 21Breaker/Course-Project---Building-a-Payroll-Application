import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JFrame {
    private JTextField userText;
    private JPasswordField passwordText;

    public LoginWindow() {
        setTitle("ABC Company Payroll System - Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("User ID:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
       );

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userID = userText.getText();
                String password = new String(passwordText.getPassword());
                if (validateLogin(userID, password)) {
                    JOptionPane.showMessageDialog(panel, "Login Successful");
                    openMainWindow();
               Dialog(panel, "Invalid User ID or Password");
                }
            }
        });
    }

    private boolean validateLogin(String userID, String password) {
        return userID.equals("admin") && password.equals("password");
    }

    private void openMainWindow() {
        MainWindow mainWindow = new MainWindow();
        mainWindow.setVisible(true);
        dispose();
    }
}
