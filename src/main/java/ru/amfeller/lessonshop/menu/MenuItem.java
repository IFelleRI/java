package ru.amfeller.lessonshop.menu;

import ru.amfeller.lessonshop.operations.Operation;

public class MenuItem implements MenuComponent {
    private final String title;
    private final Operation operation;

    public MenuItem(String title, Operation operation) {
        this.title = title;
        this.operation = operation;
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
