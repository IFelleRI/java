package ru.amfeller.lessonshop.delivery.company;

import ru.amfeller.lessonshop.delivery.DeliveryPackage;

public interface DeliveryService {
    void deliver(DeliveryPackage pack);

    int calculateSpeed(DeliveryPackage pack);

    int calculateCost(DeliveryPackage pack);
}
