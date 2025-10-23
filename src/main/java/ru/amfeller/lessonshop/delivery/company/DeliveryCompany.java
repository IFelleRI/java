package ru.amfeller.lessonshop.delivery.company;

import ru.amfeller.lessonshop.delivery.DeliveryPackage;
import ru.amfeller.lessonshop.shop.ShopUtils;
import ru.amfeller.lessonshop.shop.product.Product;
import ru.amfeller.lessonshop.shop.product.TypeProduct;

public abstract class DeliveryCompany implements DeliveryService {
    protected TypeProduct[] typeProducts;
    protected int speed;
    protected int price;
    protected String name;

    public DeliveryCompany(String name, TypeProduct[] types, int speed, int price) {
        this.speed = speed;
        this.price = price;
        this.name = name;
        this.typeProducts = types;
    }

    public void info(DeliveryPackage pack) {
        int currentSpeed = calculateSpeed(pack);
        int currenPrice = calculateCost(pack);
        System.out.println("Компания доставки: " + name);
        System.out.println("Адрес доставки: " + pack.getAddress());
        System.out.println("Срок доставки: " + currentSpeed + " " + ShopUtils.pluralize(currentSpeed, "день", "дня", "дней"));
        System.out.println("Стоимость доставки: " + currenPrice + " руб.");
    }

    protected <K, V> int getExtraValue(K[] key, V[] value, DeliveryPackage pack) {
        int extraValue = 0;
        for (int i = 0; i < pack.getTypes().length; i++) {
            for (int j = 0; j < key.length; j++) {
                if (pack.getTypes()[i] == key[j]) {
                    extraValue += (Integer) value[j];
                    break;
                }
            }
        }
        return extraValue;
    }

    public int getDeliveryPrice() {
        return this.price;
    }

    public String getName() {
        return name;
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
    public abstract void deliver();

    @Override
    public abstract int calculateCost(DeliveryPackage pack);

    @Override
    public String toString() {
        return name;
    }
}
