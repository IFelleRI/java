package ru.amfeller.lessonshop.shop.product;

import java.util.Objects;

public class Product {
    protected String name;
    protected int price;
    protected TypeProduct type;

    public Product(String name, int price) {
        this(name, price, TypeProduct.DEFAULT);
    }

    public Product(String name, int price, TypeProduct type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public TypeProduct getType() {
        return type;
    }

    @Override
    public String toString() {
        return name+" "+type;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
