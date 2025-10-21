package ru.amfeller.lessonshop.delivery.company;

import ru.amfeller.lessonshop.delivery.DeliveryPackage;
import ru.amfeller.lessonshop.shop.product.TypeProduct;

public class BOX extends DeliveryCompany {
    private boolean hasDelicateProduct = false;

    public BOX() {
        super("BOX", new TypeProduct[]{TypeProduct.DEFAULT,TypeProduct.DELICATE}, 1, 2000);
    }

    @Override
    public int calculateSpeed(DeliveryPackage pack) {
        int speed = this.speed;
        for (TypeProduct product : pack.getTypes()) {
            if (product == TypeProduct.DEFAULT) {
                speed += 1;
                this.hasDelicateProduct = true;
                break;
            }
        }
        speed += pack.getProducts().length;
        return speed;
    }

    @Override
    public int calculateCost(DeliveryPackage pack) {
        int price = this.price * pack.getProducts().length;
        if(hasDelicateProduct) {
            price += 3000;
        }
        return price;
    }
}
