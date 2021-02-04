package ru.job4j.tracker.store;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import ru.job4j.tracker.model.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Hibernate store
 * for {@code Item} model objects,
 * that implements
 * {@code Store} interface
 *
 * @author Egor Geraskin(yegeraskin13@gmail.com)
 * @version 1.0
 * @since 24.01.2021
 */
public class HibernateTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry =
            new StandardServiceRegistryBuilder().configure().build();
    private final SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();

    @Override
    public void init() {

    }

    /**
     * Add item to store,
     * using Hibernate's
     * session.
     *
     * @param item - new {@code Item} model's
     *               object, that we add to
     *               database Hibernate store
     * @return same item, with defined id
     */
    @Override
    public Item add(Item item) {
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(item);
            transaction.commit();
        }
        return item;
    }

    /**
     * Update item with
     * defined id in
     * Hibernate stores's
     * database.
     *
     * @param id - id of item, that
     *             will be updated.
     * @param item - new instance of
     *               item with given
     *               id
     * @return    true - if updated successfully,
     *            false - otherwise
     */
    @Override
    public boolean replace(Integer id, Item item) {
        boolean result = true;
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            item.setId(id);
            if (session.get(Item.class, id) != null) {
                session.update(item);
            } else {
                result = false;
            }
            transaction.commit();
        }
        return result;
    }

    /**
     * Delete item with
     * defined id from
     * Hibernate's database
     * store.
     *
     * @param id - id of item
     * @return true - if such item existed in db
     *                and was successfully
     *                deleted
     *         false - otherwise
     */
    @Override
    public boolean delete(Integer id) {
        boolean result = true;
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            if (session.get(Item.class, id) != null) {
                session.delete(new Item(id));
            } else {
                result = false;
            }
            transaction.commit();
        }
        return result;
    }

    /**
     * Collects all items from
     * Hibernate's database store
     * and return it
     *
     * @return all items
     */
    @Override
    public List<Item> findAll() {
        List<Item> result;
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            result = session.createQuery("from ru.job4j.tracker.model.Item").list();
            transaction.commit();
        }
        return result;
    }

    /**
     * Find item with such name
     * in Hibernate store's
     * database and return it
     * @param name - name of item
     * @return true - if item with such
     *                name exist in
     *                database
     *         false - otherwise
     */
    @Override
    public List<Item> findByName(String name) {
        List<Item> result;
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("from ru.job4j.tracker.model.Item where name = :paramName");
            query.setParameter("paramName", name);
            result = query.list();
            transaction.commit();
        }
        return result;
    }

    /**
     * Find item with such id
     * in Hibernate store's
     * database and return it
     * @param id - id of item
     * @return true - if item with such
     *                id exist in
     *                database
     *         false - otherwise
     */
    @Override
    public Item findById(Integer id) {
        Item result;
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            result = session.get(Item.class, id);
            transaction.commit();
        }
        return result;
    }

    /**
     * Destroy registry object.
     */
    @Override
    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
