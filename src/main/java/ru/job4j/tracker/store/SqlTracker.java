package ru.job4j.tracker.store;

import ru.job4j.tracker.model.Item;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlTracker implements Store {
    private final Connection cn;

    public SqlTracker(Connection cn) {
        this.cn = cn;
        init();
    }

    @Override
    public void init() {
        createTable();
    }

    @Override
    public Item add(Item item) {
        try (final PreparedStatement st = cn.prepareStatement(
                "insert into items(name) values(?);",
                Statement.RETURN_GENERATED_KEYS
        )) {
            st.setString(1, item.getName());
            st.executeUpdate();
            addQueryToFile(String.format("insert into items(name) values('%s');", item.getName()));
            try (ResultSet gk = st.getGeneratedKeys()) {
                if (gk.next()) {
                    item.setId("" + gk.getInt(1));
                    return item;
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        throw new IllegalStateException("Couldn't create new user");
    }

    @Override
    public boolean replace(String id, Item item) {
        boolean result = false;
        try (PreparedStatement st = cn.prepareStatement("update items set name=? where id=?;")) {
            int itemId = Integer.parseInt(id);
            st.setString(1, item.getName());
            st.setInt(2, itemId);
            String updQuery = String.format("update items set name='%s' where id=%d;", item.getName(), itemId);
            if (st.executeUpdate() > 0) {
                addQueryToFile(updQuery);
                result = true;
            }
        } catch (SQLException throwable) {
            throw new IllegalStateException("Exception when editing Item", throwable);
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        try (PreparedStatement st = cn.prepareStatement("delete from items where id=?;")) {
            int itemId = Integer.parseInt(id);
            st.setInt(1, itemId);
            String delQuery = String.format("delete from items where id=%d;", itemId);
            if (st.executeUpdate() > 0) {
                addQueryToFile(delQuery);
                result = true;
            }

        } catch (SQLException throwable) {
            throw new IllegalStateException("Exception when deleting Item", throwable);
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement st = cn.prepareStatement("select * from items")) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                result.add(new Item("" + rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException throwable) {
            throw new IllegalStateException("Exception when getting Item list", throwable);
        }
        return result;
    }

    @Override
    public List<Item> findByName(String name) {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement st = cn.prepareStatement("select * from items where name like ?;")) {
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                result.add(new Item("" + rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException throwable) {
            throw new IllegalStateException("Exception when getting Item list", throwable);
        }
        return result;
    }

    @Override
    public Item findById(String id) {
        Item result = null;
        try (PreparedStatement st = cn.prepareStatement("select * from items where id=?;")) {
            st.setInt(1, Integer.parseInt(id));
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                result = new Item("" + rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException throwable) {
            throw new IllegalStateException("Exception when getting Item", throwable);
        }
        return result;
    }

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

    private void addQueryToFile(String query) {
        try (PrintStream ps = new PrintStream(new FileOutputStream("./db/insert.sql", true))) {
            ps.println(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
