package ru.amfeller.lessonshop.delivery;

import java.util.Scanner;

public class AddressForm {
    private static final Scanner scanner = new Scanner(System.in);

    public static Address createAddress() {
        System.out.println("Введите адрес доставки:");

        System.out.print("Страна: ");
        String country = checkEmpty();

        System.out.print("Город: ");
        String city = checkEmpty();

        System.out.print("Улица: ");
        String street = checkEmpty();

        System.out.print("Дом: ");
        String house = checkEmpty();

        return new Address(country, city, street, house);
    }

    private static String checkEmpty() {
        String input;
        while (true) {
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Заполните поле!");
                continue;
            }
            return input;
        }
    }
}
