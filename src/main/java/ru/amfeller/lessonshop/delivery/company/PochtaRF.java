package ru.amfeller.lessonshop.delivery.company;

import ru.amfeller.lessonshop.delivery.DeliveryPackage;
import ru.amfeller.lessonshop.shop.product.TypeProduct;

public class PochtaRF extends DeliveryCompany {
    public PochtaRF() {
        super("Почта России", new TypeProduct[]{TypeProduct.DEFAULT, TypeProduct.DELICATE, TypeProduct.HEAVY}, 5, 500);
    }

    @Override
    public int calculateSpeed(DeliveryPackage pack) {
        int extraSpeed = getExtraValue(new TypeProduct[]{TypeProduct.DELICATE, TypeProduct.HEAVY}, new Integer[]{3, 2}, pack);
        return this.speed + pack.getProducts().length + extraSpeed;
    }

    @Override
    public int calculateCost(DeliveryPackage pack) {
        int extraPrice = getExtraValue(new TypeProduct[]{TypeProduct.DELICATE, TypeProduct.HEAVY}, new Integer[]{1000, 2000}, pack);
        return (this.price * pack.getProducts().length) + extraPrice;
    }

    @Override
    public void deliver() {
        System.out.println("Отправлено");
    }
}
