package ru.amfeller.lessonshop.operations.product;

import ru.amfeller.lessonshop.operations.Operation;
import ru.amfeller.lessonshop.shop.Cart;
import ru.amfeller.lessonshop.shop.ShopSession;
import ru.amfeller.lessonshop.shop.ShopUtils;
import ru.amfeller.lessonshop.shop.product.Product;
import ru.amfeller.lessonshop.user.State;

import java.util.ArrayList;

public class BuyProductOperation implements Operation {
    private final ShopSession shopSession;
    private final State state;

    public BuyProductOperation(ShopSession shopSession, State state) {
        this.shopSession = shopSession;
        this.state = state;
    }

    @Override
    public void doOperation() {
        ArrayList<Product> products = shopSession.getCategoryProducts();
        Cart cart = shopSession.getCart();
        System.out.print("Введите № товара: ");
        int option = ShopUtils.getChoice(products.size(), "");
        Product product = products.get(option);
        System.out.println("Купили товар: " + product.getName());
        cart.addProduct(product);
        this.shopSession.getUser().setUserState(this.state);
    }
}
