package ru.amfeller.lessonshop.operations.cart;

import ru.amfeller.lessonshop.menu.MenuNavigator;
import ru.amfeller.lessonshop.operations.Operation;
import ru.amfeller.lessonshop.shop.Cart;
import ru.amfeller.lessonshop.shop.ShopSession;
import ru.amfeller.lessonshop.shop.ShopUtils;
import ru.amfeller.lessonshop.shop.product.Product;
import ru.amfeller.lessonshop.user.State;


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
        Product[] products = cart.getProducts();
        if (products == null || products.length == 0) {
            System.out.println("Корзина пустая");
            MenuNavigator.stepBack = true;
            return;
        }
        System.out.println(ShopUtils.printProducts(cart.getProducts()));
        this.shopSession.getUser().setUserState(this.state);
    }
}
