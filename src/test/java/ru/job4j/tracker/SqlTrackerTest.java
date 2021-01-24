package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.SqlTracker;
import ru.job4j.tracker.util.ConnectionRollback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class SqlTrackerTest {
    /*
    @Test
    public void addItemTest() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(StartUI.initConnection()))) {
            Item item = new Item("test Item");
            tracker.add(item);
            List<Item> items = tracker.findAll();
            assertThat(items.get(0).getName(), is(item.getName()));
        }
    }

    @Test
    public void findAllTest() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(StartUI.initConnection()))) {
            Item item1 = new Item("test Item");
            Item item2 = new Item("test Item2");
            Item item3 = new Item("test Item3");
            tracker.add(item1);
            tracker.add(item2);
            tracker.add(item3);
            List<Item> items = tracker.findAll();
            List<String> result = new ArrayList<>();
            for (Item item : items) {
                result.add(item.getName());
            }
            List<String> expected = Arrays.asList("test Item", "test Item2", "test Item3");
            assertThat(result, is(expected));
        }
    }

    @Test
    public void findByNameTest() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(StartUI.initConnection()))) {
            Item item1 = new Item("test Item");
            Item item2 = new Item("test Item2");
            Item item3 = new Item("test Item3");
            Item item4 = new Item("test Item");
            tracker.add(item1);
            tracker.add(item2);
            tracker.add(item3);
            tracker.add(item4);
            List<Item> items = tracker.findByName("test Item");
            List<String> result = new ArrayList<>();
            for (Item item : items) {
                result.add("" + item.getId());
            }
            List<String> expected = Arrays.asList("" + item1.getId(), "" + item4.getId());
            assertThat(result, is(expected));
        }
    }

    @Test
    public void findByIdTest() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(StartUI.initConnection()))) {
            Item item1 = new Item("test Item");
            Item item2 = new Item("test Item2");
            Item item3 = new Item("test Item3");
            tracker.add(item1);
            tracker.add(item2);
            tracker.add(item3);
            List<Item> items = tracker.findAll();
            Item findResult = tracker.findById(item1.getId());
            assertThat(findResult, is(item1));
        }
    }

    @Test
    public void replaceTest() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(StartUI.initConnection()))) {
            Item bug = new Item("Bug");
            tracker.add(bug);
            Integer id = bug.getId();
            Item bugWithDesc = new Item("Bug with description");
            tracker.replace(id, bugWithDesc);
            assertThat(tracker.findById(id).getName(), is("Bug with description"));
        }
    }

    @Test
    public void deleteTest() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(StartUI.initConnection()))) {
            Item bug = new Item("Bug");
            tracker.add(bug);
            Integer id = bug.getId();
            tracker.delete(id);
            assertThat(tracker.findById(id), is(nullValue()));
        }
    }
     */
}