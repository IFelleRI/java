package ru.amfeller.lessonshop.shop;

import ru.amfeller.lessonshop.shop.product.Product;
import ru.amfeller.lessonshop.shop.product.TypeProduct;

public class Cart {
    private Product[] products;
    private int sum;

    public void addProduct(Product product) {
        if (products == null) {
            products = new Product[]{product};
            return;
        }
        Product[] tmpArr = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmpArr[i] = products[i];
        }
        tmpArr[tmpArr.length - 1] = product;
        this.products = tmpArr;
    }

    public void removeProduct(int product) {
        products[product] = null;
        Product[] tmpArr = new Product[products.length - 1];
        for (int i = 0, j = 0; i < products.length; i++) {
            if (products[i] == null) {
                continue;
            }
            tmpArr[j++] = products[i];
        }
        this.products = tmpArr;
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

    public Product[] getProducts() {
        return products;
    }

}
