package ru.amfeller.lessonshop.shop;

import ru.amfeller.lessonshop.delivery.company.DeliveryCompany;
import ru.amfeller.lessonshop.menu.MenuGenerator;
import ru.amfeller.lessonshop.user.Auth;
import ru.amfeller.lessonshop.user.User;

import java.util.ArrayList;

public class Shop {
    private final ArrayList<Category> categories;
    private final ArrayList<DeliveryCompany> deliveryCompanies;

    public Shop(ArrayList<Category> categories, ArrayList<DeliveryCompany> companies) {
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
