package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class FullSearchTest {

    @Test
    public void extractNumber() {
        List<Task> list = Arrays.asList(
                new Task("1", "Egor desc"),
                new Task("2", "Viktor desc"),
                new Task("3", "Alex desc"),
                new Task("1", "Paul's desc"),
                new Task("1", "Efim's desc")
        );
        Set<String> result = FullSearch.extractNumber(list);
        Set<String> expected = new HashSet<>(Arrays.asList("1", "2", "3"));
        assertThat(result, is(expected));
    }
}