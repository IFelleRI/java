package ru.amfeller.lessonshop.delivery.company;

import ru.amfeller.lessonshop.delivery.DeliveryPackage;
import ru.amfeller.lessonshop.shop.product.TypeProduct;

public class CDEK extends DeliveryCompany {
    public CDEK() {
        super("CDEK", new TypeProduct[]{TypeProduct.DEFAULT, TypeProduct.HEAVY}, 2, 1000);
    }

    @Override
    public int calculateSpeed(DeliveryPackage pack) {
        int speed = this.speed;
        for (TypeProduct product : pack.getType()) {
            if (product == TypeProduct.HEAVY) {
                speed += 2;
                break;
            }
        }
        speed += pack.getProducts().length;
        return speed;
    }
}
