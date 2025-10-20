package ru.amfeller.lessonshop.menu;

import ru.amfeller.lessonshop.operations.Operation;
import ru.amfeller.lessonshop.user.State;

public class MenuItem implements MenuComponent {
    private final String title;
    private final Operation operation;
    private final State userState;

    public MenuItem(String title) {
        this(title, null);
    }

    public MenuItem(String title, Operation operation) {
        this(title, operation, null);
    }

    public MenuItem(String title, Operation operation, State userState) {
        this.title = title;
        this.operation = operation;
        this.userState = userState;
    }

    public Operation getOperation() {
        return operation;
    }

    @Override
    public String getName() {
        return title;
    }

    @Override
    public void doAction() {
        if (operation != null) {
            this.operation.doOperation();
        }
    }
}
