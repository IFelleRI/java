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

    public static void print(Enum[] menuItems) {
        System.out.println("Список операций: ");
        for (Enum menuItem : menuItems) {
            System.out.println((menuItem.ordinal() + 1) + ". " + menuItem);
        }
        System.out.print("Выбрать операцию: ");
    }

    protected static int getChoice(Enum[] menuItems, String title) {
        int choice;
        while (true) {
            try {
                if (!title.isEmpty()) {
                    ShopUtils.showTitle(title);
                }
                ShopUtils.print(menuItems);
                choice = ShopUtils.checkChoice(menuItems.length);
                break;
            } catch (WrongChoiceException e) {
                System.out.println(e.getMessage());
            }
        }
        return choice;
    }

    protected static int getChoice(Object[] menuItems, String title) {
        int choice;
        while (true) {
            try {
                for (int i = 0; i < menuItems.length; i++) {
                    System.out.println((i + 1) + ". " + menuItems[i]);
                }
                System.out.print(title);
                choice = (ShopUtils.checkChoice(menuItems.length) - 1);
                break;
            } catch (WrongChoiceException e) {
                System.out.println(e.getMessage());
            }
        }
        return choice;
    }

    protected static int getChoice(int length, String title) {
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

    protected static int checkChoice(int length) {
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

    protected static void showTitle(String title) {
        System.out.println();
        System.out.println(title);
        System.out.println("----------------------------------------");
    }

    protected static void printProducts(Product[] products) {
        System.out.format("%-5s %-10s %-6s%n", "№", "Товар", "Цена");
        System.out.println("----------------------------------------");
        for (int i = 0; i < products.length; i++) {
            System.out.format("%-5d %-10s %2d руб.%n",
                    i + 1,
                    products[i],
                    products[i].getPrice());
        }
        System.out.println("----------------------------------------");
    }

}
