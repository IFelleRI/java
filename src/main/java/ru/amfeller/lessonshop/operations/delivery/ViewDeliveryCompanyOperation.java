package ru.amfeller.lessonshop.operations.delivery;

import ru.amfeller.lessonshop.delivery.Address;
import ru.amfeller.lessonshop.delivery.AddressForm;
import ru.amfeller.lessonshop.delivery.DeliveryPackage;
import ru.amfeller.lessonshop.menu.MenuNavigator;
import ru.amfeller.lessonshop.operations.Operation;
import ru.amfeller.lessonshop.shop.ShopSession;
import ru.amfeller.lessonshop.user.State;

public class ViewDeliveryCompanyOperation implements Operation {
    private final ShopSession shopSession;
    private Address address;
    private final State state;

    public ViewDeliveryCompanyOperation(ShopSession shopSession,State state) {
        this.shopSession = shopSession;
        this.state = state;
    }

    @Override
    public void doOperation() {
        if (shopSession.getCompany() != null) {
            MenuNavigator.stepBack = true;
            MenuNavigator.showTitle = true;
            return;
        }
        this.address = AddressForm.createAddress();
        showInfo();
    }

    public void showInfo() {
        System.out.println("---------------------------------------");
        this.shopSession.getTmpCompany().info(createDeliveryPackage());
        System.out.println("---------------------------------------");
    }

    private DeliveryPackage createDeliveryPackage() {
        return new DeliveryPackage(
                this.shopSession.getUser(),
                this.shopSession.getProducts(),
                address
        );
    }
}
