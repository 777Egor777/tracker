package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        new StartUI().actions[0].execute(input, tracker);
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
        new StartUI().actions[2].execute(input, tracker);
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
        new StartUI().actions[3].execute(input, tracker);
        Item[] result = tracker.findAll();
        Item[] expected = new Item[0];
        assertThat(result, is(expected));
    }

    @Test
    public void init() {
        StubAction action = new StubAction();
        UserAction[] actions = new StubAction[]{action};
        Input input = new StubInput(new String[]{"0"});
        Tracker tracker = new Tracker();
        StartUI startUI = new StartUI();
        startUI.init(input, tracker, actions);
        boolean result = action.isCall();
        boolean expected = true;
        assertThat(result, is(expected));
    }

    @Test
    public void whenPrintMenu() {
        System.setOut(new PrintStream(out));
        StubAction action = new StubAction();
        UserAction[] actions = new UserAction[]{action};
        Input input = new StubInput(new String[]{"0"});
        Tracker tracker = new Tracker();
        StartUI startUI = new StartUI();
        startUI.init(input, tracker, actions);
        String result = new String(out.toByteArray());
        String expected = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Menu.").add("0: Stub action").toString();
        expected+= System.lineSeparator();
        assertThat(result, is(expected));
        System.setOut(stdout);
    }
}