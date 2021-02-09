package ru.job4j.tracker.store;

import org.junit.Test;
import ru.job4j.tracker.model.Item;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class HibernateTrackerTest {

    @Test
    public void add() {
        Store tracker = new HibernateTracker();
        Item item = new Item("Test");
        item = tracker.add(item);
        List<Item> items = tracker.findAll();
        assertThat(item, is(items.get(0)));
    }

    @Test
    public void replace() {
        Store tracker = new HibernateTracker();
        Item item = new Item("Test");
        item = tracker.add(item);
        item.setName("Test2");
        tracker.replace(item.getId(), item);
        List<Item> items = tracker.findAll();
        assertThat(item, is(items.get(0)));
    }

    @Test
    public void delete() {
        Store tracker = new HibernateTracker();
        Item item = new Item("Test");
        item = tracker.add(item);
        tracker.delete(item.getId());
        List<Item> items = tracker.findAll();
        assertThat(items.size(), is(0));
    }

    @Test
    public void findAll() {
        Store tracker = new HibernateTracker();
        Item item = new Item("Test");
        item = tracker.add(item);
        Item item2 = new Item("Test2");
        item2 = tracker.add(item2);
        List<Item> items = tracker.findAll();
        assertThat(item, is(items.get(0)));
        assertThat(item2, is(items.get(1)));
    }

    @Test
    public void findByName() {
        Store tracker = new HibernateTracker();
        Item item = new Item("Test");
        item = tracker.add(item);
        List<Item> items = tracker.findByName("Test");
        assertThat(item, is(items.get(0)));
    }

    @Test
    public void findById() {
        Store tracker = new HibernateTracker();
        Item item = new Item("Test");
        item = tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(item, is(result));
    }
}