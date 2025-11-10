package ru.amfeller.lessonshop.operations.category;

import ru.amfeller.lessonshop.operations.Operation;
import ru.amfeller.lessonshop.shop.Category;
import ru.amfeller.lessonshop.shop.ShopSession;
import ru.amfeller.lessonshop.shop.ShopUtils;
import ru.amfeller.lessonshop.user.State;

import java.util.ArrayList;

public class ChoiceCategoryOperation implements Operation {
    private final ShopSession shopSession;
    private final State state;

    public ChoiceCategoryOperation(ShopSession shopSession,State state) {
        this.shopSession = shopSession;
        this.state = state;
    }

    @Override
    public void doOperation() {
        ArrayList<Category> categories = shopSession.getCategories();
        System.out.print("Введите № категории: ");
        int option = ShopUtils.getChoice(categories.size(), "");
        this.shopSession.setCategory(categories.get(option));
        this.shopSession.getUser().setUserState(this.state);
    }
}
