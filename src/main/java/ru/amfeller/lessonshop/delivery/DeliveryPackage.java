package ru.amfeller.lessonshop.delivery;

import ru.amfeller.lessonshop.catalog.product.Product;
import ru.amfeller.lessonshop.catalog.product.TypeProduct;
import ru.amfeller.lessonshop.user.User;

import java.util.ArrayList;
import java.util.List;

public class DeliveryPackage {
    protected User user;
    protected List<Product> products;
    protected Address address;

    public DeliveryPackage(User user, List<Product> products, Address address) {
        this.user = user;
        this.products = products;
        this.address = address;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Address getAddress() {
        return address;
    }

    public ArrayList<TypeProduct> getTypes() {
        ArrayList<TypeProduct> foundTypes = new ArrayList<>();
        for (Product product : products) {
            TypeProduct currentType = product.getType();
            boolean exists = false;
            for (TypeProduct type : foundTypes) {
                if (type == currentType) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                foundTypes.add(currentType);
            }
        }
        return foundTypes;
    }
}
