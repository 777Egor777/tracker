package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.action.ShowAllItemsAction;
import ru.job4j.tracker.action.UserAction;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.StubInput;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.MemTracker;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringJoiner;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class ShowAllItemsActionTest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void doBeforeTests() {
        out.reset();
        System.setOut(new PrintStream(out));
    }

    @After
    public void doAFterTests() {
        System.setOut(stdout);
    }

    @Test
    public void whenPrintAllItems() {
        MemTracker tracker = new MemTracker();
        Item item = new Item("Egor");
        tracker.add(item);
        UserAction action = new ShowAllItemsAction();
        Input input = new StubInput(Collections.singletonList(""));
        action.execute(input, tracker);
        String result = new String(out.toByteArray());
        String expected = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("=== Show all items ===").
                        add("id: \"" + item.getId() + "\"  name: \"" + item.getName() + "\"").toString();
        assertThat(result, is(expected));
    }
}