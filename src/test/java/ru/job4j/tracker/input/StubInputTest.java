package ru.job4j.tracker.input;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StubInputTest {

    @Test
    public void askStr() {
        List<String> list = new ArrayList<>();
        list.add("Test");
        Input input = new StubInput(list);
        assertThat(input.askStr(""), is("Test"));
    }

    @Test
    public void askIntWhenCorrect() {
        List<String> list = new ArrayList<>();
        list.add("123");
        Input input = new StubInput(list);
        assertThat(input.askInt(""), is(123));
    }

    @Test(expected = IllegalStateException.class)
    public void askIntWhenNotNumberString() {
        List<String> list = new ArrayList<>();
        list.add("Not number");
        Input input = new StubInput(list);
        input.askInt("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void askIntWhenNotInDiapason() {
        List<String> list = new ArrayList<>();
        list.add("123");
        Input input = new StubInput(list);
        input.askInt("", 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void askIntWhenNotInDiapason2() {
        List<String> list = new ArrayList<>();
        list.add("-1");
        Input input = new StubInput(list);
        input.askInt("", 100);
    }

    @Test
    public void nextLine() {
        List<String> list = new ArrayList<>();
        list.add("Test");
        Input input = new StubInput(list);
        assertThat(input.nextLine(), is("Test"));
    }
}