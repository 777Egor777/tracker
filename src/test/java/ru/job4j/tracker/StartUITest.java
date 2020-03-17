package ru.job4j.tracker;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class StartUITest {
    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.actions[0].execute(input, tracker);
        Item result = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(result.getName(), is(expected.getName()));
    }

    @Test
    public void editItemInTracker() {
        Item item = new Item("Fix PC");
        Tracker tracker = new Tracker();
        tracker.add(item);
        String[] answers = {item.getId(), "replaced Item"};
        Input input = new StubInput(answers);
        StartUI.actions[2].execute(input, tracker);
        String result = tracker.findAll()[0].getName();
        String expected = "replaced Item";
        assertThat(result, is(expected));
    }

    @Test
    public void deleteItemFromTracker() {
        Item item = new Item("Fix PC");
        Tracker tracker = new Tracker();
        tracker.add(item);
        String[] answers = {item.getId()};
        Input input = new StubInput(answers);
        StartUI.actions[3].execute(input, tracker);
        Item[] result = tracker.findAll();
        Item[] expected = new Item[0];
        assertThat(result, is(expected));
    }
}