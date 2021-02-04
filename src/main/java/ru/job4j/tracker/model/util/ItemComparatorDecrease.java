package ru.job4j.tracker.model.util;

import ru.job4j.tracker.model.Item;

import java.util.Comparator;

/**
 * Comparator, that used
 * for decrease sort of
 * Item collection.
 *
 * Items are sorted by
 * {@code name} field,
 * lexicographically
 *
 * @author Geraskin Egor (yegeraskin13@gmail.com)
 * @version 1.0
 */
public class ItemComparatorDecrease implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        return o1.getName().compareTo(o2.getName()) * -1;
    }
}
