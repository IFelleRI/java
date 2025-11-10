package ru.amfeller.lessonshop.shop;

import ru.amfeller.lessonshop.shop.product.Product;
import ru.amfeller.lessonshop.shop.product.TypeProduct;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> products = new ArrayList<>();
    private int sum;

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(int product) {
        products.remove(product);
    }

    public void buy(int deliveryPrice) {
        System.out.println();
        System.out.format("%-15s %10s%n", "Товар", "Цена");
        System.out.println("----------------------------------------");
        for (Product product : products) {
            System.out.format("%-15s %10s%n",
                    product.getName(),
                    product.getPrice() + " руб.");
        }
        System.out.format("%-15s %10s%n",
                "Доставка",
                deliveryPrice + " руб.");
        System.out.println("----------------------------------------");
        System.out.format("%-15s %10s%n", "Итого:", calcSum() + deliveryPrice + " руб.");
        clear();
    }

    public void clear() {
        this.sum = 0;
        this.products = null;
    }

    private int calcSum() {
        for (Product product : products) {
            this.sum += product.getPrice();
        }
        return this.sum;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

}
