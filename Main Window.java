import javax.swing.*;

public class MainWindow {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Payroll Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> new LoginWindow());

        frame.getContentPane().add(loginButton);
        frame.setVisible(true);
    }
}
