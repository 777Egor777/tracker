package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class NotifyAccountTest {

    @Test
    public void sent() {
        List<Account> list = List.of(
                new Account("123", "Viktor", "100"),
                new Account("321", "Alex", "200")
        );
        Set<Account> result = NotifyAccount.sent(list);
        Set<Account> expected = Set.of(
                new Account("123", "Viktor", "100"),
                new Account("321", "Alex", "200")
        );
        assertThat(result, is(expected));
    }

    @Test
    public void deleteDuplicates() {
        List<Account> list = List.of(
                new Account("123", "Viktor", "100"),
                new Account("123", "Kostya", "1000"),
                new Account("321", "Alex", "200")
        );
        Set<Account> result = NotifyAccount.sent(list);
        Set<Account> expected = Set.of(
                new Account("123", "Viktor", "100"),
                new Account("321", "Alex", "200")
        );
        assertThat(result, is(expected));
    }
}