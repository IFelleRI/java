package ru.amfeller.lessonshop.store.exception;

public class WrongChoiceException extends RuntimeException {
    public WrongChoiceException(){
      super("Выбранной операции не существует");
    }
    public WrongChoiceException(String message) {
        super(message);
    }
}
