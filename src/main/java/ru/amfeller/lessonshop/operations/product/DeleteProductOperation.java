package ru.amfeller.lessonshop.operations.product;

import ru.amfeller.lessonshop.menu.MenuNavigator;
import ru.amfeller.lessonshop.operations.Operation;
import ru.amfeller.lessonshop.catalog.cart.Cart;
import ru.amfeller.lessonshop.store.ShopSession;
import ru.amfeller.lessonshop.store.ShopUtils;
import ru.amfeller.lessonshop.catalog.product.Product;

import java.util.List;

public class DeleteProductOperation implements Operation {
    private final ShopSession shopSession;

    public DeleteProductOperation(ShopSession shopSession) {
        this.shopSession = shopSession;
    }
    @Override
    public void doOperation() {
        List<Product> products = shopSession.getCategoryProducts();
        Cart cart = shopSession.getCart();
        System.out.print("Введите № товара: ");
        int option = ShopUtils.getChoice(products.size(), "");
        cart.removeProduct(option);
        MenuNavigator.stepBack = true;
    }
}
