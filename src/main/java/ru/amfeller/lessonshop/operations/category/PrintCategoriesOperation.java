package ru.amfeller.lessonshop.operations.category;

import ru.amfeller.lessonshop.operations.Operation;
import ru.amfeller.lessonshop.shop.ShopSession;
import ru.amfeller.lessonshop.shop.ShopUtils;
import ru.amfeller.lessonshop.user.State;

public class PrintCategoriesOperation implements Operation {
    private final ShopSession shopSession;
    private final State state;

    public PrintCategoriesOperation(ShopSession shopSession, State userState) {
        this.shopSession = shopSession;
        this.state = userState;
    }

    @Override
    public void doOperation() {
        ShopUtils.printToConsole(shopSession.getCategories(),"Категория");
        this.shopSession.getUser().setUserState(this.state);
    }
}
