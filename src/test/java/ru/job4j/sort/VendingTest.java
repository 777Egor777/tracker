package ru.job4j.sort;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class VendingTest {

    @Test
    public void whenZeroChange() {
        Vending vending = new Vending();
        int[] result = vending.change(100, 100);
        int[] expected = {};
        assertThat(result, is(expected));
    }

    @Test
    public void when15RublesChange() {
        Vending vending = new Vending();
        int[] result = vending.change(50, 35);
        int[] expected = {10, 5};
        assertThat(result, is(expected));
    }

    @Test
    public void when38RublesChange() {
        Vending vending = new Vending();
        int[] result = vending.change(50, 12);
        int[] expected = {10, 10, 10, 5, 2, 1};
        assertThat(result, is(expected));
    }
}