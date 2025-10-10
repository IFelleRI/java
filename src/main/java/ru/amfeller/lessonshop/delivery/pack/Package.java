package ru.amfeller.lessonshop.delivery.pack;

import ru.amfeller.lessonshop.delivery.Address;
import ru.amfeller.lessonshop.shop.product.Product;
import ru.amfeller.lessonshop.shop.product.TypeProduct;
import ru.amfeller.lessonshop.user.User;

import java.util.Arrays;

public class Package {
    protected User user;
    protected Product[] products;
    protected Address address;

    public Package(User user, Product[] products, Address address) {
        this.user = user;
        this.products = products;
        this.address = address;
    }

    public Product[] getProducts() {
        return products;
    }

    public Address getAddress() {
        return address;
    }

    public TypeProduct getType() {
        for (Product product : products) {
            if(product.getType() == TypeProduct.DELICATE){
                return TypeProduct.DELICATE;
            }
        }
        return TypeProduct.DEFAULT;
    }

    @Override
    public String toString() {
        return "Package{" +
                "user=" + user +
                ", products=" + Arrays.toString(products) +
                ", address=" + address +
                '}';
    }
}
