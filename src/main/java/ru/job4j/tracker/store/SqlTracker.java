package ru.job4j.tracker.store;

import ru.job4j.tracker.model.Item;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of
 * {@code Store} interface,
 * based on Postgresql+JDBC.
 *
 * @author Geraskin Egor (yegeraskin13@gmail.com)
 * @version 1.0
 */
public class SqlTracker implements Store {
    /**
     * Connection to database
     */
    private final Connection cn;

    /**
     * Constructor.
     * @param cn - init value of
     *             {@code cn} field
     */
    public SqlTracker(Connection cn) {
        this.cn = cn;
        init();
    }

    /**
     * Init method.
     * Create table
     * of items, if
     * it doesn't
     * exist yet.
     */
    @Override
    public void init() {
        createTable();
    }

    /**
     * Add item to database.
     *
     * @param item - new item to db
     * @return same item, with
     *         generated id by db
     */
    @Override
    public Item add(Item item) {
        try (final PreparedStatement st = cn.prepareStatement(
                "insert into items(name) values(?);",
                Statement.RETURN_GENERATED_KEYS
        )) {
            st.setString(1, item.getName());
            st.executeUpdate();
            try (ResultSet gk = st.getGeneratedKeys()) {
                if (gk.next()) {
                    item.setId(gk.getInt(1));
                    return item;
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        throw new IllegalStateException("Couldn't create new user");
    }

    /**
     * If item with such id
     * exists, replace it
     * with new value.
     *
     * @param id - id of the item,
     *             that we want to
     *             replace.
     * @param item - new value of
     *               replaced item.
     * @return true - if item with such
     *                id exist in db
     *         false - otherwise
     */
    @Override
    public boolean replace(Integer id, Item item) {
        boolean result = false;
        try (PreparedStatement st = cn.prepareStatement("update items set name=? where id=?;")) {
            int itemId = id;
            st.setString(1, item.getName());
            st.setInt(2, itemId);
            String updQuery = String.format("update items set name='%s' where id=%d;", item.getName(), itemId);
            if (st.executeUpdate() > 0) {
                result = true;
            }
        } catch (SQLException throwable) {
            throw new IllegalStateException("Exception when editing Item", throwable);
        }
        return result;
    }

    /**
     * Delete item with
     * given id from
     * database.
     *
     * @param id - id of item, that
     *             we should delete
     * @return true - if item with such
     *                id existed and
     *                was successfully
     *                deleted.
     *         false - otherwise
     */
    @Override
    public boolean delete(Integer id) {
        boolean result = false;
        try (PreparedStatement st = cn.prepareStatement("delete from items where id=?;")) {
            int itemId = id;
            st.setInt(1, itemId);
            String delQuery = String.format("delete from items where id=%d;", itemId);
            if (st.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException throwable) {
            throw new IllegalStateException("Exception when deleting Item", throwable);
        }
        return result;
    }

    /**
     * Extract all items
     * from database and
     * return them as list.
     *
     * @return list of all items
     *         in database.
     */
    @Override
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement st = cn.prepareStatement("select * from items")) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                result.add(new Item(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException throwable) {
            throw new IllegalStateException("Exception when getting Item list", throwable);
        }
        return result;
    }

    /**
     * Excract all items
     * with such name from
     * database and return
     * them as list.
     *
     * @param name - name of items,
     *               that we should
     *               collect and return.
     * @return list of items with
     *         such name.
     */
    @Override
    public List<Item> findByName(String name) {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement st = cn.prepareStatement("select * from items where name like ?;")) {
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                result.add(new Item(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException throwable) {
            throw new IllegalStateException("Exception when getting Item list", throwable);
        }
        return result;
    }

    /**
     * Extract item with
     * such id from database
     *
     * @param id - id of expected
     *             item
     * @return null - if item with
     *         such id doesn't exist.
     *         item - otherwise.
     */
    @Override
    public Item findById(Integer id) {
        Item result = null;
        try (PreparedStatement st = cn.prepareStatement("select * from items where id=?;")) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                result = new Item(rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException throwable) {
            throw new IllegalStateException("Exception when getting Item", throwable);
        }
        return result;
    }

    /**
     * Close connection.
     * @throws Exception
     */
    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    private String readQueryFromFile() throws FileNotFoundException {
        String result;
        try (BufferedReader reader = new BufferedReader(new FileReader("./db/create.sql"))) {
            result = reader.readLine();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File doesn't exist");
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        return result;
    }

    private void createTable() {
        if (isTableCreated()) {
            return;
        }
        try (Statement st = cn.createStatement()) {
            st.executeUpdate(readQueryFromFile());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private boolean isTableCreated() {
        boolean result = false;
        try {
            DatabaseMetaData dbMetaData = cn.getMetaData();
            ResultSet rs = dbMetaData.getTables(null, null, "items", null);
            if (rs.next()) {
                result = true;
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return result;
    }
}
