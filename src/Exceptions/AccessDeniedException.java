package Exceptions;

public class AccessDeniedException extends Exception{
    public AccessDeniedException(int ACCESS_AGE, int age) {
        super("Доступ запрещен лицам моложе " + ACCESS_AGE + " лет. Вам " + age + " лет.");
    }
}
