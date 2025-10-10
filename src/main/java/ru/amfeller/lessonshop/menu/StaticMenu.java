package ru.amfeller.lessonshop.menu;

public enum StaticMenu {
    CATEGORY("Показать категории"),
    CART("Корзина"),
    LOGOUT("Выйти из профиля"),
    HISTORY("Показать историю пользвателя"),
    EXIT("Выход");
    private final String name;

    StaticMenu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
