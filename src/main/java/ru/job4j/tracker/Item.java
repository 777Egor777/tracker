package ru.job4j.tracker;

import java.util.Objects;

/**
 * Business model of the request
 * @author Egor Geraskin (yegeraskin13@gmail.com)
 * @version 1.0, 14.03.2020
 */
public class Item {
    /**
     * Id of the request
     */
    private String id;

    /**
     * Name of the request
     */
    private String name;

    /**
     * Standart constructor
     * that set only one field
     * this.name
     * @param name - new value of the
     *               field this.name
     */
    public Item(String name) {
        this.name = name;
    }

    /**
     * Getter for this.id
     * @return this.id
     */
    public String getId() {
        return this.id;
    }

    /**
     * Setter for this id
     * @param id - New value of this.id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter for this.name
     * @return this.name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for this.name
     * @param name - New value of this.name
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj != null && obj.getClass() == getClass()) {
            Item item = (Item) obj;
            result = Objects.equals(id, item.id)
                    && Objects.equals(name, item.name);
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("Item{id='%s', name='%s'}", id, name);
    }
}
