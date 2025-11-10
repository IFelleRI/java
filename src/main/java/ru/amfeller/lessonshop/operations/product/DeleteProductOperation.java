package ru.amfeller.lessonshop.operations.product;

import ru.amfeller.lessonshop.menu.MenuNavigator;
import ru.amfeller.lessonshop.operations.Operation;
import ru.amfeller.lessonshop.shop.Cart;
import ru.amfeller.lessonshop.shop.ShopSession;
import ru.amfeller.lessonshop.shop.ShopUtils;
import ru.amfeller.lessonshop.shop.product.Product;

import java.util.ArrayList;

public class DeleteProductOperation implements Operation {
    private final ShopSession shopSession;

    public DeleteProductOperation(ShopSession shopSession) {
        this.shopSession = shopSession;
    }
    @Override
    public void doOperation() {
        ArrayList<Product> products = shopSession.getCategoryProducts();
        Cart cart = shopSession.getCart();
        System.out.print("Введите № товара: ");
        int option = ShopUtils.getChoice(products.size(), "");
        cart.removeProduct(option);
        MenuNavigator.stepBack = true;
    }
}
