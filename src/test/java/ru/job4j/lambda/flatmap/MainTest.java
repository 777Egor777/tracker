package ru.job4j.lambda.flatmap;

import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class MainTest {

    @Test
    public void collect() {
        Integer[][] nums = {
                {4, 1},
                {2, 3}
        };
        List<Integer> result= Main.collect(nums);
        List<Integer> expected = List.of(4, 1, 2, 3);
        assertThat(result, is(expected));
    }
}