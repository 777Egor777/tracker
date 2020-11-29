package ru.job4j.tracker;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {
    private Connection cn;
    private int currentMaxId = 0;

    public SqlTracker() {
        init();
    }

    @Override
    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
            createTable();
        } catch (Exception ex) {
            throw new IllegalStateException(ex);
        }
    }

    @Override
    public Item add(Item item) {
        try (Statement st = cn.createStatement()) {
            String insertQuery =
                    String.format("insert into items(name) values(\'%s\');", item.getName());
            st.executeUpdate(insertQuery);
            addQueryToFile(insertQuery);
            setCurrentMaxId();
            item.setId(""+(currentMaxId));
        } catch (Exception ex) {
            throw new IllegalStateException("Exception when adding Item", ex);
        }
        return item;
    }

    @Override
    public boolean replace(String id, Item item) {
        boolean result = false;
        try (Statement st = cn.createStatement()) {
            int itemId = Integer.parseInt(id);
            if (idExist(itemId)) {
                String updQuery = String.format("update items set name=\'%s\' where id=%d;", item.getName(), itemId);
                st.executeUpdate(updQuery);
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
        try (Statement st = cn.createStatement()) {
            int itemId = Integer.parseInt(id);
            if (idExist(itemId)) {
                String delQuery = String.format("delete from items where id=%d;", itemId);
                st.executeUpdate(delQuery);
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
        try (Statement st = cn.createStatement()) {
            ResultSet rs = st.executeQuery("select * from items");
            while (rs.next()) {
                result.add(new Item(""+rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException throwable) {
            throw new IllegalStateException("Exception when getting Item list", throwable);
        }
        return result;
    }

    @Override
    public List<Item> findByName(String name) {
        List<Item> result = new ArrayList<>();
        try (Statement st = cn.createStatement()) {
            ResultSet rs = st.executeQuery(String.format("select * from items where name like \'%s\';", name));
            while (rs.next()) {
                result.add(new Item(""+rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException throwable) {
            throw new IllegalStateException("Exception when getting Item list", throwable);
        }
        return result;
    }

    @Override
    public Item findById(String id) {
        Item result = null;
        try (Statement st = cn.createStatement()) {
            int itemId = Integer.parseInt(id);
            ResultSet rs = st.executeQuery(String.format("select * from items where id=%d;", itemId));
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

    private void createTable() throws Exception {
        if (isTableCreated()) {
            return;
        }
        try (Statement st = cn.createStatement()) {
            st.executeUpdate(readQueryFromFile());
        } catch (Exception ex) {
            throw new Exception("Table wasn't created");
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

    private void setCurrentMaxId() {
        try (Statement st = cn.createStatement()) {
            String query = "select id from items order by id desc limit 1;";
            try(ResultSet rs = st.executeQuery(query)) {
                if (rs.next()) {
                    currentMaxId = rs.getInt(1);
                }
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } finally {

        }
    }

    private boolean idExist(int id) {
        boolean result = false;
        try (Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(
                     String.format(
                             "select id from items where id=%d;",
                             id
                     )
             )) {
            result = rs.next();
        } catch (Exception ex) {
            throw new IllegalStateException("when id exist checking", ex);
        }
        return result;
    }
}
