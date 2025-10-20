package ru.amfeller.lessonshop.user;

import ru.amfeller.lessonshop.shop.Cart;

import java.util.Objects;

public class User {
    private String login;
    private String password;
    private Cart cart;
    private String userState;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Cart getCart() {
        return this.cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void getUserState() {
        System.out.println(userState);
    }

    public void setUserState(State userState) {
        this.userState += userState+"\n";
    }

    @Override
    public String toString() {
        return login;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }
}
