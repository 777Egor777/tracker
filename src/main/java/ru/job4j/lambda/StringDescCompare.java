package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StringDescCompare {
    public static void descSort(List<String> list) {
        Comparator<String> descCmp = (left, right) -> {
            System.out.println("Desc compare - " + left +  " : " + right);
            return right.compareTo(left);
        };
        list.sort(descCmp);
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList(
                "abcd",
                "adel",
                "kotik",
                "zzip"
        );
        System.out.println(list);
        descSort(list);
        System.out.println(list);
    }
}
