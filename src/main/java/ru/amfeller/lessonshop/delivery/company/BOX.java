package ru.amfeller.lessonshop.delivery.company;

import ru.amfeller.lessonshop.delivery.pack.Package;
import ru.amfeller.lessonshop.shop.product.TypeProduct;

public class BOX extends Company {

    public BOX() {
        super("BOX", new TypeProduct[]{TypeProduct.DEFAULT,TypeProduct.DELICATE}, 1, 2000);
    }

    @Override
    public int calculateSpeed(Package pack) {
        int speed = this.speed;

        if(pack.getType() == TypeProduct.DELICATE) {
            speed += 1;
        }

        speed += pack.getProducts().length;
        return speed;
    }
}
