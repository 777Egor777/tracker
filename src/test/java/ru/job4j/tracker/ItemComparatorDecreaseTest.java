package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.model.util.ItemComparatorDecrease;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class ItemComparatorDecreaseTest {

    @Test
    public void compare() {
        List<Item> items = Arrays.asList(
                new Item("Tom"),
                new Item("Alex"),
                new Item("Viktor"),
                new Item("Bobby")
        );
        items.sort(new ItemComparatorDecrease());
        List<Item> expected = Arrays.asList(
                new Item("Viktor"),
                new Item("Tom"),
                new Item("Bobby"),
                new Item("Alex")
        );
        assertThat(items, is(expected));
    }
}