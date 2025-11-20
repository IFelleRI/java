package ru.amfeller.lessonshop.store;

import ru.amfeller.lessonshop.catalog.cart.Cart;
import ru.amfeller.lessonshop.catalog.Category;
import ru.amfeller.lessonshop.delivery.company.DeliveryCompany;
import ru.amfeller.lessonshop.catalog.product.Product;
import ru.amfeller.lessonshop.user.User;

import java.util.List;

public class ShopSession {
    private final Cart cart;
    private final List<Category> categories;
    private Category category;
    private List<DeliveryCompany> deliveryCompanies;
    private final User user;
    private DeliveryCompany tmpDeliveryCompany;
    private DeliveryCompany deliveryCompany;

    public ShopSession(Cart cart, List<Category> categories, List<DeliveryCompany> companies, User user) {
        this.cart = cart;
        this.categories = categories;
        this.deliveryCompanies = companies;
        this.user = user;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public Category getCategory() {
        return category;
    }

    public Cart getCart() {
        return cart;
    }

    public List<Product> getCategoryProducts() {
        if (category != null && category.getProducts() != null) {
            return category.getProducts();
        }
        return null;
    }

    public List<Product> getCartProducts() {
        return getCart().getProducts();
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<DeliveryCompany> getCompanies() {
        return deliveryCompanies;
    }

    public void setCompanies(List<DeliveryCompany> companies) {
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
