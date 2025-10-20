package ru.amfeller.lessonshop.shop;

import ru.amfeller.lessonshop.delivery.company.DeliveryCompany;
import ru.amfeller.lessonshop.shop.product.Product;
import ru.amfeller.lessonshop.user.State;

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

    public static int getChoice(Object[] menuItems, String title) {
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

    public static String printCategories(Category[] categories) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-5s %-15s%n", "№", "Категория"));
        sb.append("----------------------------------------------------------\n");
        for (int i = 0; i < categories.length; i++) {
            sb.append(String.format("%-5d %-15s%n", i + 1, categories[i]));
        }
        sb.append("----------------------------------------------------------\n");
        return sb.toString();
    }

    public static String printCategories(DeliveryCompany[] companies) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-5s %-15s%n", "№", "Компания"));
        sb.append("----------------------------------------------------------\n");
        for (int i = 0; i < companies.length; i++) {
            sb.append(String.format("%-5d %-15s%n", i + 1, companies[i]));
        }
        sb.append("----------------------------------------------------------\n");
        return sb.toString();
    }
}
