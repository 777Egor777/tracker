package ru.job4j.tracker.store;

import ru.job4j.tracker.model.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Tracker - wrapper
 * on an array of Item's
 * @author Geraskin Egor (yegeraskin13@gmail.com)
 */
public class MemTracker implements Store {

    /**
     * Array of requests
     */
    private List<Item> items = new ArrayList<>();

    private int curId = 1;

    /**
     * Generator of random id's
     * for all requests
     * @return random number -
     *         id for some request
     */
    private String generateId() {
        //long idNumber = (long) (new Date().getTime() * Math.random());
        return "" + curId++;
    }

    @Override
    public void init() {

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
        items.add(item);
        return item;
    }

    /**
     * Method return all current
     * requests. Alll not-null
     * request from array of
     * requests
     * @return all current requests
     */
    public List<Item> findAll() {
        return items;
    }

    /**
     * Return array of requests,
     * that has this special name
     * @param name - special name
     * @return array of requests
     *         that has this
     *         special name
     */
    public List<Item> findByName(String name) {
        List<Item> result = new ArrayList<>();
        int currentSize = 0;
        for (Item item : items) {
            if (item.getName().equals(name)) {
                result.add(item);
            }
        }
        return result;
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
        int index = indexOf(id);
        return index == -1 ? null : items.get(index);
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
        for (int index = 0; index < items.size(); ++index) {
            if (items.get(index).getId().equals(id)) {
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
    public boolean replace(String id, Item item) {
        boolean result = false;
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items.set(index, item);
            result = true;
        }
        return result;
    }

    /**
     * Method delete request
     * with id "id"
     * @param id - id of the request
     *             that we should delete
     */
    public boolean delete(String id) {
        boolean result = false;
        int index = indexOf(id);
        if (index != -1) {
            items.remove(index);
            result = true;
        }
        return result;
    }

    @Override
    public void close() {

    }
}
