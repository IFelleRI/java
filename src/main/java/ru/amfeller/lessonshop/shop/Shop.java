package ru.amfeller.lessonshop.shop;

import ru.amfeller.lessonshop.delivery.company.DeliveryCompany;
import ru.amfeller.lessonshop.menu.MenuGenerator;
import ru.amfeller.lessonshop.user.Auth;
import ru.amfeller.lessonshop.user.User;

public class Shop {
    private final Category[] categories;
    private final DeliveryCompany[] companies;

    public Shop(Category[] categories, DeliveryCompany[] companies) {
        this.categories = categories;
        this.companies = companies;
    }

    public void init() {
        User user = new Auth().start();
        Cart cart = user.getCart();
        ShopSession shopSession = new ShopSession(cart, this.categories, this.companies, user);
        MenuGenerator menu = new MenuGenerator(shopSession,this);
        menu.init();
    }

    public  void restart() {
        init();
    }
}
