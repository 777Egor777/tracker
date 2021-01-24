package ru.job4j.tracker.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Business model of the request
 * @author Egor Geraskin (yegeraskin13@gmail.com)
 * @version 1.0, 14.03.2020
 */
@Entity
@Table(name = "items")
public class Item {
    /**
     * Id of the request
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Name of the request
     */
    private String name;

    private String description;
    private Timestamp created;

    public Item() {
    }

    /**
     * Standard constructor
     * that set only one field
     * this.name
     * @param name - new value of the
     *               field this.name
     */
    public Item(String name) {
        this.name = name;
    }

    public Item(Integer id) {
        this.id = id;
    }

    public Item(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Item(String name, String description, Timestamp created) {
        this.name = name;
        this.description = description;
        this.created = created;
    }

    public Item of(Object obj) {
        Item result = new Item(-1, "");
        if (obj != null && obj.getClass() == getClass()) {
            result = (Item) obj;
        }
        return result;
    }

    /**
     * Getter for this.id
     * @return this.id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Setter for this id
     * @param id - New value of this.id
     */
    public void setId(Integer id) {
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

    public String getDescription() {
        return description;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
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
