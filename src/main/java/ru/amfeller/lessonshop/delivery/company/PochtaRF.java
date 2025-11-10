package ru.amfeller.lessonshop.delivery.company;

import ru.amfeller.lessonshop.delivery.DeliveryPackage;
import ru.amfeller.lessonshop.shop.product.TypeProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PochtaRF extends DeliveryCompany {
    public PochtaRF() {
        super(
                "Почта России",
                Map.of(
                        TypeProduct.DEFAULT,1,
                        TypeProduct.DELICATE,2,
                        TypeProduct.HEAVY,1
                ),
                Map.of(
                        TypeProduct.DEFAULT,500,
                        TypeProduct.DELICATE,2000,
                        TypeProduct.HEAVY,1000
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
