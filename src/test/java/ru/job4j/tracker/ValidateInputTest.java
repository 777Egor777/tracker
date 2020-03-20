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
        ValidateInput input = new ValidateStubInput(new String[]{"one", "1"});
        input.askInt("Select: ", 2);
        String result = new String(out.toByteArray());
        String expected = "Please enter correct integer number!" + System.lineSeparator();
        assertThat(result, is(expected));
    }

    @Test
    public void whenMaxNumberInput() {
        ValidateInput input = new ValidateStubInput(new String[]{"one", "6"});
        input.askInt("Select: ", 7);
        String result = new String(out.toByteArray());
        String expected = "Please enter correct integer number!" + System.lineSeparator();
        assertThat(result, is(expected));
    }
}