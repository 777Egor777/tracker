package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.StringJoiner;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class ShowAllItemsTest {
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
        Tracker tracker = new Tracker();
        Item item = new Item("Egor");
        tracker.add(item);
        UserAction action = new ShowAllItems();
        Input input = new StubInput(Arrays.asList(""));
        action.execute(input, tracker);
        String result = new String(out.toByteArray());
        String expected = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("=== Show all items ===").
                        add("id: \"" + item.getId() + "\"  name: \"" + item.getName() + "\"").toString();
        assertThat(result, is(expected));
    }
}