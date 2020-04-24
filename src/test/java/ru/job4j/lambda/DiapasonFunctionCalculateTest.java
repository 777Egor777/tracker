package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class DiapasonFunctionCalculateTest {

    @Test
    public void diapasonOfLinearFunction() {
        List<Double> result = DiapasonFunctionCalculate.diapason(2, 5, x -> 5 * x + 7);
        List<Double> expected = Arrays.asList(
                17D,
                22D,
                27D,
                32D
        );
        assertThat(result, is(expected));
    }

    @Test
    public void diapasonOfSquareFunction() {
        List<Double> result = DiapasonFunctionCalculate.diapason(2, 5, x -> 3 * x * x + 5 * x + 11);
        List<Double> expected = Arrays.asList(
                33D,
                53D,
                79D,
                111D
        );
        assertThat(result, is(expected));
    }

    public static double loop(int to, Function<Double, Double> func, Supplier<Double> initValue) {
        double result = initValue.get();
        for (int index = 1; index <= to; ++index) {
            result = func.apply(result);
        }
        return result;
    }

    public static double exp(int base, int n) {
        Supplier<Double> supplier = () -> 1D;
        return loop(n, x -> x * base, supplier);
    }

    @Test
    public void diapasonOfExpFunction() {
        List<Double> result = DiapasonFunctionCalculate.diapason(2, 5, x -> exp(2, (int) Math.round(x)));
        List<Double> expected = Arrays.asList(
                4D,
                8D,
                16D,
                32D
        );
        assertThat(result, is(expected));
    }
}