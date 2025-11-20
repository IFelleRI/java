package ru.amfeller.lessonshop.operations.product;

import ru.amfeller.lessonshop.operations.Operation;
import ru.amfeller.lessonshop.store.ShopSession;

public class ReviewProductOperation implements Operation {
    private final ShopSession shopSession;

    public ReviewProductOperation(ShopSession shopSession) {
        this.shopSession = shopSession;
    }

    @Override
    public void doOperation() {
    }
}
