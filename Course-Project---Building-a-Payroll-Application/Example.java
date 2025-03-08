public class Example {
    public static void main(String[] args) {
        // Admin password
        String adminPassword = "Jolly202050+!";
        String adminHashedPassword = PasswordUtil.hashPassword(adminPassword);
        System.out.println("Admin Hashed password: " + adminHashedPassword);

        // Employee passwords
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

        String[] employeeNames = {
            "John Doe",
            "Jane Smith",
            "Alice Johnson",
            "Bob Brown",
            "Charlie Davis",
            "Diana Evans",
            "Ethan Foster",
            "Fiona Green",
            "George Harris",
            "Hannah Irving",
            "Ian Jackson",
            "Julia King"
        };

        for (int i = 0; i < employeePasswords.length; i++) {
            String hashedPassword = PasswordUtil.hashPassword(employeePasswords[i]);
            System.out.println(employeeNames[i] + " Hashed password: " + hashedPassword);
        }
    }
}