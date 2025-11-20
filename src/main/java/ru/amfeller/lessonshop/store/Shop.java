package ru.amfeller.lessonshop.store;

import ru.amfeller.lessonshop.catalog.cart.Cart;
import ru.amfeller.lessonshop.catalog.Category;
import ru.amfeller.lessonshop.delivery.company.DeliveryCompany;
import ru.amfeller.lessonshop.menu.MenuGenerator;
import ru.amfeller.lessonshop.user.Auth;
import ru.amfeller.lessonshop.user.User;
import java.util.List;

public class Shop {
    private final List<Category> categories;
    private final List<DeliveryCompany> deliveryCompanies;

    public Shop(List<Category> categories, List<DeliveryCompany> companies) {
        this.categories = categories;
        this.deliveryCompanies = companies;
    }

    public void init() {
        User user = new Auth().start();
        Cart cart = user.getCart();
        ShopSession shopSession = new ShopSession(cart, this.categories, this.deliveryCompanies, user);
        MenuGenerator menu = new MenuGenerator(shopSession,this);
        menu.init();
    }

    public  void restart() {
        init();
    }
}
