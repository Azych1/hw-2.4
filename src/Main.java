public class Main {
    public static void main(String[] args) {
        try {
            AuthenticationValidator.checkAuthentication("loGIn10_", "password", "password1");
            System.out.println("Аутентификация пройдена успешно");
        } catch (WrongLoginException | WrongPasswordException ex) {
            System.out.println(ex.getMessage());
        }
    }
}