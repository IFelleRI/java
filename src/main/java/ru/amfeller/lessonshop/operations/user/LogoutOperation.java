package ru.amfeller.lessonshop.operations.user;

import ru.amfeller.lessonshop.operations.Operation;
import ru.amfeller.lessonshop.shop.Shop;

public class LogoutOperation implements Operation {
    private final Shop shop;

    public LogoutOperation(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void doOperation() {
        this.shop.restart();
    }
}
