package ru.amfeller.lessonshop.delivery;

import ru.amfeller.lessonshop.shop.product.Product;
import ru.amfeller.lessonshop.shop.product.TypeProduct;
import ru.amfeller.lessonshop.user.User;

public class DeliveryPackage {
    protected User user;
    protected Product[] products;
    protected Address address;

    public DeliveryPackage(User user, Product[] products, Address address) {
        this.user = user;
        this.products = products;
        this.address = address;
    }

    public Product[] getProducts() {
        return products;
    }

    public Address getAddress() {
        return address;
    }

    public TypeProduct[] getTypes() {
        TypeProduct[] foundTypes = new TypeProduct[0];
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
                TypeProduct[] newArray = new TypeProduct[foundTypes.length + 1];
                for (int i = 0; i < foundTypes.length; i++) {
                    newArray[i] = foundTypes[i];
                }
                newArray[newArray.length - 1] = currentType;
                foundTypes = newArray;
            }
        }
        return foundTypes;
    }
}
