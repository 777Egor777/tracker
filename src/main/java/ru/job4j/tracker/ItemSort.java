package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ItemSort {
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item("Tom"),
                new Item("Alex"),
                new Item("Viktor"),
                new Item("Bobby")
        );
        Tracker tracker = new Tracker();
        for (Item item : items) {
            tracker.add(item);
        }
        print("Before sort:", items);
        items = increaseSort(items);
        print("After increase sort:", items);
        items = deccreaseSort(items);
        print("After decrease sort:", items);
    }

    public static List<Item> increaseSort(List<Item> items) {
        Collections.sort(items, new ItemComparatorIncrease());
        return items;
    }
    public static List<Item> deccreaseSort(List<Item> items) {
        Collections.sort(items, new ItemComparatorDecrease());
        return items;
    }

    public static void print(String message, List<Item> items) {
        System.out.println(message);
        System.out.println(items);
    }
}
