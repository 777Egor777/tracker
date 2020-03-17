package ru.job4j.pseudo;

import org.junit.Test;

import java.util.StringJoiner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TriangleTest {

    @Test
    public void whenCorrectTriangle() {
        String result = new Triangle().draw();
        String expected = new StringJoiner(System.lineSeparator()).add("   *   ")
                .add("  ***  ")
                .add(" ***** ")
                .add("*******").toString();
        assertThat(result, is(expected));
    }
}