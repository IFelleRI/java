package ru.amfeller.lessonshop.operations.category;

import ru.amfeller.lessonshop.operations.Operation;
import ru.amfeller.lessonshop.store.ShopSession;
import ru.amfeller.lessonshop.store.ShopUtils;
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
        System.out.print("Введите № категории: ");
        int option = ShopUtils.getChoice(shopSession.getCategories().size(), "");
        this.shopSession.setCategory(shopSession.getCategories().get(option));
        this.shopSession.getUser().setUserState(this.state);
    }
}
