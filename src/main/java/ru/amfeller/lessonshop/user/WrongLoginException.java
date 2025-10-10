package ru.amfeller.lessonshop.user;

public class WrongLoginException extends RuntimeException {
    public WrongLoginException(String message) {
        super(message);
    }
    public WrongLoginException() {
        super("Неверный логин");
    }
}
