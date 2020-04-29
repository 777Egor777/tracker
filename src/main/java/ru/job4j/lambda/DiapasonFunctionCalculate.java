package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class DiapasonFunctionCalculate {
    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> list = new ArrayList<>();
        Consumer<Double> addToListConsumer = list::add;
        for (int index = start; index <= end; ++index) {
            addToListConsumer.accept(func.apply((double) index));
        }
        return list;
    }
}
