package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("test@gmail.com", "Ivanov Ivan Ivanovich");
        map.put("test2@gmail.com", "Sidorov Ivan Ivanovich");
        map.put("test3@gmail.com", "Malov Ivan Ivanovich");
        map.put("test@gmail.com", "Petrov Ivan Ivanovich");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
