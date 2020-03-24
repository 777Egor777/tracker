package ru.job4j.collection;

import java.util.Map;

public class MapEquals {
    public static boolean equals(Map<String, Order> first, Map<String, Order> second) {
        boolean result = true;
        for (String key : first.keySet()) {
            if (!second.containsKey(key) || !second.get(key).equals(first.get(key))) {
                result = false;
                break;
            }
        }
        if (result) {
            for (String key : second.keySet()) {
                if (!first.containsKey(key) || !first.get(key).equals(second.get(key))) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}
