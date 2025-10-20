package ru.amfeller.lessonshop.shop;

import ru.amfeller.lessonshop.delivery.company.DeliveryCompany;
import ru.amfeller.lessonshop.shop.product.Product;
import ru.amfeller.lessonshop.user.User;

public class ShopSession {
    private final Cart cart;
    private final Category[] categories;
    private Category category;
    private DeliveryCompany[] deliveryCompanies;
    private final User user;
    private DeliveryCompany tmpDeliveryCompany;
    private DeliveryCompany deliveryCompany;

    public ShopSession(Cart cart, Category[] categories, DeliveryCompany[] companies, User user) {
        this.cart = cart;
        this.categories = categories;
        this.deliveryCompanies = companies;
        this.user = user;
    }

    public Category[] getCategories() {
        return categories;
    }

    public Category getCategory() {
        return category;
    }

    public Cart getCart() {
        return cart;
    }

    public Product[] getProducts() {
        if (category != null && category.getProducts() != null) {
            return category.getProducts();
        }
        if(getCart().getProducts() != null) {
            return getCart().getProducts();
        }
        return null;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public DeliveryCompany[] getCompanies() {
        return deliveryCompanies;
    }

    public void setCompanies(DeliveryCompany[] companies) {
        this.deliveryCompanies = companies;
    }

    public void setTmpCompany(DeliveryCompany tmpDeliveryCompany) {
        this.tmpDeliveryCompany = tmpDeliveryCompany;
    }

    public DeliveryCompany getTmpCompany() {
        return tmpDeliveryCompany;
    }

    public DeliveryCompany getCompany() {
        return deliveryCompany;
    }

    public void setCompany() {
        this.deliveryCompany = this.tmpDeliveryCompany;
    }

    public User getUser() {
        return user;
    }
}
