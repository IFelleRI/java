package ru.amfeller.lessonshop.user;

import ru.amfeller.lessonshop.catalog.cart.Cart;
import ru.amfeller.lessonshop.services.CartFileService;
import ru.amfeller.lessonshop.user.exception.WrongLoginException;
import ru.amfeller.lessonshop.user.exception.WrongPasswordException;

import java.util.Scanner;

public class Auth {
    private static final Scanner scanner = new Scanner(System.in);
    private final CartFileService service = new CartFileService();

    public User start() {
        while (true) {
            System.out.println();
            System.out.println("Авторизация");
            System.out.println("----------------------------------------");
            System.out.print("Введите логин: ");
            String login = scanner.nextLine();
            System.out.print("Введите пароль: ");
            String password = scanner.nextLine();

            User user = login(login, password);

            if (user != null) {
                user.setUserState(State.AUTHENTICATED);
                return user;
            }
        }
    }

    private User login(String login, String password) {
        User authUser = new User(login, password);
        User existsUser = DataBase.getUser(login, password);

        if (existsUser != null) {
            System.out.println("Пользователь авторизован");
            Cart cart = service.getCart(login);
            cart.setUser(existsUser);
            existsUser.setCart(cart);
            return existsUser;
        }

        if (register(login, password)) {
            DataBase.add(login, password);
            Cart cart = service.getCart(login);
            cart.setUser(authUser);
            authUser.setCart(cart);
            System.out.println("Пользователь зареган и авторизован");
            return authUser;
        }
        return null;
    }

    private boolean register(String login, String password) {
        try {
            if (isNotValid(login)) {
                throw new WrongLoginException("Логин содержит недопустимые символы");
            } else if (login.length() > 20) {
                throw new WrongLoginException("Логин слишком длинный");
            }
            if (isNotValid(password)) {
                throw new WrongPasswordException("Пароль содержит недопустимые символы");
            } else if (password.length() < 6 || password.length() > 20) {
                throw new WrongPasswordException("Неправильная длина пароля");
            }
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Ошибка: " + e.getMessage());
            return false;
        }
    }

    private boolean isValid(String input) {
        return input.matches("^[A-Za-z0-9_]+$");
    }

    private boolean isNotValid(String input) {
        return !isValid(input);
    }
}
