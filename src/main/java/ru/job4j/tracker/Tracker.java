package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Date;

/**
 * Class Tracker - wrapper
 * on an array of Item's
 * @author Geraskin Egor (yegeraskin13@gmail.com)
 */
public class Tracker {
    /**
     * Constant - size of items array
     */
    private static final int ITEMS_ARRAY_SIZE = 100;

    /**
     * Array of requests
     */
    private Item[] items = new Item[ITEMS_ARRAY_SIZE];

    /**
     * Current number of request
     * (current size of "items" array)
     */
    private int size = 0;

    /**
     * Generator of random id's
     * for all requests
     * @return random number -
     *         id for some request
     */
    private String generateId() {
        return "" + new Date().getTime() * Math.random();
    }

    /**
     * Method receive request,
     * modificate it(add Id),
     * add request to request's
     * array and next return it
     * @param item - new request
     * @return modificated request
     */
    public Item add(Item item) {
        item.setId(generateId());
        this.items[this.size++] = item;
        return item;
    }

    /**
     * Method return all current
     * requests. Alll not-null
     * request from array of
     * requests
     * @return all current requests
     */
    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.size);
    }

    /**
     * Return array of requests,
     * that has this special name
     * @param name - special name
     * @return array of requests
     *         that has this
     *         special name
     */
    public Item[] findByName(String name) {
        Item[] result = new Item[ITEMS_ARRAY_SIZE];
        int currentSize = 0;
        for (int index = 0; index < this.size; ++index) {
            if (this.items[index].getName().equals(name)) {
                result[currentSize++] = this.items[index];
            }
        }
        return Arrays.copyOf(result, currentSize);
    }

    /**
     * Return request with this
     * special id or null
     * @param id - special id
     * @return request with special id
     *         or
     *         null -  if there is no
     *         request with such id
     */
    public Item findById(String id) {
        int index = this.indexOf(id);
        return index == -1 ? null : this.items[index];
    }

    /**
     * Method find index in
     * "items" array of request,
     * that has this special
     * id
     * @param id - id of searchable
     *             request
     * @return index(int number) - if
     *         request with such id
     *         exit in the array
     *
     *         null - otherwise
     */
    private int indexOf(String id) {
        int result = -1;
        for (int index = 0; index < this.size; ++index) {
            if (this.items[index].getId().equals(id)) {
                result = index;
                break;
            }
        }
        return result;
    }

    /**
     * Method replace request with id "id"
     * by the request "item"
     * @param id - id of the replacable
     *             request
     * @param item - new request, that
     *               replaces the old request
     */
    public void replace(String id, Item item) {
        int index = indexOf(id);
        item.setId(id);
        this.items[index] = item;
    }
}
