package ru.amfeller.lessonshop.user.exception;

public class WrongLoginException extends RuntimeException {
    public WrongLoginException(String message) {
        super(message);
    }
    public WrongLoginException() {
        super("Неверный логин");
    }
}
