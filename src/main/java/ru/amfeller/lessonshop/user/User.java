package ru.amfeller.lessonshop.user;

import ru.amfeller.lessonshop.shop.Cart;

import java.util.Objects;

public class User {
    private String login;
    private String password;
    private Cart cart;
    private String[] state = new String[]{""};

    public User() {
    }

    public Cart getCart() {
        return this.cart;
    }

    public String getPassword() {
        return password;
    }

    protected void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    protected void setLogin(String login) {
        this.login = login;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public StringBuilder getTrackAction() {
        StringBuilder track = new StringBuilder();
        for (String stateItem : state) {
            track.append(stateItem).append("\n ");
        }
        return track;
    }

    public void setTrackAction(String action) {
        if (state == null) {
            state = new String[]{action};
        }
        String[] tmpArr = new String[state.length + 1];
        System.arraycopy(state, 0, tmpArr, 0, state.length);
        tmpArr[tmpArr.length - 1] = action;
        this.state = tmpArr;
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
