package ru.amfeller.lessonshop.delivery.company;

import ru.amfeller.lessonshop.delivery.DeliveryPackage;
import ru.amfeller.lessonshop.shop.product.TypeProduct;

public class PochtaRF extends DeliveryCompany {
    private boolean hasDelicateProduct = false;
    private boolean hasHeavyProduct = false;

    public PochtaRF() {
        super("Почта России", new TypeProduct[]{TypeProduct.DEFAULT, TypeProduct.DELICATE, TypeProduct.HEAVY}, 5, 500);
    }

    @Override
    public int calculateSpeed(DeliveryPackage pack) {
        int speed = this.speed;

        for (TypeProduct product : pack.getTypes()) {
            if (product == TypeProduct.HEAVY) {
                speed += 3;
                this.hasHeavyProduct = true;
            }
            if (product == TypeProduct.DELICATE) {
                speed += 2;
                this.hasDelicateProduct = true;
            }
        }

        speed += pack.getProducts().length;
        return speed;
    }

    @Override
    public int calculateCost(DeliveryPackage pack) {
        int price = this.price * pack.getProducts().length;
        if (hasDelicateProduct) {
            price += 1000;
        }
        if (hasHeavyProduct) {
            price += 2000;
        }
        return price;
    }
}
