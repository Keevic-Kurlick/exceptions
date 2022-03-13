package Exceptions;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String input) {
        super("Пользователь " + input + " не найден");
    }
}
