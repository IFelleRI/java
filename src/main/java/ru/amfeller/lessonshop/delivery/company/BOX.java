package ru.amfeller.lessonshop.delivery.company;

import ru.amfeller.lessonshop.delivery.DeliveryPackage;
import ru.amfeller.lessonshop.catalog.product.TypeProduct;

import java.util.Map;

public class BOX extends DeliveryCompany {

    public BOX() {
        super(
                "BOX",
                Map.of(
                        TypeProduct.DEFAULT,1,
                        TypeProduct.DELICATE,2
                ),
                Map.of(
                        TypeProduct.DEFAULT,2000,
                        TypeProduct.DELICATE,1000
                )
        );
    }

    @Override
    public int calculateSpeed(DeliveryPackage pack) {
        return speed.get(TypeProduct.DEFAULT) + pack.getProducts().size() + getExtraValue(speed, pack);
    }

    @Override
    public int calculateCost(DeliveryPackage pack) {
        this.resultPrice = (price.get(TypeProduct.DEFAULT) * pack.getProducts().size()) + getExtraValue(price, pack);
        return this.resultPrice;
    }

    @Override
    public void deliver() {
        System.out.println("Отправлено");
    }
}
