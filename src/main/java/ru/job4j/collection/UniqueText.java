package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText  ) {
        boolean result = true;
        String[] origin = originText.split(" ");
        String[] duplicate = duplicateText.split(" ");
        Set<String> originSet = new HashSet();
        originSet.addAll(Arrays.asList(origin));
        for (String part : duplicate) {
            if (!originSet.contains(part)) {
                result = false;
                break;
            }
        }
        return result;
    }
}
