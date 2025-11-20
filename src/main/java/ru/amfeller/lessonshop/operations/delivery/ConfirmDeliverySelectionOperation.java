package ru.amfeller.lessonshop.operations.delivery;

import ru.amfeller.lessonshop.menu.MenuNavigator;
import ru.amfeller.lessonshop.operations.Operation;
import ru.amfeller.lessonshop.store.ShopSession;

public class ConfirmDeliverySelectionOperation implements Operation {

    private final ShopSession shopSession;

    public ConfirmDeliverySelectionOperation(ShopSession shopSession) {
        this.shopSession = shopSession;
    }

    @Override
    public void doOperation() {
        this.shopSession.setDeliveryCompany();
        MenuNavigator.showTitle = false;
        System.out.println("Выбрали: " + this.shopSession.getDeliveryCompany().getName());
    }
}
