import Exceptions.UserNotFoundException;
import Exceptions.AccessDeniedException;
import java.util.Scanner;

public class Main {
    public static final int ACCESS_AGE = 18;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите логин");
        String login = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();

        User user = getUserByLoginAndPassword(login, password);
        validateUser(user);
    }

    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUsers();
        for (User user : users) {
            if (login.equals(user.login) && password.equals(user.password)) {
                return user;
            }
        }
        throw new UserNotFoundException(login);
    }

    public static User[] getUsers() {
        User user1 = new User("first", "qwery", "kra@mail.ru", 20);
        User user2 = new User("second", "qwerty", "kra@mail.ru", 13);
        User user3 = new User("third", "qwety", "kra@mail.ru", 28);
        return new User[]{user1, user2, user3};
    }

    public static void validateUser(User user) throws AccessDeniedException {
        boolean checked = user.age > ACCESS_AGE;
        if (checked) {
            System.out.println("Доступ предоставлен пользователю " + user.login);
        } else {
            throw new AccessDeniedException(ACCESS_AGE, user.age);
        }
    }
}