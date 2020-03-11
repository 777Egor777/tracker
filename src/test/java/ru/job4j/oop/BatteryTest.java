package ru.job4j.oop;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class BatteryTest {

    @Test
    public void exchange() {
        Battery first = new Battery(7);
        Battery second = new Battery(10);
        first.exchange(second);
        assertThat(new int[]{first.getLoad(), second.getLoad()},
                   is(new int[]{0, 17}));
    }
}