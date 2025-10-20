package ru.amfeller.lessonshop.user;

public enum State {
    AUTHENTICATED("Авторизовался"),
    VIEWING_CATEGORIES("Зашел в категории"),
    VIEWING_PRODUCTS("Зашел в категорию: %s"),
    ADDING_TO_CART("Добавил %s в корзину"),
    VIEWING_CART("Зашел в корзину"),
    CHOICE_COMPANY("Выбрал компанию доставки %s"),
    CHOICE_DELIVERY_COMPANY("Зашел в компании доставки"),
    CHECKOUT("Оформил заказ"),
    EXIT("Выход");

    private final String name;

    State(String name) {
        this.name = name;
    }

    public String formatName(Object... args) {
        return String.format(name, args);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "\n" + name + "\n";
    }
}
