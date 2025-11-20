package ru.amfeller.lessonshop.services;

import ru.amfeller.lessonshop.catalog.cart.Cart;
import ru.amfeller.lessonshop.store.ShopUtils;

import java.io.*;

public class CartFileService implements Serializable {

    public Cart getCart(String login) {
        File userCart = new File(ShopUtils.getRootPath() + "shopstore/cart-user_" + login + ".txt");
        if (!userCart.exists()) {
            try {
                if (userCart.createNewFile()) {
                    try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(userCart))) {
                        writer.writeObject(new Cart());
                    }
                }
            } catch (IOException e) {
                System.err.println("Error creating file: " + e.getMessage());
            }
        }

        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(userCart))) {
            return (Cart) reader.readObject();
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return null;
    }

    public void saveCart(Cart cart, String login) {
        File userCart = new File(ShopUtils.getRootPath() + "shopstore/cart-user_" + login + ".txt");
        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(userCart))) {
            writer.writeObject(cart);
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
}
