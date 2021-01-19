package ru.job4j.tracker.model.util;

import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.MemTracker;
import ru.job4j.tracker.store.Store;

import java.util.Arrays;
import java.util.List;

public class ItemSort {
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item("Tom"),
                new Item("Alex"),
                new Item("Viktor"),
                new Item("Bobby")
        );
        Store tracker = new MemTracker();
        for (Item item : items) {
            tracker.add(item);
        }
        print("Before sort:", items);
        increaseSort(items);
        print("After increase sort:", items);
        decreaseSort(items);
        print("After decrease sort:", items);
    }

    public static void increaseSort(List<Item> items) {
        items.sort(new ItemComparatorIncrease());
    }

    public static void decreaseSort(List<Item> items) {
        items.sort(new ItemComparatorDecrease());
    }

    public static void print(String message, List<Item> items) {
        System.out.println(message);
        System.out.println(items);
    }
}
