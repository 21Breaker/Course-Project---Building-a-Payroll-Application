import java.awt.*;
import javax.swing.*;

public class MainWindow extends JFrame {
    public MainWindow() {
        setTitle("ABC Company Payroll System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        add(panel);
        placeComponents(panel);
    }

    private void placeComponents(JPanel panel) {
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JButton loginButton = new JButton("Login");
        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonPanel.add(loginButton, gbc);

        JButton exitButton = new JButton("Exit Program");
        gbc.gridx = 0;
        gbc.gridy = 1;
        buttonPanel.add(exitButton, gbc);

        panel.add(buttonPanel, BorderLayout.CENTER);

        loginButton.addActionListener(e -> openLoginWindow());
        exitButton.addActionListener(e -> System.exit(0));
    }

    private void openLoginWindow() {
        LoginWindow loginWindow = new LoginWindow();
        loginWindow.setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainWindow mainWindow = new MainWindow();
            mainWindow.setVisible(true);
        });
    }
}