public class Example {
    public static void main(String[] args) {
        // Admin password
        String adminPassword = "Jolly202050+!";
        String adminHashedPassword = PasswordUtil.hashPassword(adminPassword);
        System.out.println("Admin Hashed password: " + adminHashedPassword);

        // Employee data
        String[] employeeEmails = {
            "john.doe@example.com",
            "jane.smith@example.com",
            "alice.johnson@example.com",
            "bob.brown@example.com",
            "charlie.davis@example.com",
            "diana.evans@example.com",
            "ethan.foster@example.com",
            "fiona.green@example.com",
            "george.harris@example.com",
            "hannah.irving@example.com",
            "ian.jackson@example.com",
            "julia.king@example.com"
        };

        String[] employeePasswords = {
            "19850115", // John Doe
            "19900220", // Jane Smith
            "19870330", // Alice Johnson
            "19881210", // Bob Brown
            "19910505", // Charlie Davis
            "19860625", // Diana Evans
            "19930315", // Ethan Foster
            "19891120", // Fiona Green
            "19870410", // George Harris
            "19901230", // Hannah Irving
            "19880525", // Ian Jackson
            "19920715"  // Julia King
        };

        for (int i = 0; i < employeeEmails.length; i++) {
            String email = employeeEmails[i];
            String password = employeePasswords[i];
            String hashedPassword = PasswordUtil.hashPassword(password);
            System.out.println(email + " Hashed password: " + hashedPassword);
        }
    }
}