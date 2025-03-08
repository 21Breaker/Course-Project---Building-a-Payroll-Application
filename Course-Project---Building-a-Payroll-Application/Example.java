import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Example {
    public static void main(String[] args) {
        // Admin password
        String adminPassword = "Jolly202050+!";
        String adminHashedPassword = hashPassword(adminPassword);
        System.out.println("Admin Password: " + adminPassword);
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
            String hashedPassword = hashPassword(password);
            System.out.println("Email: " + email);
            System.out.println("Password: " + password);
            System.out.println("Hashed password: " + hashedPassword);
        }
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
}