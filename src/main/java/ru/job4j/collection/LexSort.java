package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return Integer.compare(numbFromStr(o1), numbFromStr(o2));
    }

    public static int numbFromStr(String line) {
        int dotPosition = line.indexOf('.');
        String numberString = line.substring(0, dotPosition);
        return Integer.parseInt(numberString);
    }
}
