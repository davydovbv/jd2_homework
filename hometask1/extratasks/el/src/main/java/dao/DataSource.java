package dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

    public  DataSource() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
    }
    protected Connection getConnection() throws SQLException {

        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/artistbase", "postgres", "awdqse123");
    }

}
