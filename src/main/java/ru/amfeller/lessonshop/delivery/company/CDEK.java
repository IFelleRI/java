package ru.amfeller.lessonshop.delivery.company;

import ru.amfeller.lessonshop.delivery.DeliveryPackage;
import ru.amfeller.lessonshop.shop.product.TypeProduct;

public class CDEK extends DeliveryCompany {
    public CDEK() {
        super("CDEK", new TypeProduct[]{TypeProduct.DEFAULT, TypeProduct.HEAVY}, 2, 1000);
    }

    @Override
    public int calculateSpeed(DeliveryPackage pack) {
        int extraSpeed = getExtraValue(new TypeProduct[]{TypeProduct.HEAVY}, new Integer[]{2}, pack);
        return this.speed + pack.getProducts().length + extraSpeed;
    }

    @Override
    public int calculateCost(DeliveryPackage pack) {
        int extraPrice = getExtraValue(new TypeProduct[]{TypeProduct.HEAVY}, new Integer[]{500}, pack);
        return (this.price * pack.getProducts().length) + extraPrice;
    }

    @Override
    public void deliver() {
        System.out.println("Отправлено");
    }
}
