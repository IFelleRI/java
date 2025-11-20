package ru.amfeller.lessonshop.user;

import ru.amfeller.lessonshop.store.ShopUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Base64;

public class DataBase {
    private static final String dbPath = ShopUtils.getRootPath() + "shopstore/user-database.txt";

    public static void add(String login, String password) {
        try (BufferedWriter db = new BufferedWriter(
                new FileWriter(dbPath, true))
        ) {
            db.write(login + "," + Base64.getEncoder().encodeToString(password.getBytes()) + "\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static User getUser(String login, String password) {
        try (BufferedReader db = new BufferedReader(
                new FileReader(dbPath))
        ) {
            String line;
            while ((line = db.readLine()) != null) {
                String loginDb = line.split(",")[0];
                String passwordDecoded = new String(Base64.getDecoder().decode(line.split(",")[1].getBytes()));
                if (loginDb.equals(login) && passwordDecoded.equals(password)) {
                    return new User(login, password);
                }
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
