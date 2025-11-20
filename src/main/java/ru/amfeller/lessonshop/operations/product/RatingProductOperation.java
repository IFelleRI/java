package ru.amfeller.lessonshop.operations.product;

import ru.amfeller.lessonshop.catalog.product.Product;
import ru.amfeller.lessonshop.operations.Operation;
import ru.amfeller.lessonshop.services.CatalogFileService;
import ru.amfeller.lessonshop.store.ShopSession;
import ru.amfeller.lessonshop.store.ShopUtils;

import java.util.List;
import java.util.Scanner;

public class RatingProductOperation implements Operation {
    private final ShopSession shopSession;
    private final Scanner scanner = new Scanner(System.in);
    private final CatalogFileService service = new CatalogFileService();

    public RatingProductOperation(ShopSession shopSession) {
        this.shopSession = shopSession;
    }

    @Override
    public void doOperation() {
        List<Product> products = shopSession.getCategoryProducts();
        System.out.print("Введите № товара: ");
        int option = ShopUtils.getChoice(products.size(), "");
        Product product = products.get(option);
        System.out.print("Введите рейтинг 1-5: ");
        int rating = scanner.nextInt();
        product.setRating(rating);
        service.generateCatalogFile(shopSession.getCategories());
    }
}
