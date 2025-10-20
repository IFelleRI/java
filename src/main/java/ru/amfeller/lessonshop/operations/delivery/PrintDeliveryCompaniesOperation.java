package ru.amfeller.lessonshop.operations.delivery;

import ru.amfeller.lessonshop.delivery.company.DeliveryCompany;
import ru.amfeller.lessonshop.menu.MenuNavigator;
import ru.amfeller.lessonshop.operations.Operation;
import ru.amfeller.lessonshop.shop.ShopSession;
import ru.amfeller.lessonshop.shop.ShopUtils;
import ru.amfeller.lessonshop.user.State;


public class PrintDeliveryCompaniesOperation implements Operation {
    private final ShopSession shopSession;
    private final State state;

    public PrintDeliveryCompaniesOperation(ShopSession shopSession, State userState) {
        this.shopSession = shopSession;
        this.state = userState;
    }

    @Override
    public void doOperation() {
        if (shopSession.getCompany() != null) {
            MenuNavigator.stepBack = true;
            MenuNavigator.showTitle = false;
            return;
        }
        checkTypeDeliveryCompanies();
        System.out.println(ShopUtils.printCategories(shopSession.getCompanies()));
        this.shopSession.getUser().setUserState(this.state);
    }

    public void checkTypeDeliveryCompanies() {
        DeliveryCompany[] tmp = new DeliveryCompany[0];
        for (DeliveryCompany deliveryCompany : shopSession.getCompanies()) {
            if (deliveryCompany.canDeliver(shopSession.getCart().getProducts())) {
                DeliveryCompany[] newArray = new DeliveryCompany[tmp.length + 1];
                for (int i = 0; i < tmp.length; i++) {
                    newArray[i] = tmp[i];
                }
                newArray[newArray.length - 1] = deliveryCompany;
                tmp = newArray;
            }
        }
        shopSession.setCompanies(tmp);
    }
}
