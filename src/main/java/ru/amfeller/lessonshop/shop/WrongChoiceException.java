package ru.amfeller.lessonshop.shop;

public class WrongChoiceException extends RuntimeException {
    public WrongChoiceException(){
      super("Выбранной операции не существует");
    }
    public WrongChoiceException(String message) {
        super(message);
    }
}
