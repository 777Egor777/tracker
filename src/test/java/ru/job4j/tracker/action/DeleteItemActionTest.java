package ru.job4j.tracker.action;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.MemTracker;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DeleteItemActionTest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void doBeforeTests() {
        out.reset();
        System.setOut(new PrintStream(out));
    }

    @After
    public void doAfterTests() {
        System.setOut(stdout);
    }

    @Test
    public void whenDeleteItem() {
        MemTracker tracker = new MemTracker();
        Item item = new Item("Egor");
        tracker.add(item);
        UserAction action = new DeleteItemAction();
        Input input = mock(Input.class);
        when(input.askStr("Enter id: ")).thenReturn("1");
        action.execute(input, tracker);
        String result = new String(out.toByteArray());
        String expected = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("=== Delete item ===").
                        add("Operation successful!").toString();
        assertThat(result, is(expected));
        assertTrue(tracker.findAll().isEmpty());
    }

    @Test
    public void whenDeleteNoItems() {
        MemTracker tracker = new MemTracker();
        Item item = new Item("Egor");
        tracker.add(item);
        UserAction action = new DeleteItemAction();
        Input input = mock(Input.class);
        when(input.askStr("Enter id: ")).thenReturn("2");
        action.execute(input, tracker);
        String result = new String(out.toByteArray());
        String expected = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("=== Delete item ===").
                        add("No such id :(").toString();
        assertThat(result, is(expected));
        assertFalse(tracker.findAll().isEmpty());
    }
}