package ru.amfeller.lessonshop.catalog.product;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable {
    protected String name;
    protected int price;
    protected TypeProduct type;
    private int rating;
    private String propertiesForFile = "";

    public Product() {

    }

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

    public int getRating() {
        return rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setType(TypeProduct type) {
        this.type = type;
    }

    public String getPropertiesForFile() {
        generateProperties();
        return propertiesForFile;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    private void generateProperties() {
        this.propertiesForFile = "[name=" + this.getName() + "#price=" + this.getPrice() + "#type=" + this.getType() + "#rating=" + this.getRating() + "]";
    }

    @Override
    public String toString() {
        return name;
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
