package ru.amfeller.lessonshop.delivery.company;

import ru.amfeller.lessonshop.delivery.DeliveryService;
import ru.amfeller.lessonshop.delivery.pack.Package;
import ru.amfeller.lessonshop.shop.ShopUtils;
import ru.amfeller.lessonshop.shop.product.TypeProduct;

public abstract class Company implements DeliveryService {
    protected TypeProduct[] typeProducts;
    protected int speed;
    protected int price;
    protected String name;
    private int deliveryPrice;

    public Company(String name, TypeProduct[] types, int speed, int price) {
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

    @Override
    public void deliver(Package pack) {
        this.deliveryPrice = calculateCost(pack);
        System.out.println("Компания доставки: " + name);
        System.out.println("Адрес доставки: " + pack.getAddress());
        System.out.println("Срок доставки: " + calculateSpeed(pack) + " " + ShopUtils.pluralize(calculateSpeed(pack), "день", "дня", "дней"));
        System.out.println("Стоимость доставки: " + calculateCost(pack) + " руб.");
    }

    @Override
    public int calculateCost(Package pack) {
        return this.price * pack.getProducts().length;
    }

    @Override
    public String toString() {
        return name;
    }
}
