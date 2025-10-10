package ru.amfeller.lessonshop.menu;

public enum CategoryMenu {
    BUY("Купить товар"),
    EXIT_SECTION("Выйти из раздела"),
    EXIT_MENU("Выйти в главное меню");
    private final String name;

    CategoryMenu(String name) {
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
