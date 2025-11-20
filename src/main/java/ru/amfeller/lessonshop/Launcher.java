package ru.amfeller.lessonshop;

import ru.amfeller.lessonshop.delivery.company.BOX;
import ru.amfeller.lessonshop.delivery.company.CDEK;
import ru.amfeller.lessonshop.delivery.company.DeliveryCompany;
import ru.amfeller.lessonshop.delivery.company.PochtaRF;
import ru.amfeller.lessonshop.catalog.Category;
import ru.amfeller.lessonshop.services.CatalogFileService;
import ru.amfeller.lessonshop.store.Shop;
import ru.amfeller.lessonshop.store.ShopUtils;
import ru.amfeller.lessonshop.catalog.product.Product;
import ru.amfeller.lessonshop.catalog.product.TypeProduct;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Launcher {
    private final CatalogFileService service = new CatalogFileService();

    public void initialization() {
        Shop shop = new Shop(initCategory(), initCompanies());
        shop.init();
    }

    private List<Category> initCategory() {
        File file = new File(ShopUtils.getRootPath() + "shopstore/catalog.txt");
        if (file.exists()) {
            return getFileCategories();
        }
        return getDefaultCategories();
    }

    private List<Category> getFileCategories() {
        try (BufferedReader list = new BufferedReader(
                new FileReader(ShopUtils.getRootPath() + "shopstore/catalog.txt"))
        ) {
            List<Category> categories = new ArrayList<>();
            Category currentCategory = null;
            String line;
            while ((line = list.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                if (line.startsWith("category=")) {
                    currentCategory = new Category(line.split("=")[1]);
                    categories.add(currentCategory);
                }
                if (line.startsWith("products=")) {
                    Product currentProduct;
                    String productLine = line.split("products=")[1];
                    String[] products = productLine.replaceAll("[\\[\\]]", "").split(",");
                    for (String product : products) {
                        currentProduct = new Product();
                        String[] props = product.split("#");
                        for (String prop : props) {
                            String propName = prop.split("=")[0];
                            String propValue = prop.split("=")[1];
                            switch (propName) {
                                case "name":
                                    currentProduct.setName(propValue);
                                    break;
                                case "price":
                                    currentProduct.setPrice(Integer.parseInt(propValue));
                                    break;
                                case "type":
                                    currentProduct.setType(TypeProduct.valueOf(propValue));
                                    break;
                                case "rating":
                                    currentProduct.setRating(Integer.parseInt(propValue));
                                    break;
                            }
                        }
                        currentCategory.addProduct(currentProduct);
                    }
                }
            }
            return categories;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private List<Category> getDefaultCategories() {
        service.generateCatalogFile(staticCategories());
        return staticCategories();
    }

    private List<Category> staticCategories() {
        return new ArrayList<>(List.of(
                new Category("Кровати", new ArrayList<>(List.of(
                        new Product("Кровать", 1000),
                        new Product("Кровать 2", 2000),
                        new Product("Кровать 3", 3000)
                ))),
                new Category("Посуда", new ArrayList<>(List.of(
                        new Product("Набор тарелок", 1000, TypeProduct.DELICATE),
                        new Product("Набор стаканов", 2000, TypeProduct.DELICATE),
                        new Product("Набор ножей", 3000, TypeProduct.DELICATE)
                ))),
                new Category("Диваны", new ArrayList<>(List.of(
                        new Product("Диван", 1000, TypeProduct.HEAVY),
                        new Product("Диван 2", 2000, TypeProduct.HEAVY),
                        new Product("Диван 3", 3000, TypeProduct.HEAVY)
                )))
        ));
    }

    private List<DeliveryCompany> initCompanies() {
        DeliveryCompany[] arrDeliveryCompany = new DeliveryCompany[]{new CDEK(), new BOX(), new PochtaRF()};
        return new ArrayList<>(List.of(arrDeliveryCompany));
    }
}
