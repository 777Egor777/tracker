package ru.job4j.tracker;

import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class ItemComparatorIncreaseTest {

    @Test
    public void compare() {
        List<Item> items = Arrays.asList(
                new Item("Tom"),
                new Item("Alex"),
                new Item("Viktor"),
                new Item("Bobby")
        );
        items.sort(new ItemComparatorIncrease());
        List<Item> expected = Arrays.asList(
                new Item("Alex"),
                new Item("Bobby"),
                new Item("Tom"),
                new Item("Viktor")
        );
        assertThat(items, is(expected));
    }
}