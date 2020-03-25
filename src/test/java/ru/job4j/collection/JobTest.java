package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class JobTest {

    @Test
    public void compare() {
        List<Job> list = Arrays.asList(
                new Job("Driver", 12412313),
                new Job("Driver", 456),
                new Job("Driver", 1),
                new Job("Aviator", 100),
                new Job("Aviator", 3534534),
                new Job("Aviator", 1),
                new Job("Footballer", 100),
                new Job("Footballer", 1),
                new Job("Footballer", 10000),
                new Job("Cosmonaut", 20000),
                new Job("Cosmonaut", 1000000),
                new Job("Cosmonaut", 10000000),
                new Job("Sailor", 1000),
                new Job("Programmer", 2000),
                new Job("Designer", 5000),
                new Job("Artist", 23000),
                new Job("Builder", 500)
        );
        Collections.sort(list, new JobCompNameIncrease().thenComparing(new JobCompPriorityIncrease()));
        List<Job> expected = Arrays.asList(
                new Job("Artist", 23000),
                new Job("Aviator", 1),
                new Job("Aviator", 100),
                new Job("Aviator", 3534534),
                new Job("Builder", 500),
                new Job("Cosmonaut", 20000),
                new Job("Cosmonaut", 1000000),
                new Job("Cosmonaut", 10000000),
                new Job("Designer", 5000),
                new Job("Driver", 1),
                new Job("Driver", 456),
                new Job("Driver", 12412313),
                new Job("Footballer", 1),
                new Job("Footballer", 100),
                new Job("Footballer", 10000),
                new Job("Programmer", 2000),
                new Job("Sailor", 1000)
        );
        assertThat(list, is(expected));
    }
}