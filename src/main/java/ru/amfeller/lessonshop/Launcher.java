package ru.amfeller.lessonshop;

import ru.amfeller.lessonshop.delivery.company.BOX;
import ru.amfeller.lessonshop.delivery.company.CDEK;
import ru.amfeller.lessonshop.delivery.company.DeliveryCompany;
import ru.amfeller.lessonshop.delivery.company.PochtaRF;
import ru.amfeller.lessonshop.menu.Menu;
import ru.amfeller.lessonshop.shop.Category;
import ru.amfeller.lessonshop.shop.Shop;
import ru.amfeller.lessonshop.shop.product.Product;
import ru.amfeller.lessonshop.shop.product.TypeProduct;

public class Launcher {
    private Category[] categories;
    private DeliveryCompany[] companies;
    private Menu menu;

    public Launcher() {
        initCategory();
        initCompanies();
        Shop shop = new Shop(categories, companies);
        shop.init();
    }

    private void initCategory() {
        categories = new Category[]{
                new Category("Кровати", new Product[]{
                        new Product("Кровать", 1000),
                        new Product("Кровать 2", 2000),
                        new Product("Кровать 3", 3000)
                }),
                new Category("Посуда", new Product[]{
                        new Product("Набор тарелок", 1000, TypeProduct.DELICATE),
                        new Product("Набор стаканов", 2000, TypeProduct.DELICATE),
                        new Product("Набор ножей", 3000, TypeProduct.DELICATE)
                }),
                new Category("Диваны", new Product[]{
                        new Product("Диван", 1000),
                        new Product("Диван 2", 2000, TypeProduct.HEAVY),
                        new Product("Диван 3", 3000, TypeProduct.HEAVY),
                })
        };
    }

    private void initCompanies() {
        this.companies = new DeliveryCompany[]{new CDEK(), new BOX(),new PochtaRF()};
    }
}
