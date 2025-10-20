package ru.amfeller.lessonshop.operations.delivery;

import ru.amfeller.lessonshop.delivery.company.DeliveryCompany;
import ru.amfeller.lessonshop.operations.Operation;
import ru.amfeller.lessonshop.shop.ShopSession;
import ru.amfeller.lessonshop.shop.ShopUtils;

public class ChoiceDeliveryCompanyOperation implements Operation {
    private ShopSession shopSession;

    public ChoiceDeliveryCompanyOperation(ShopSession shopSession) {
        this.shopSession = shopSession;
    }

    @Override
    public void doOperation() {
        DeliveryCompany[] companies = shopSession.getCompanies();
        System.out.println(ShopUtils.printCategories(companies));
        System.out.print("Введите № компании: ");
        int option = ShopUtils.getChoice(companies.length, "");
        DeliveryCompany currentDeliveryCompany = companies[option];
        shopSession.setTmpCompany(currentDeliveryCompany);
    }
}
