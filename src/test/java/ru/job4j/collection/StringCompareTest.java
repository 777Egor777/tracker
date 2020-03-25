package ru.job4j.collection;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

public class StringCompareTest {

    @Test
    public void compare() {
        StringCompare cmp = new StringCompare();
        int result = cmp.compare("Petrov",
                                 "Petrov");
        int expected = 0;
        assertThat(result, is(expected));
    }

    @Test
    public void compare2() {
        StringCompare cmp = new StringCompare();
        int result = cmp.compare("Petrovv",
                "Petrov");
        assertThat(result, greaterThan(0));
    }

    @Test
    public void compare3() {
        StringCompare cmp = new StringCompare();
        int result = cmp.compare("Petrov",
                "Petrovv");
        assertThat(result, lessThan(0));
    }

    @Test
    public void compare4() {
        StringCompare cmp = new StringCompare();
        int result = cmp.compare("Patrov",
                "Petrov");
        assertThat(result, lessThan(0));
    }

    @Test
    public void compare5() {
        StringCompare cmp = new StringCompare();
        int result = cmp.compare("Petrov",
                "Patrov");
        assertThat(result, greaterThan(0));
    }
}