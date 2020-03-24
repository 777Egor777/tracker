package ru.job4j.collection;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class OrderConvertTest {

    @Test
    public void whenNoOrders() {
        List<Order> orders = Arrays.asList();
        Map<String, Order> result = OrderConvert.process(orders);
        Map<String, Order> extended = new HashMap<>();
        assertThat(result, is(extended));
    }

    @Test
    public void whenSingleOrder() {
        Order order = new Order("first", "Egor");
        List<Order> orders = Arrays.asList(order);
        Map<String, Order> result = OrderConvert.process(orders);
        Map<String, Order> extended = new HashMap<>();
        extended.put("first", new Order("first", "Egor"));
        assertThat(MapEquals.equals(result, extended), is(true));
    }
}