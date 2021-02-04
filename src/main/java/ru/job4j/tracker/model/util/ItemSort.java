package ru.job4j.tracker.model.util;

import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.MemTracker;
import ru.job4j.tracker.store.Store;

import java.util.Arrays;
import java.util.List;

/**
 * Utility class for
 * sorting collections of
 * {@code Item} model by
 * decrease or increase.
 *
 * @author Geraskin Egor (yegeraskin13@gmail.com)
 * @version 1.0
 */
public class ItemSort {
    public static void increaseSort(List<Item> items) {
        items.sort(new ItemComparatorIncrease());
    }
    public static void decreaseSort(List<Item> items) {
        items.sort(new ItemComparatorDecrease());
    }
}
