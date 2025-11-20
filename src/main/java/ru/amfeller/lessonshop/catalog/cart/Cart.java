package ru.amfeller.lessonshop.catalog.cart;

import ru.amfeller.lessonshop.catalog.product.Product;
import ru.amfeller.lessonshop.services.CartFileService;
import ru.amfeller.lessonshop.user.User;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Serializable { //FixMe: По хорошему, сделать POJO
    @Serial
    private static final long serialVersionUID = 4L;

    private final CartFileService service = new CartFileService();
    private List<Product> products = new ArrayList<>();
    private int sum;
    private User user;

    public void addProduct(Product product) {
        products.add(product);
        service.saveCart(this,this.user.getLogin());
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void removeProduct(int product) {
        products.remove(product);
        service.saveCart(this,this.user.getLogin());
    }

    public void buy(int deliveryPrice) {
        Check check = new Check(calcSum(),deliveryPrice,products, user.getLogin());
        check.showCheck();
        check.save();
        clear();
    }

    public void clear() {
        this.sum = 0;
        this.products.clear();
        service.saveCart(this,this.user.getLogin());
    }

    private int calcSum() {
        sum = 0;
        for (Product product : products) {
            sum += product.getPrice();
        }
        return sum;
    }

    public List<Product> getProducts() {
        return products;
    }

}
