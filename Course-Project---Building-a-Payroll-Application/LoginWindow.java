import java.awt.*;
import java.awt.event.ActionEvent;
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
        userCredentials.put("HR0001", PasswordUtil.hashPassword("ad02670e4187288b4c03918c0f10d862308428316faeea41056f5843cc8d8d13"));
        userCredentials.put("john.doe", PasswordUtil.hashPassword("e8ab8864fffd825620755fb784b33bb018b4a6e143f84185323418aabf367afa"));
        userCredentials.put("jane.smith", PasswordUtil.hashPassword("0632c90988a948aeb81a7094daf1c87c708337ec6ac69ebb56e034141dee7af9"));
        userCredentials.put("alice.johnson", PasswordUtil.hashPassword("27fe45bd6154926fb35049a01eac329f595a2de63b6e676bf2395bd088296e97"));
        userCredentials.put("bob.brown", PasswordUtil.hashPassword("5a0c0517e0a47baa949c066158524fb284e0f223f8e5423f9d52dbde6bc78076"));
        userCredentials.put("charlie.davis", PasswordUtil.hashPassword("63770b3d80c8edfc27ae4d9ad0c6dd039c90283394758f8ecdbc41765c9c9eeb"));
        userCredentials.put("diana.evans", PasswordUtil.hashPassword("c145211e6020a10e674861336c418250860bdb8750b1f4f6c67980adee76cc3f"));
        userCredentials.put("ethan.foster", PasswordUtil.hashPassword("5fb14120d4b43715171d9932925659d68542af5566db7f5ba7bedd0b0794b483"));
        userCredentials.put("fiona.green", PasswordUtil.hashPassword("0d0c6c6cb41bb4eb0af1a69558436ae9ce09a95b2e18d49c71783748b58f9a17"));
        userCredentials.put("george.harris", PasswordUtil.hashPassword("aa7ee51ad5b707079e23c007e51d71925f363963d04bf71993cbf1f9a1922cec"));
        userCredentials.put("hannah.irving", PasswordUtil.hashPassword("da257f4cb0f87e490424850bf8dc40fd25481b316912b2c00c6c0c3b481e70bc"));
        userCredentials.put("ian.jackson", PasswordUtil.hashPassword("ddb6d10ead51b24f71ef254f21a95a623074e07127bc7f2a9fe9bdb7c9a3865e"));
        userCredentials.put("julia.king", PasswordUtil.hashPassword("43aa3d2bd1ef38be304296b8a23797095acd4d6dc38856ba3d7325f6df7fbbe3"));

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
            return PasswordUtil.hashPassword(password).equals(storedHash);
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginWindow loginWindow = new LoginWindow();
            loginWindow.setVisible(true);
        });
    }
}