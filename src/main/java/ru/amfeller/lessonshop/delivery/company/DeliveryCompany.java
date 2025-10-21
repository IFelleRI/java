package ru.amfeller.lessonshop.delivery.company;

import ru.amfeller.lessonshop.delivery.DeliveryPackage;
import ru.amfeller.lessonshop.shop.ShopUtils;
import ru.amfeller.lessonshop.shop.product.Product;
import ru.amfeller.lessonshop.shop.product.TypeProduct;

import java.util.Arrays;

public abstract class DeliveryCompany implements DeliveryService {
    protected TypeProduct[] typeProducts;
    protected int speed;
    protected int price;
    protected String name;
    private int deliveryPrice;

    public DeliveryCompany(String name, TypeProduct[] types, int speed, int price) {
        this.speed = speed;
        this.price = price;
        this.name = name;
        this.typeProducts = types;
    }

    public int getDeliveryPrice() {
        return this.deliveryPrice;
    }

    public String getName() {
        return name;
    }

    public void info(DeliveryPackage pack) {
        this.deliveryPrice = calculateCost(pack); // FixMe: bug
        System.out.println("Компания доставки: " + name);
        System.out.println("Адрес доставки: " + pack.getAddress());
        System.out.println("Срок доставки: " + calculateSpeed(pack) + " " + ShopUtils.pluralize(calculateSpeed(pack), "день", "дня", "дней"));
        System.out.println("Стоимость доставки: " + calculateCost(pack) + " руб.");
    }

    public boolean canDeliver(Product[] products) {
        boolean allow;
        for (Product product : products) {
            allow = false;
            for (TypeProduct typeProduct : typeProducts) {
                if (product.getType() == typeProduct) {
                    allow = true;
                }
            }
            if (!allow) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void deliver(DeliveryPackage pack) {
        System.out.println("Отправлено!");
    }

    @Override
    public int calculateCost(DeliveryPackage pack) { // FixMe: abstract
        return this.price * pack.getProducts().length;
    }

    @Override
    public String toString() {
        return name;
    }
}
