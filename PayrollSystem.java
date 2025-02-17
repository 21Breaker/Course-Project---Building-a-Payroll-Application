import java.util.*;

public class PayrollSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to ABC Company Payroll System");
        System.out.println("1. Login");
        System.out.println("2. Exit");
        int choice = scanner.nextInt();
        
        if (choice == 1) {
            login(scanner);
        } else {
            System.out.println("Exiting the system.");
        }
    }

    private static void login(Scanner scanner) {
        System.out.print("Enter User ID: ");
        String userId = scanner.next();
        System.out.print("Enter Password: ");
        String password = scanner.next();
        
        // Dummy check for login
        if (userId.equals("HR0001") && password.equals("securepassword")) {
            adminMenu(scanner);
        } else {
            System.out.println("Invalid credentials. Try again.");
        }
    }

    private static void adminMenu(Scanner scanner) {
        System.out.println("Admin Menu");
        System.out.println("1. Employee Demographics");
        System.out.println("2. Payroll Information");
        System.out.println("3. Add/Edit/Delete Employee");
        System.out.println("4. Employee Search");
        System.out.println("5. Reporting");
        System.out.println("6. Application Information");
        System.out.println("7. Logout");
        
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                // Implement employee demographics access
                break;
            case 2:
                // Implement payroll information access
                break;
            case 3:
                // Implement add/edit/delete employee
                break;
            case 4:
                // Implement employee search
                break;
            case 5:
                // Implement reporting
                break;
            case 6:
                // Display application information
                break;
            case 7:
                System.out.println("Logging out...");
                break;
            default:
                System.out.println("Invalid choice. Try again.");
        }
    }
}
