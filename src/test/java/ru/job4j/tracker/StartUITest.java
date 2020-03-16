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
        StartUI.addItemToTracker(input, tracker);
        Item result = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(result.getName(), is(expected.getName()));
    }
}