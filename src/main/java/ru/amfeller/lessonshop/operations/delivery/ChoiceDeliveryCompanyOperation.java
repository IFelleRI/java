package ru.amfeller.lessonshop.operations.delivery;

import ru.amfeller.lessonshop.delivery.company.DeliveryCompany;
import ru.amfeller.lessonshop.operations.Operation;
import ru.amfeller.lessonshop.shop.ShopSession;
import ru.amfeller.lessonshop.shop.ShopUtils;

import java.util.ArrayList;

public class ChoiceDeliveryCompanyOperation implements Operation {
    private final ShopSession shopSession;

    public ChoiceDeliveryCompanyOperation(ShopSession shopSession) {
        this.shopSession = shopSession;
    }

    @Override
    public void doOperation() {
        ArrayList<DeliveryCompany> companies = shopSession.getCompanies();
        ShopUtils.printToConsole(companies,"Компания");
        System.out.print("Введите № компании: ");
        int option = ShopUtils.getChoice(companies.size(), "");
        DeliveryCompany currentDeliveryCompany = companies.get(option);
        shopSession.setTmpCompany(currentDeliveryCompany);
    }
}
