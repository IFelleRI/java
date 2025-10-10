package ru.amfeller.lessonshop.shop;

import ru.amfeller.lessonshop.delivery.*;
import ru.amfeller.lessonshop.delivery.pack.Package;
import ru.amfeller.lessonshop.delivery.company.BOX;
import ru.amfeller.lessonshop.delivery.company.CDEK;
import ru.amfeller.lessonshop.delivery.company.Company;
import ru.amfeller.lessonshop.menu.CartMenu;
import ru.amfeller.lessonshop.menu.CategoryMenu;
import ru.amfeller.lessonshop.menu.StaticMenu;
import ru.amfeller.lessonshop.shop.product.Product;
import ru.amfeller.lessonshop.shop.product.TypeProduct;
import ru.amfeller.lessonshop.user.Auth;
import ru.amfeller.lessonshop.user.State;
import ru.amfeller.lessonshop.user.User;

import java.util.Scanner;

public class Shop {
    private Category[] categories;
    private final Scanner scanner = new Scanner(System.in);
    private User user;
    private Cart cart;
    private Company[] companies;

    public void init() {
        if (this.categories == null) {
            initCategory();
            initCompanies();
        }
        login();
        showMenu();
    }

    private void login() {
        Auth auth = new Auth();
        this.user = auth.init(new User());
        userState(State.AUTHENTICATED);
        if (user.getCart() == null) {
            this.cart = new Cart();
            this.user.setCart(cart);
        } else {
            this.cart = user.getCart();
        }
    }

    private void showMenu() {
        int choice = ShopUtils.getChoice(StaticMenu.values(), "Главное меню");
        StaticMenu choiceItem = StaticMenu.values()[choice - 1];
        switch (choiceItem) {
            case CATEGORY:
                userState(State.VIEWING_CATEGORIES);
                showCategory();
                break;
            case CART:
                userState(State.VIEWING_CART);
                showCart();
                break;
            case LOGOUT:
                userState(State.EXIT);
                init();
                return;
            case HISTORY:
                System.out.println(this.user.getTrackAction());
                showMenu();
            case EXIT:
                return;
        }
    }

    private void showCart() {
        ShopUtils.showTitle("Корзина");
        if (this.cart.getProducts() == null || this.cart.getProducts().length == 0) {
            System.out.println("Корзина пустая");
            showMenu();
            return;
        }
        ShopUtils.printProducts(this.cart.getProducts());
        int choice = ShopUtils.getChoice(CartMenu.values(), "");
        CartMenu choiceItem = CartMenu.values()[choice - 1];
        if (choiceItem == CartMenu.BUY) {

            Package pack = getAPackage();
            ShopUtils.showTitle("Доставка");
            int choiceDelivery = ShopUtils.getChoice(this.companies, "Выбрать компанию:");
            Company currentCompany = this.companies[choiceDelivery];
            userState(State.CHOICE_COMPANY, currentCompany.getName());
            currentCompany.deliver(pack);

            this.cart.buy(currentCompany.getDeliveryPrice());
            userState(State.CHECKOUT);
            showMenu();
        }
        if (choiceItem == CartMenu.EXIT_MENU) {
            showMenu();
        }
    }

    private void showCategory() {
        ShopUtils.showTitle("Категории");
        int choiceCategory = ShopUtils.getChoice(categories, "Выбрать категорию:");
        Category category = categories[choiceCategory];
        userState(State.VIEWING_PRODUCTS, category.getName());
        ShopUtils.showTitle("Категория: " + category.getName());
        showProducts(category.getProducts());
    }

    private void showProducts(Product[] products) {
        ShopUtils.printProducts(products);
        int choiceProduct = ShopUtils.getChoice(CategoryMenu.values(), "");
        CategoryMenu choiceCategoryItem = CategoryMenu.values()[choiceProduct - 1];
        if (choiceCategoryItem == CategoryMenu.EXIT_SECTION) {
            showCategory();
        }
        if (choiceCategoryItem == CategoryMenu.EXIT_MENU) {
            showMenu();
            return;
        }
        if (choiceCategoryItem == CategoryMenu.BUY) {
            int productId = ShopUtils.getChoice(products.length, "Введите номер товара: ");
            this.cart.addProduct(products[productId]);
            System.out.println("\n--- Товар: " + products[productId] + " добавлен в корзину ---\n");
            userState(State.ADDING_TO_CART, products[productId].getName());
            showProducts(products);
        }
    }

    private void initCategory() {
        categories = new Category[]{
                new Category("Кровати", new Product[]{
                        new Product("Кровать", 1000),
                        new Product("Кровать 2", 2000),
                        new Product("Кровать 3", 3000)
                }),
                new Category("Посуда", new Product[]{
                        new Product("Набор тарелок", 1000, TypeProduct.DELICATE),
                        new Product("Набор стаканов", 2000, TypeProduct.DELICATE),
                        new Product("Набор ножей", 3000, TypeProduct.DELICATE)
                }),
                new Category("Диваны", new Product[]{
                        new Product("Диван", 1000),
                        new Product("Диван 2", 2000, TypeProduct.HEAVY),
                        new Product("Диван 3", 3000, TypeProduct.HEAVY),
                })
        };
    }

    private void initCompanies() {
        this.companies = new Company[]{new CDEK(), new BOX()};
    }

    private Package getAPackage() {
        TypeProduct typeProduct = this.cart.getType();
        Address address = AddressForm.createAddress();
        return switch (typeProduct) {
            case DELICATE -> new Package(
                    this.user,
                    this.cart.getProducts(),
                    address
            );
            case DEFAULT -> new Package(
                    this.user,
                    this.cart.getProducts(),
                    address
            );
            case HEAVY -> new Package(
                    this.user,
                    this.cart.getProducts(),
                    address
            );
        };
    }

    private void userState(State state) {
        this.user.setTrackAction(state.getName());
    }

    private void userState(State state, String title) {
        this.user.setTrackAction(state.formatName(title));
    }
}
