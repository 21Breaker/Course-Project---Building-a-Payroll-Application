public class Example {
    public static void main(String[] args) {
        String password = "Jolly202050+!";
        String hashedPassword = PasswordUtil.hashPassword(password);
        System.out.println("Hashed password: " + hashedPassword);
    }
}
