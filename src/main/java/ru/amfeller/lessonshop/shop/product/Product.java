package ru.amfeller.lessonshop.shop.product;

import ru.amfeller.lessonshop.shop.Category;

public class Product {
    protected String name;
    protected int price;
    protected int rating;
    protected Category category;
    protected TypeProduct type;

    public Product(String name, int price) {
        this(name, price, TypeProduct.DEFAULT);
    }

    public Product(String name, int price,TypeProduct type) {
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

    public TypeProduct getType(){
        return type;
    }

    @Override
    public String toString() {
        return name;
    }
}
