package ru.amfeller.lessonshop.user;

import java.util.Scanner;

public class Auth {
    public static final Scanner scanner = new Scanner(System.in);
    private static User[] users = new User[]{};

    public User init(User user) {
        while (true) {
            System.out.println();
            System.out.println("Авторизация");
            System.out.println("----------------------------------------");
            System.out.print("Введите логин: ");
            String username = scanner.nextLine();
            System.out.print("Введите пароль: ");
            String password = scanner.nextLine();

            user.setLogin(username);
            user.setPassword(password);

            User existingUser = existUser(user);
            if (existingUser != null) {
                System.out.println("Пользователь авторизован: " + existingUser.getLogin());
                return existingUser;
            }
            if (this.register(user)) {
                System.out.println("Пользователь авторизован");
                return user;
            }
        }
    }

    private User existUser(User currentUser) {
        for (User user : users) {
            if (currentUser.equals(user)) {
                return user;
            }
        }
        return null;
    }

    private boolean register(User user) {
        String login = user.getLogin();
        String password = user.getPassword();
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
            this.addUser(user);
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Ошибка: " + e.getMessage());
            return false;
        }
    }

    private void addUser(User user) {
        User[] tmpArr = new User[users.length + 1];
        System.arraycopy(users, 0, tmpArr, 0, users.length);
        tmpArr[tmpArr.length - 1] = user;
        users = tmpArr;
    }

    private boolean isValid(String input) {
        return input.matches("^[A-Za-z0-9_]+$");
    }

    private boolean isNotValid(String input) {
        return !isValid(input);
    }
}
