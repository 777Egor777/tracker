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

    @Override
    public Item add(Item item) {
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(item);
            transaction.commit();
        }
        return null;
    }

    @Override
    public boolean replace(Integer id, Item item) {
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            item.setId(id);
            session.update(item);
            transaction.commit();
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(new Item(id));
            transaction.commit();
        }
        return false;
    }

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

    @Override
    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
