package ru.job4j.tracker.model.util;

import ru.job4j.tracker.model.Item;

import java.util.Comparator;

public class ItemComparatorIncrease implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        return o1.getName().compareTo(o2.getName());
    }
}