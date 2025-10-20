package ru.amfeller.lessonshop.operations.category;

import ru.amfeller.lessonshop.operations.Operation;
import ru.amfeller.lessonshop.shop.Category;
import ru.amfeller.lessonshop.shop.ShopSession;
import ru.amfeller.lessonshop.shop.ShopUtils;
import ru.amfeller.lessonshop.user.State;

public class ViewCategoryProductsOperation implements Operation {

    private final ShopSession shopSession;
    private final State state;

    public ViewCategoryProductsOperation(ShopSession shopSession, State state) {
        this.shopSession = shopSession;
        this.state = state;
    }

    @Override
    public void doOperation() {
        Category currentCategory = this.shopSession.getCategory();
        System.out.println(ShopUtils.printProducts(currentCategory.getProducts()));
        this.shopSession.getUser().setUserState(this.state);
    }
}
