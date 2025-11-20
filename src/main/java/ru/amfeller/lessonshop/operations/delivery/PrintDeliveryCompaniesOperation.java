package ru.amfeller.lessonshop.operations.delivery;

import ru.amfeller.lessonshop.delivery.company.DeliveryCompany;
import ru.amfeller.lessonshop.menu.MenuNavigator;
import ru.amfeller.lessonshop.operations.Operation;
import ru.amfeller.lessonshop.store.ShopSession;
import ru.amfeller.lessonshop.store.ShopUtils;
import ru.amfeller.lessonshop.user.State;

import java.util.ArrayList;


public class PrintDeliveryCompaniesOperation implements Operation {
    private final ShopSession shopSession;
    private final State state;

    public PrintDeliveryCompaniesOperation(ShopSession shopSession, State userState) {
        this.shopSession = shopSession;
        this.state = userState;
    }

    @Override
    public void doOperation() {
        if (shopSession.getDeliveryCompany() != null) {
            MenuNavigator.stepBack = true;
            MenuNavigator.showTitle = false;
            return;
        }
        checkTypeDeliveryCompanies();
        ShopUtils.printToConsole(shopSession.getCompanies(), "Компания");
        System.out.print("Введите № компании: ");
        int option = ShopUtils.getChoice(shopSession.getCompanies().size(), "");
        DeliveryCompany currentDeliveryCompany = shopSession.getCompanies().get(option);
        shopSession.setTmpCompany(currentDeliveryCompany);
        this.shopSession.getUser().setUserState(this.state);
    }

    public void checkTypeDeliveryCompanies() {
        ArrayList<DeliveryCompany> tmp = new ArrayList<>();
        for (DeliveryCompany deliveryCompany : shopSession.getCompanies()) {
            if (deliveryCompany.canDeliver(shopSession.getCart().getProducts())) {
                tmp.add(deliveryCompany);
            }
        }
        shopSession.setCompanies(tmp);
    }
}
