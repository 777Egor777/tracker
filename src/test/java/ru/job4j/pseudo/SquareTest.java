package ru.job4j.pseudo;

import org.junit.Test;

import java.util.StringJoiner;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class SquareTest {

    @Test
    public void whenCorrectSquare() {
        String result = new Square().draw();
        String expected = new StringJoiner(System.lineSeparator()).add("****")
                                                                  .add("****")
                                                                  .add("****")
                                                                  .add("****").toString();
        assertThat(result, is(expected));
    }
}