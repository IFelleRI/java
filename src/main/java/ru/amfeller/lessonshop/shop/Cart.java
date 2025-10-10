package ru.amfeller.lessonshop.shop;

import ru.amfeller.lessonshop.shop.product.Product;
import ru.amfeller.lessonshop.shop.product.TypeProduct;

import java.util.Arrays;

public class Cart {
    private Product[] products;
    private int sum;

    public void addProduct(Product product) {
        if (products == null) {
            products = new Product[]{product};
            return;
        }
        Product[] tmpArr = new Product[products.length + 1];
        System.arraycopy(products, 0, tmpArr, 0, products.length);
        tmpArr[tmpArr.length - 1] = product;
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
        System.out.format("%-15s %10s%n", "Итого:", calcSum()+deliveryPrice + " руб.");
        deleteProduct();
    }

    public void deleteProduct() {
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

    public TypeProduct getType() {
        for (Product product : products) {
            if (product.getType() == TypeProduct.DELICATE) return TypeProduct.DELICATE;
        }
        return TypeProduct.DEFAULT;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "products=" + Arrays.toString(products) +
                ", sum=" + sum +
                '}';
    }
}
