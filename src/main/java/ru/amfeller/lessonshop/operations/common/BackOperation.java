package ru.amfeller.lessonshop.operations.common;

import ru.amfeller.lessonshop.operations.Operation;

public class BackOperation implements Operation {
    @Override
    public void doOperation() {
        System.out.println("Назад");
    }
}
