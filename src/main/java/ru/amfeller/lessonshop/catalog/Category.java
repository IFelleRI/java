package ru.amfeller.lessonshop.catalog;

import ru.amfeller.lessonshop.catalog.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private List<Product> products = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }

    public Category(String name, List<Product> products) {
        this(name);
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return name;
    }
}
