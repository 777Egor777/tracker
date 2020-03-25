package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = -1;
        if (left == null && right == null) {
            result = 0;
        } else if (right == null) {
            result = 1;
        } else if (left != null) {
            int indexLeft = 0;
            int indexRight = 0;
            while (indexLeft < left.length() &&
                   indexRight < right.length()) {
                if (left.charAt(indexLeft) !=
                    right.charAt(indexRight)) {
                    break;
                }
                indexLeft++;
                indexRight++;
            }
            if (indexLeft == left.length() &&
                indexRight == right.length()) {
                result = 0;
            } else if (indexRight == right.length()) {
                result = 1;
            } else if (indexLeft != left.length()) {
                result = Character.compare(left.charAt(indexLeft),
                                           right.charAt(indexRight));
            }
        }
        return result;
    }
}
