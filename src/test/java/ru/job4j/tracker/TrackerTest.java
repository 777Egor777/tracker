package ru.job4j.tracker;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class TrackerTest {

    @Test
    public void add() {
        Tracker tracker = new Tracker();
        Item item = new Item("test Item");
        tracker.add(item);
        Item[] items = tracker.findAll();
        assertThat(items[0].getName(), is(item.getName()));
    }

    @Test
    public void findAll() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test Item");
        Item item2 = new Item("test Item2");
        Item item3 = new Item("test Item3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        Item[] items = tracker.findAll();
        String[] result = new String[items.length];
        for (int index = 0; index < items.length; ++index) {
            result[index] = items[index].getName();
        }
        String[] expected = {"test Item", "test Item2", "test Item3"};
        assertThat(result, is(expected));
    }

    @Test
    public void findByName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test Item");
        Item item2 = new Item("test Item2");
        Item item3 = new Item("test Item3");
        Item item4 = new Item("test Item");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        Item[] items = tracker.findByName("test Item");
        String[] result = new String[items.length];
        for (int index = 0; index < items.length; ++index) {
            result[index] = items[index].getName();
        }
        String[] expected = {"test Item", "test Item"};
        assertThat(result, is(expected));
    }

    @Test
    public void findById() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test Item");
        Item item2 = new Item("test Item2");
        Item item3 = new Item("test Item3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        Item[] items = tracker.findAll();
        Item temp = items[0];
        Item findResult = tracker.findById(temp.getId());
        assertThat(findResult, is(temp));
    }
}