package ru.amfeller.lessonshop.menu;

import ru.amfeller.lessonshop.operations.cart.PurchaseCartOperation;
import ru.amfeller.lessonshop.operations.cart.ShowCartOperation;
import ru.amfeller.lessonshop.operations.category.ChoiceCategoryOperation;
import ru.amfeller.lessonshop.operations.category.PrintCategoriesOperation;
import ru.amfeller.lessonshop.operations.category.ViewCategoryProductsOperation;
import ru.amfeller.lessonshop.operations.common.BackOperation;
import ru.amfeller.lessonshop.operations.common.BackToMainMenuOperation;
import ru.amfeller.lessonshop.operations.common.ExitOperation;
import ru.amfeller.lessonshop.operations.delivery.ChoiceDeliveryCompanyOperation;
import ru.amfeller.lessonshop.operations.delivery.ConfirmDeliverySelectionOperation;
import ru.amfeller.lessonshop.operations.delivery.PrintDeliveryCompaniesOperation;
import ru.amfeller.lessonshop.operations.delivery.ViewDeliveryCompanyOperation;
import ru.amfeller.lessonshop.operations.product.BuyProductOperation;
import ru.amfeller.lessonshop.operations.product.DeleteProductOperation;
import ru.amfeller.lessonshop.operations.user.LogoutOperation;
import ru.amfeller.lessonshop.shop.Shop;
import ru.amfeller.lessonshop.shop.ShopSession;
import ru.amfeller.lessonshop.user.State;

public class MenuGenerator {
    private final ShopSession shopSession;
    private final Shop shop;

    public MenuGenerator(ShopSession shopSession, Shop shop) {
        this.shopSession = shopSession;
        this.shop = shop;
    }

    public void init() {



        MenuComponent back = new MenuItem("Назад", new BackOperation());
        MenuComponent backToHome = new MenuItem("В главное меню", new BackToMainMenuOperation());

        MenuComponent buyProduct = new MenuItem("Купить продукт", new BuyProductOperation(shopSession,State.VIEWING_PRODUCTS));
        MenuComponent categoryView = new Menu("Категория: такая то", new ViewCategoryProductsOperation(shopSession,State.VIEWING_PRODUCTS));
        MenuComponent categoryChoice = new Menu("Выбрать категорию", new ChoiceCategoryOperation(shopSession,State.VIEWING_CATEGORIES), true);

        MenuComponent purchaseCart = new MenuItem("Оформить заказ", new PurchaseCartOperation(shopSession,State.CHECKOUT));
        MenuComponent confirmChoice = new MenuItem("Подтвердить выбор", new ConfirmDeliverySelectionOperation(shopSession));
        MenuComponent viewDeliveryCompanyInfo = new Menu("Информация о комании: ", new ViewDeliveryCompanyOperation(shopSession,State.VIEWING_PRODUCTS));
        MenuComponent choiceDeliveryCompanies = new Menu("Выбрать компанию", new ChoiceDeliveryCompanyOperation(shopSession), true);
        MenuComponent deliveryCompanies = new Menu("Компании доставки", new PrintDeliveryCompaniesOperation(shopSession,State.CHOICE_DELIVERY_COMPANY));


        MenuComponent deleteProduct = new Menu("Удалить товар из корзины", new DeleteProductOperation(shopSession),true);


        MenuComponent exitShop = new MenuItem("Выход", new ExitOperation());
        MenuComponent logOut = new MenuItem("Выйти из профиля", new LogoutOperation(shop));
        MenuComponent categoryList = new Menu("Категории", new PrintCategoriesOperation(shopSession,State.VIEWING_CATEGORIES));
        MenuComponent cartMenu = new Menu("Корзина", new ShowCartOperation(shopSession,State.VIEWING_CATEGORIES));
        MenuComponent mainMenu = new Menu("Главное меню");


        addSubItems(
                viewDeliveryCompanyInfo,
                new MenuComponent[]{
                        confirmChoice,
                        back
                }
        );
        addSubItems(
                choiceDeliveryCompanies,
                new MenuComponent[]{
                        viewDeliveryCompanyInfo
                }
        );
        addSubItems(
                deliveryCompanies,
                new MenuComponent[]{
                        choiceDeliveryCompanies,
                        back,
                        backToHome
                }
        );
        addSubItems(
                cartMenu,
                new MenuComponent[]{
                        deliveryCompanies,
                        purchaseCart,
                        deleteProduct,
                        back,
                        backToHome
                }
        );
        addSubItems(
                categoryView,
                new MenuComponent[]{
                        buyProduct,
                        back,
                        backToHome
                }
        );
        addSubItems(
                categoryChoice,
                new MenuComponent[]{
                        categoryView
                }
        );
        addSubItems(
                categoryList,
                new MenuComponent[]{
                        categoryChoice,
                        back,
                        backToHome
                }
        );
        addSubItems(
                mainMenu,
                new MenuComponent[]{
                        categoryList,
                        cartMenu,
                        logOut,
                        exitShop
                }
        );
        mainMenu.doAction();
    }

    private void addSubItems(MenuComponent menu, MenuComponent[] menuComponents) {
        Menu thisMenu = (Menu) menu;
        for (MenuComponent menuComponent : menuComponents) {
            thisMenu.add(menuComponent);
        }
    }
}
