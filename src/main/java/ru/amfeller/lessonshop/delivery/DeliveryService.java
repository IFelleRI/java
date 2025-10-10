package ru.amfeller.lessonshop.delivery;

import ru.amfeller.lessonshop.delivery.pack.Package;

public interface DeliveryService {
    void deliver(Package pack);

    int calculateSpeed(Package pack);

    int calculateCost(Package pack);
}
