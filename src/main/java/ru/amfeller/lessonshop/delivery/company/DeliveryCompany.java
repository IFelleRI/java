package ru.amfeller.lessonshop.delivery.company;

import ru.amfeller.lessonshop.delivery.DeliveryPackage;
import ru.amfeller.lessonshop.shop.ShopUtils;
import ru.amfeller.lessonshop.shop.product.Product;
import ru.amfeller.lessonshop.shop.product.TypeProduct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class DeliveryCompany implements DeliveryService {
    protected ArrayList<TypeProduct> typeProducts;
    protected Map<TypeProduct, Integer> speed;
    protected Map<TypeProduct, Integer> price;
    protected String name;
    protected int resultPrice;

    public DeliveryCompany(String name,  Map<TypeProduct, Integer> speed, Map<TypeProduct, Integer> price) {
        this.speed = speed;
        this.price = price;
        this.name = name;
    }

    public void info(DeliveryPackage pack) {
        int currentSpeed = calculateSpeed(pack);
        int currenPrice = calculateCost(pack);
        System.out.println("Компания доставки: " + name);
        System.out.println("Адрес доставки: " + pack.getAddress());
        System.out.println("Срок доставки: " + currentSpeed + " " + ShopUtils.pluralize(currentSpeed, "день", "дня", "дней"));
        System.out.println("Стоимость доставки: " + currenPrice + " руб.");
    }

    protected int getExtraValue(Map<TypeProduct, Integer> values, DeliveryPackage pack) {
        int extraValue = 0;
        for (TypeProduct typeProduct : pack.getTypes()) {
            Integer val = values.get(typeProduct);
            if (val != null) extraValue += val;
        }
        return extraValue;
    }

    public int getDeliveryPrice() {
        return this.resultPrice;
    }

    public String getName() {
        return name;
    }

    public boolean canDeliver(ArrayList<Product> products) {
        for (Product product : products) {
            if(price.containsKey(product.getType())) {
                return true;
            }
        }
        return false;
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
