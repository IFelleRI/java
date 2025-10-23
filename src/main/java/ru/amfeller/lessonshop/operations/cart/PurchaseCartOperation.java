package ru.amfeller.lessonshop.operations.cart;

import ru.amfeller.lessonshop.menu.MenuNavigator;
import ru.amfeller.lessonshop.operations.Operation;
import ru.amfeller.lessonshop.shop.Cart;
import ru.amfeller.lessonshop.shop.ShopSession;
import ru.amfeller.lessonshop.user.State;

public class PurchaseCartOperation implements Operation {
    private final Cart cart;
    private final ShopSession shopSession;
    private final State state;

    public PurchaseCartOperation(ShopSession shopSession, State state) {
        this.cart = shopSession.getCart();
        this.shopSession = shopSession;
        this.state = state;
    }

    @Override
    public void doOperation() {
        if(shopSession.getDeliveryCompany() == null) {
            System.out.println("Не выбрана компания доставки!");
            MenuNavigator.stepBack = true;
            return;
        }
        cart.buy(shopSession.getDeliveryCompany().getDeliveryPrice());
        MenuNavigator.homeBack = true;
        this.shopSession.getUser().setUserState(this.state);
        this.shopSession.getDeliveryCompany().deliver();
    }
}
