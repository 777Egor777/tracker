package ru.job4j.tracker.action;

import org.junit.Test;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.store.MemTracker;
import ru.job4j.tracker.store.Store;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AddItemActionTest {

    @Test
    public void execute() {
        UserAction action = new AddItemAction();
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("Test");
        Store tracker = new MemTracker();
        action.execute(input, tracker);
        assertThat(tracker.findAll().get(0).getName(), is("Test"));
    }
}