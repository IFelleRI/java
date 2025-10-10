package ru.amfeller.lessonshop.menu;

public enum CartMenu {
    BUY("Оформить заказ"),
    EXIT_MENU("Выйти в главное меню");
    private final String name;

    CartMenu(String name) {
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
