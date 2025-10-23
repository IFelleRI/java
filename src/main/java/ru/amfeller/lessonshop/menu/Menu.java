package ru.amfeller.lessonshop.menu;

import ru.amfeller.lessonshop.operations.Operation;
import ru.amfeller.lessonshop.operations.common.BackOperation;
import ru.amfeller.lessonshop.operations.common.BackToMainMenuOperation;
import ru.amfeller.lessonshop.shop.ShopUtils;

public class Menu implements MenuComponent {
    private MenuComponent[] items;
    private final String title;
    private final Operation operation;
    private final boolean skipToBack;

    public Menu(String title) {
        this(title, null, false);
    }

    public Menu(String title, Operation operation) {
        this(title, operation, false);
    }

    public Menu(String title, Operation operation, boolean skipToBack) {
        this.title = title;
        this.operation = operation;
        this.skipToBack = skipToBack;
    }

    public void add(MenuComponent item) {
        if (items == null) {
            items = new MenuComponent[]{item};
            return;
        }
        MenuComponent[] tmpArr = new MenuComponent[items.length + 1];
        System.arraycopy(items, 0, tmpArr, 0, items.length);
        tmpArr[tmpArr.length - 1] = item;
        this.items = tmpArr;
    }

    @Override
    public String getName() {
        return title;
    }

    @Override
    public void doAction() {
        while (true) {
            if (MenuNavigator.homeBack && operation != null) {
                break;
            } else {
                MenuNavigator.homeBack = false;
            }
            if (this.skipToBack) {
                if (MenuNavigator.stepBack) break;
                operation.doOperation();
                if (this.items == null) break;
                items[0].doAction();
            } else {
                MenuNavigator.stepBack = false;
                if (MenuNavigator.showTitle) {
                    ShopUtils.showTitle(title);
                }
                if (operation != null) {
                    operation.doOperation();
                    if (MenuNavigator.stepBack) break;
                }
                MenuNavigator.showTitle = true;
                for (int i = 0; i < items.length; i++) {
                    System.out.println((i + 1) + ". " + items[i].getName());
                }
                System.out.print("Выбрать операцию: ");
                int option = ShopUtils.getChoice(items.length, "");
                items[option].doAction();

                if (items[option] instanceof MenuItem menuItem) {
                    if (menuItem.getOperation() instanceof BackOperation) {
                        MenuNavigator.stepBack = true;
                        break;
                    }
                    if (menuItem.getOperation() instanceof BackToMainMenuOperation && !MenuNavigator.homeBack) {
                        MenuNavigator.homeBack = true;
                        break;
                    }
                }
            }
        }
    }
}
