package ru.amfeller.lessonshop.delivery.company;

import ru.amfeller.lessonshop.delivery.DeliveryPackage;
import ru.amfeller.lessonshop.shop.product.TypeProduct;

public class BOX extends DeliveryCompany {

    public BOX() {
        super("BOX", new TypeProduct[]{TypeProduct.DEFAULT,TypeProduct.DELICATE}, 1, 2000);
    }

    @Override
    public int calculateSpeed(DeliveryPackage pack) {
        int extraSpeed = getExtraValue(new TypeProduct[]{TypeProduct.DELICATE}, new Integer[]{2}, pack);
        return this.speed + pack.getProducts().length + extraSpeed;
    }

    @Override
    public int calculateCost(DeliveryPackage pack) {
        int extraPrice = getExtraValue(new TypeProduct[]{TypeProduct.DELICATE}, new Integer[]{1000}, pack);
        return (this.price * pack.getProducts().length) + extraPrice;
    }

    @Override
    public void deliver() {
        System.out.println("Отправлено");
    }
}
