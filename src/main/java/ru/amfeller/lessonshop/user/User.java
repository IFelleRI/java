package ru.amfeller.lessonshop.user;

import ru.amfeller.lessonshop.catalog.cart.Cart;
import ru.amfeller.lessonshop.services.CartFileService;
import ru.amfeller.lessonshop.services.CheckFileService;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private final String login;
    private final String password;
    private Cart cart;
    private String userState;
    private final CartFileService service = new CartFileService();

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public Cart getCart() {
        return this.cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setUserState(State userState) {
        this.userState += userState + "\n";
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
