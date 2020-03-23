package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class ConvertListTest {

    @Test
    public void convert() {
        List<int[]> list = Arrays.asList(new int[]{0}, new int[]{1}, new int[]{2}, new int[]{123312});
        List<Integer> result = ConvertList.convert(list);
        List<Integer> expected = Arrays.asList(0, 1, 2, 123312);
        assertThat(result, is(expected));
    }
}