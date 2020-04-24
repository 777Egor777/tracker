package ru.job4j.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class RefMethod {
    public static void cutOut(String value) {
        if (value.length() > 10) {
            value = value.substring(0, 10) + "..";
        }
        System.out.println(value);
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Egor",
                "Ivan",
                "Abracadabraxxxx"
        );
        Consumer<String> consumer = RefMethod::cutOut;
        names.forEach(consumer);
    }
}
