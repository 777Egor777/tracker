package ru.job4j.collection;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class UniqueTextTest {

    @Test
    public void whenEquals() {
        String origin = "I believe i can fly";
        String text = "I believe fly";
        boolean result = UniqueText.isEquals(origin, text);
        boolean expected = true;
        assertThat(result, is(expected));
    }

    @Test
    public void whenNotEquals() {
        String origin = "I believe i can fly";
        String text = "I believe and fly";
        boolean result = UniqueText.isEquals(origin, text);
        boolean expected = false;
        assertThat(result, is(expected));
    }
}