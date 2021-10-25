package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ReceiverDao {
    private DataSource dataSource;

    public ReceiverDao() throws ClassNotFoundException {
        this.dataSource = new DataSource();
    }

    public Map<Integer, String> getReceiversId() throws SQLException {
        Connection connection = dataSource.getConnection();
        ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM receivers");
        Map<Integer, String> receivers = new HashMap<>();
        while (resultSet.next()) {
            receivers.put(resultSet.getInt("id"), resultSet.getString("name"));
        }
        resultSet.close();
        connection.close();
        return receivers;
    }

    public void insertDefaultReceiver() throws SQLException {
        Connection connection = dataSource.getConnection();
        ResultSet resultSet = connection.createStatement().executeQuery("SELECT COUNT(*) AS 'lines' FROM receivers ");
        if (resultSet.next()) {
            int rows = resultSet.getInt("lines");
            if (rows == 0) {
                connection.createStatement().executeUpdate("INSERT INTO receivers (name) VALUES ('DEFAULT_RECEIVER')");
            }
        }
    }
}
