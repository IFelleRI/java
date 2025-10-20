package ru.amfeller.lessonshop.operations.product;

import ru.amfeller.lessonshop.menu.MenuNavigator;
import ru.amfeller.lessonshop.operations.Operation;
import ru.amfeller.lessonshop.shop.Cart;
import ru.amfeller.lessonshop.shop.ShopSession;
import ru.amfeller.lessonshop.shop.ShopUtils;
import ru.amfeller.lessonshop.shop.product.Product;

public class DeleteProductOperation implements Operation {
    private final ShopSession shopSession;

    public DeleteProductOperation(ShopSession shopSession) {
        this.shopSession = shopSession;
    }
    @Override
    public void doOperation() {
        Product[] products = shopSession.getProducts();
        Cart cart = shopSession.getCart();
        System.out.print("Введите № товара: ");
        int option = ShopUtils.getChoice(products.length, "");
        cart.removeProduct(option);
        MenuNavigator.stepBack = true;
    }
}
