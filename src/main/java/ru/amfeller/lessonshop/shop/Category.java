package ru.amfeller.lessonshop.shop;

import ru.amfeller.lessonshop.shop.product.Product;

public class Category {
    private String name;
    private Product[] products;

    public Category(String name) {
        this.name = name;
    }

    public Category(String name, Product[] products) {
        this(name);
        this.products = products;
    }

    protected String getName() {
        return name;
    }

    protected Product[] getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return name;
    }
}
