package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FullSearch {
    public static Set<String> extractNumber(List<Task> list) {
        Set<String> result = new HashSet<>();
        for (Task task : list) {
            result.add(task.getNumber());
        }
        return result;
    }
}
