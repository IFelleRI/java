package ru.amfeller.lessonshop.operations.user;

import ru.amfeller.lessonshop.operations.Operation;
import ru.amfeller.lessonshop.services.CheckFileService;
import ru.amfeller.lessonshop.store.ShopSession;
import ru.amfeller.lessonshop.store.ShopUtils;
import ru.amfeller.lessonshop.user.User;

import java.io.File;
import java.util.List;

public class ShowChecks implements Operation {
    private final ShopSession shopSession;
    private CheckFileService service = new CheckFileService();

    public ShowChecks(ShopSession currentShop) {
        this.shopSession = currentShop;
    }
    @Override
    public void doOperation() {
        User user = shopSession.getUser();
        List<File> checks = service.getUserChecks(user.getLogin());
        if(checks.isEmpty()) {
            System.out.println("Чеков нет!");
            return;
        }
        for (int i = 0; i < checks.size(); i++) {
            System.out.println((i+1)+" "+checks.get(i).getName());
        }
        System.out.print("Введите № чека: ");
        int option = ShopUtils.getChoice(checks.size(), "");
        String content = service.readCheck(checks.get(option));
        System.out.println(content);
    }
}
