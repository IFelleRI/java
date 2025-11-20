package ru.amfeller.lessonshop.services;

import ru.amfeller.lessonshop.store.ShopUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckFileService {
    public void saveCheck(String check, String login) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm");
        String formattedDate = LocalDateTime.now().format(formatter);
        File userDir = new File(ShopUtils.getRootPath() + "shopstore/checks/" + login);
        if (!userDir.exists()) {
            if (!userDir.mkdirs()) {
                System.err.println("Не удалось создать директорию: " + userDir.getAbsolutePath());
            }
        }
        File userCheck = new File(userDir, login + "_" + formattedDate + ".txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userCheck))) {
            writer.write(check);
        } catch (IOException e) {
            System.err.println("Не удалось записать: " + e.getMessage());
        }
    }

    public List<File> getUserChecks(String login) {
        List<File> result = new ArrayList<>();
        File userDir = new File(ShopUtils.getRootPath() + "shopstore/checks/" + login);
        File[] files = userDir.listFiles();
        if (files != null) {
            Arrays.sort(files);
            for (int i = 0; i < files.length; i++) {
                if (files[i].getName().endsWith(".txt")) {
                    result.add(files[i]);
                }
            }
        }
        return result;
    }

    public String readCheck(File checkFile) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(checkFile));
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + checkFile.getName());
        }
        return sb.toString();
    }
}
