package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.action.EditItemAction;
import ru.job4j.tracker.action.UserAction;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.MemTracker;
import ru.job4j.tracker.store.Store;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

public class EditItemActionTest {
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
    public void whenEditItem() {
        Store tracker = new MemTracker();
        tracker.add(new Item("Item to replace"));
        String replacedName = "New item name";
        UserAction action = new EditItemAction();
        Input input = mock(Input.class);
        when(input.askStr("Enter id: ")).thenReturn("1");
        when(input.askStr("Enter item name: ")).thenReturn(replacedName);
        action.execute(input, tracker);
        StringJoiner joiner = new StringJoiner(System.lineSeparator(), "", System.lineSeparator());
        joiner.add("=== Edit item ===");
        joiner.add("Operation successful!");
        assertThat(new String(out.toByteArray()), is(joiner.toString()));
        assertThat(tracker.findAll().get(0).getName(), is(replacedName));
    }

    @Test
    public void whenNoEditItem() {
        Store tracker = new MemTracker();
        tracker.add(new Item("Item to replace"));
        String replacedName = "New item name";
        UserAction action = new EditItemAction();
        Input input = mock(Input.class);
        when(input.askStr("Enter id: ")).thenReturn("2");
        when(input.askStr("Enter item name: ")).thenReturn(replacedName);
        action.execute(input, tracker);
        StringJoiner joiner = new StringJoiner(System.lineSeparator(), "", System.lineSeparator());
        joiner.add("=== Edit item ===");
        joiner.add("No such id :(");
        assertThat(new String(out.toByteArray()), is(joiner.toString()));
        assertThat(tracker.findAll().get(0).getName(), is("Item to replace"));
    }
}