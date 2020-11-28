package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Test
    public void whenAddItem() {
        List<String> answers = new ArrayList(Arrays.asList("Fix PC"));
        Input input = new StubInput(answers);
        MemTracker tracker = new MemTracker();
        new StartUI().actions.get(0).execute(input, tracker);
        Item result = tracker.findAll().get(0);
        Item expected = new Item("Fix PC");
        assertThat(result.getName(), is(expected.getName()));
    }

    @Test
    public void editItemInTracker() {
        Item item = new Item("Fix PC");
        MemTracker tracker = new MemTracker();
        tracker.add(item);
        List<String> answers = new ArrayList(Arrays.asList(item.getId(), "replaced Item"));
        Input input = new StubInput(answers);
        new StartUI().actions.get(2).execute(input, tracker);
        String result = tracker.findAll().get(0).getName();
        String expected = "replaced Item";
        assertThat(result, is(expected));
    }

    @Test
    public void deleteItemFromTracker() {
        Item item = new Item("Fix PC");
        MemTracker tracker = new MemTracker();
        tracker.add(item);
        List<String> answers = new ArrayList(Arrays.asList(item.getId()));
        Input input = new StubInput(answers);
        new StartUI().actions.get(3).execute(input, tracker);
        List<Item> result = tracker.findAll();
        List<Item> expected = new ArrayList<>();
        assertThat(result, is(expected));
    }

    @Test
    public void init() {
        StubAction action = new StubAction();
        List<UserAction> actions = Arrays.asList(action);
        Input input = new StubInput(new ArrayList(Arrays.asList("0")));
        MemTracker tracker = new MemTracker();
        StartUI startUI = new StartUI();
        startUI.init(input, tracker, actions);
        boolean result = action.isCall();
        boolean expected = true;
        assertThat(result, is(expected));
    }

    @Test
    public void whenPrintMenu() {
        out.reset();
        System.setOut(new PrintStream(out));
        StubAction action = new StubAction();
        List<UserAction> actions = Arrays.asList(action);
        Input input = new StubInput(new ArrayList(Arrays.asList("0")));
        MemTracker tracker = new MemTracker();
        StartUI startUI = new StartUI();
        startUI.init(input, tracker, actions);
        String result = new String(out.toByteArray());
        String expected = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Menu.").add("0: Stub action").toString();
        expected += System.lineSeparator();
        assertThat(result, is(expected));
        System.setOut(stdout);
    }
}