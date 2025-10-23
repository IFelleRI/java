package ru.amfeller.lessonshop.shop;

import ru.amfeller.lessonshop.shop.product.Product;

import java.util.Scanner;

public class ShopUtils {
    private static final Scanner scanner = new Scanner(System.in);

    public static String pluralize(int count, String one, String two, String five) {
        count = Math.abs(count) % 100;
        int lastDigit = count % 10;
        if (count > 10 && count < 20) return five;
        if (lastDigit > 1 && lastDigit < 5) return two;
        if (lastDigit == 1) return one;
        return five;
    }

    public static int getChoice(int length, String title) {
        int choice;
        while (true) {
            try {
                System.out.print(title);
                choice = (ShopUtils.checkChoice(length) - 1);
                break;
            } catch (WrongChoiceException e) {
                System.out.println(e.getMessage());
            }
        }
        return choice;
    }

    public static int checkChoice(int length) {
        if (!scanner.hasNextInt()) {
            scanner.next();
            throw new WrongChoiceException();
        }
        int choice = scanner.nextInt();
        if (choice <= 0 || choice > length) {
            throw new WrongChoiceException();
        }
        return choice;
    }

    public static void showTitle(String title) {
        System.out.println();
        System.out.println(title);
        System.out.println("----------------------------------------------------------");
    }

    public static String printProducts(Product[] products) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-5s %-25s %10s%n", "№", "Товар", "Цена"));
        sb.append("----------------------------------------------------------\n");
        for (int i = 0; i < products.length; i++) {
            sb.append(String.format("%-5d %-25s %8d руб.%n",
                    i + 1,
                    products[i].getName(),
                    products[i].getPrice()));
        }
        sb.append("----------------------------------------------------------\n");
        return sb.toString();
    }

    public static <T> void printToConsole(T[] array, String title) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-5s %-15s%n", "№", title));
        sb.append("----------------------------------------------------------\n");
        for (int i = 0; i < array.length; i++) {
            sb.append(String.format("%-5d %-15s%n", i + 1, array[i]));
        }
        sb.append("----------------------------------------------------------\n");
        System.out.println(sb);
    }
}
