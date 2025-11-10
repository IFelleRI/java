package ru.amfeller.lessonshop.shop;

import ru.amfeller.lessonshop.delivery.company.DeliveryCompany;
import ru.amfeller.lessonshop.shop.product.Product;
import ru.amfeller.lessonshop.user.User;

import java.util.ArrayList;

public class ShopSession {
    private final Cart cart;
    private final ArrayList<Category> categories;
    private Category category;
    private ArrayList<DeliveryCompany> deliveryCompanies;
    private final User user;
    private DeliveryCompany tmpDeliveryCompany;
    private DeliveryCompany deliveryCompany;

    public ShopSession(Cart cart, ArrayList<Category> categories, ArrayList<DeliveryCompany> companies, User user) {
        this.cart = cart;
        this.categories = categories;
        this.deliveryCompanies = companies;
        this.user = user;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public Category getCategory() {
        return category;
    }

    public Cart getCart() {
        return cart;
    }

    public ArrayList<Product> getCategoryProducts() {
        if (category != null && category.getProducts() != null) {
            return category.getProducts();
        }
        return null;
    }

    public ArrayList<Product> getCartProducts() {
        return getCart().getProducts();
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public ArrayList<DeliveryCompany> getCompanies() {
        return deliveryCompanies;
    }

    public void setCompanies(ArrayList<DeliveryCompany> companies) {
        this.deliveryCompanies = companies;
    }

    public void setTmpCompany(DeliveryCompany tmpDeliveryCompany) {
        this.tmpDeliveryCompany = tmpDeliveryCompany;
    }

    public DeliveryCompany getTmpCompany() {
        return tmpDeliveryCompany;
    }

    public DeliveryCompany getDeliveryCompany() {
        return deliveryCompany;
    }

    public void setDeliveryCompany() {
        this.deliveryCompany = this.tmpDeliveryCompany;
    }

    public User getUser() {
        return user;
    }
}
