package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class FindAllActionTest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void beforeEachTest() {
        System.setOut(new PrintStream(out));
    }

    @After
    public void afterEachTest() {
        System.setOut(stdout);
    }

    @Test
    public void execute() {
        Tracker tracker = new Tracker();
        Item item = new Item("");
        tracker.add(item);
        UserAction action = new FindAllAction();
        Input input = new StubInput(new String[]{});
        action.execute(input, tracker);
        String result = new String(out.toByteArray());
        String expected = new StringJoiner()
    }
}