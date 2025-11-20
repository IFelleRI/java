package ru.amfeller.lessonshop.operations.cart;

import ru.amfeller.lessonshop.menu.MenuNavigator;
import ru.amfeller.lessonshop.operations.Operation;
import ru.amfeller.lessonshop.catalog.cart.Cart;
import ru.amfeller.lessonshop.store.ShopSession;
import ru.amfeller.lessonshop.store.ShopUtils;
import ru.amfeller.lessonshop.catalog.product.Product;
import ru.amfeller.lessonshop.user.State;

import java.util.List;


public class ShowCartOperation implements Operation {
    private final ShopSession shopSession;
    private final State state;

    public ShowCartOperation(ShopSession currentShop,State state) {
        this.shopSession = currentShop;
        this.state = state;
    }

    @Override
    public void doOperation() {
        Cart cart = this.shopSession.getCart();
        List<Product> products = cart.getProducts();
        if (products.isEmpty()) {
            System.out.println("Корзина пустая");
            MenuNavigator.stepBack = true;
            return;
        }
        System.out.println(ShopUtils.printProducts(cart.getProducts()));
        this.shopSession.getUser().setUserState(this.state);
    }
}
