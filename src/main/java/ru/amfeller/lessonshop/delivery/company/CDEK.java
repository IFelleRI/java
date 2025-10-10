package ru.amfeller.lessonshop.delivery.company;

import ru.amfeller.lessonshop.delivery.pack.Package;
import ru.amfeller.lessonshop.shop.product.TypeProduct;

public class CDEK extends Company {
    public CDEK() {
        super("CDEK", new TypeProduct[]{TypeProduct.DEFAULT, TypeProduct.HEAVY}, 2, 1000);
    }

    @Override
    public int calculateSpeed(Package pack) {
        int speed = this.speed;
        if (pack.getType() == TypeProduct.DELICATE) {
            speed += 1;
        }
        if (pack.getType() == TypeProduct.HEAVY) {
            speed += 2;
        }
        speed += pack.getProducts().length;
        return speed;
    }
}
