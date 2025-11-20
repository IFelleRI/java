package ru.amfeller.lessonshop.services;

import ru.amfeller.lessonshop.catalog.Category;
import ru.amfeller.lessonshop.catalog.product.Product;
import ru.amfeller.lessonshop.store.ShopUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;

public class CatalogFileService {
    public void generateCatalogFile(List<Category> categories) {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(ShopUtils.getRootPath() + "shopstore/catalog.txt"))
        ) {
            for (Category category : categories) {
                writer.write("category=" + category.getName() + "\n");
                if (!category.getProducts().isEmpty()) {
                    writer.write("products=");
                }
                Iterator<Product> iterator = category.getProducts().iterator();
                while (iterator.hasNext()) {
                    writer.write(iterator.next().getPropertiesForFile());
                    if (iterator.hasNext()) {
                        writer.write(",");
                    }
                }
                writer.write("\n");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
