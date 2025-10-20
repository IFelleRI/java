package ru.amfeller.lessonshop.user;

public class DataBase {
    private static User[] userData = new User[]{};

    public static void add(User user) {
        User[] tmpArr = new User[userData.length + 1];
        System.arraycopy(userData, 0, tmpArr, 0, userData.length);
        tmpArr[tmpArr.length - 1] = user;
        DataBase.userData = tmpArr;
    }

    public static User exists(User currentUser) {
        for (User user : DataBase.userData) {
            if (currentUser.equals(user)) {
                return user;
            }
        }
        return null;
    }
}
