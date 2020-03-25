package ru.job4j.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void whenGreaterByName() {
        User alex = new User("Alex", 26);
        User vic = new User("Vic", 33);
        assertThat(vic.compareTo(alex), greaterThan(0));
    }

    @Test
    public void whenGreaterByAge() {
        User alex = new User("Alex", 26);
        User user = new User("Alex", 33);
        assertThat(user.compareTo(alex), greaterThan(0));
    }

    @Test
    public void whenEquals() {
        User alex = new User("Alex", 33);
        User user = new User("Alex", 33);
        assertThat(user.compareTo(alex), is(0));
    }

    @Test
    public void whenLessByAge() {
        User alex = new User("Alex", 26);
        User user = new User("Alex", 22);
        assertThat(user.compareTo(alex), lessThan(0));
    }

    @Test
    public void whenLessByName() {
        User alex = new User("Alex", 26);
        User user = new User("Ale", 22);
        assertThat(user.compareTo(alex), lessThan(0));
    }

    @Test
    public void sort() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Petr", 32));
        users.add(new User("Ivan", 31));
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Ivan", 31)));
        assertThat(it.next(), is(new User("Petr", 32)));
    }
}