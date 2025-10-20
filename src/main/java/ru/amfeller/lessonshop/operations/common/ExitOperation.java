package ru.amfeller.lessonshop.operations.common;

import ru.amfeller.lessonshop.operations.Operation;

public class ExitOperation implements Operation {
    @Override
    public void doOperation() {
        System.out.println("Выход из магазин");
        System.exit(0);
    }
}
