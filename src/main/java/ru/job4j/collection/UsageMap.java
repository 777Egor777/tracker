package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("alex@yandex.ru", "Alex Viktorovich Ivanov");
        map.put("stepan@rambler.ru", "Stepan Ivanovich Pavlov");
        map.put("pavel@gmail.com", "Pal Palych Grishin");
        for (String key : map.keySet()) {
            System.out.println(String.format("key: %s, value: %s",
                               key, map.get(key)));
        }
    }
}
