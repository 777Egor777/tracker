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

public class FindItemByIDActionTest {
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
    public void whenFindItems() {
        MemTracker tracker = new MemTracker();
        Item item = new Item("Egor");
        tracker.add(item);
        UserAction action = new FindItemByIDAction();
        Input input = mock(Input.class);
        when(input.askInt("Enter id: ")).thenReturn(1);
        action.execute(input, tracker);
        String result = new String(out.toByteArray());
        String expected = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("=== Find item by id  ===").
                        add("id: \"" + item.getId() + "\"  name: \"" + item.getName() + "\"").toString();
        assertThat(result, is(expected));
    }

    @Test
    public void whenFindNoItems() {
        MemTracker tracker = new MemTracker();
        Item item = new Item("Egor");
        tracker.add(item);
        UserAction action = new FindItemByIDAction();
        Input input = mock(Input.class);
        when(input.askStr("Enter id: ")).thenReturn("2");
        action.execute(input, tracker);
        String result = new String(out.toByteArray());
        String expected = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("=== Find item by id  ===").
                        add("No such id").toString();
        assertThat(result, is(expected));
    }
}