package ru.job4j.lambda;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class ReduceAdvanced {
    public static int loop(int to, BiFunction<Integer, Integer, Integer> func, Supplier<Integer> initValue) {
        int result = initValue.get();
        for (int index = 1; index <= to; ++index) {
            result = func.apply(result, index);
        }
        return result;
    }

    public static int summation(int to) {
        BiFunction<Integer, Integer, Integer> func = new BinaryOperator<>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        };
        Supplier<Integer> initValue = new Supplier<>() {
            @Override
            public Integer get() {
                return 0;
            }
        };
        return loop(to, func, initValue);
    }

    public static int multiplication(int to) {
        BiFunction<Integer, Integer, Integer> func = new BinaryOperator<>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer * integer2;
            }
        };
        Supplier<Integer> initValue = new Supplier<>() {
            @Override
            public Integer get() {
                return 1;
            }
        };
        return loop(to, func, initValue);
    }

    public static void main(String[] args) {
        System.out.println(summation(5));
        System.out.println(multiplication(5));
    }
}
