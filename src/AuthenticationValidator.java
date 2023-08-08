import java.util.regex.Pattern;

public class AuthenticationValidator {

    private static Pattern regex = Pattern.compile("^[A-Za-z0-9_]{0,20}$");
    public static void checkAuthentication(String login,
                                           String password,
                                           String confirmPassword)
            throws WrongPasswordException, WrongLoginException {

        checkLogin(login);
        checkPassword(password);
        checkEqualsPassword(password, confirmPassword);
    }

    private static void checkLogin(String password) {
        if (!password.matches(regex.pattern())) {
            throw new WrongLoginException(
                    "Логин содержит в себе только латинские буквы, " +
                            "цифры и знак подчеркивания. " +
                            "Должен быть не более 20 символов");
        }
    }

    private static void checkPassword(String login) throws WrongPasswordException{
        if (!login.matches(regex.pattern())) {
            throw new WrongPasswordException(
                    "Пароль должен содержать в себе только латинские буквы, " +
                            "цифры и знак подчеркивания. " +
                            "Должен быть не более 20 символов");
        }
    }

    private static void checkEqualsPassword(String password, String confirmPassword)
    throws WrongPasswordException{
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароль и повторный пароль должны " +
                    "совпадать");
        }
    }
}
