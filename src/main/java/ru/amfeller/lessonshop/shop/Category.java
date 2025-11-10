package ru.amfeller.lessonshop.shop;

import ru.amfeller.lessonshop.shop.product.Product;

import java.util.ArrayList;

public class Category {
    private String name;
    private ArrayList<Product> products;

    public Category(String name) {
        this.name = name;
    }

    public Category(String name, ArrayList<Product> products) {
        this(name);
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return name;
    }
}
