package ru.job4j.collection;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class OrderConvertTest {

    @Test
    public void whenNoOrders() {
        List<Order> orders = List.of();
        Map<String, Order> result = OrderConvert.process(orders);
        Map<String, Order> extended = Map.of();
        assertThat(result, is(extended));
    }

    @Test
    public void whenSingleOrder() {
        List<Order> orders = List.of(
                new Order("first", "Egor")
        );
        Map<String, Order> result = OrderConvert.process(orders);
        Map<String, Order> extended = Map.of("first", new Order("first", "Egor"));
        assertThat(MapEquals.equals(result, extended), is(true));
    }
}