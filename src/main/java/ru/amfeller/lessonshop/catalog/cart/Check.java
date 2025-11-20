package ru.amfeller.lessonshop.catalog.cart;

import ru.amfeller.lessonshop.catalog.product.Product;
import ru.amfeller.lessonshop.services.CheckFileService;

import java.util.List;

public class Check {
    private final CheckFileService service = new CheckFileService();
    private int sum;
    private int deliveryPrice;
    private List<Product> products;
    private String login;

    public Check(int sum, int deliveryPrice, List<Product> products,String login) {
        this.sum = sum;
        this.login = login;
        this.deliveryPrice = deliveryPrice;
        this.products = products;
    }

    protected void showCheck(){
        System.out.println();
        System.out.format("%-15s %10s%n", "Товар", "Цена");
        System.out.println("----------------------------------------");
        for (Product product : products) {
            System.out.format("%-15s %10s%n",
                    product.getName(),
                    product.getPrice() + " руб.");
        }
        System.out.format("%-15s %10s%n",
                "Доставка",
                deliveryPrice + " руб.");
        System.out.println("----------------------------------------");
        System.out.format("%-15s %10s%n", "Итого:", sum + deliveryPrice + " руб.");
    }

    private String create(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append(String.format("%-15s %10s%n", "Товар", "Цена"));
        sb.append("----------------------------------------\n");
        for (Product product : products) {
            sb.append(String.format(
                    "%-15s %10s%n",
                    product.getName(),
                    product.getPrice() + " руб."
            ));
        }
        sb.append(String.format("%-15s %10s%n", "Доставка", deliveryPrice + " руб."));
        sb.append("----------------------------------------\n");
        sb.append(String.format("%-15s %10s%n", "Итого:", sum + deliveryPrice + " руб."));
        return sb.toString();
    }

    protected void save(){
        service.saveCheck(create(), login);
    }
}
