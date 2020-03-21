package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class ValidateInputTest {
    public final PrintStream stdout = System.out;
    public final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void doBeforeEachTest() {
        out.reset();
        System.setOut(new PrintStream(out));
    }

    @After
    public void doAfterEachTest() {
        System.setOut(stdout);
    }

    @Test
    public void whenInvalidInput() {
        Input input = new ValidateInput(new StubInput(new String[]{"2", "1"}));
        input.askInt("Select: ", 2);
        String result = new String(out.toByteArray());
        String expected = "Number not from diapason [0:2)" + System.lineSeparator();
        assertThat(result, is(expected));
    }

    @Test
    public void whenMaxNumberInput() {
        Input input = new ValidateInput(new StubInput(new String[]{"one", "6"}));
        input.askInt("Select: ", 7);
        String result = new String(out.toByteArray());
        String expected = "This is not an Integer number." + System.lineSeparator();
        assertThat(result, is(expected));
    }
}