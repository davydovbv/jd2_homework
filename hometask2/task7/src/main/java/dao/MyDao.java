package dao;

import dto.Expense;
import dto.Receiver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MyDao implements Dao{
    private static MyDao INSTANCE = null;
    private DataSource dataSource;

    private MyDao() throws ClassNotFoundException {
        this.dataSource = new DataSource();
    }

    public static MyDao getInstance() throws ClassNotFoundException {
        if (INSTANCE == null) {
            synchronized (MyDao.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MyDao();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public Receiver getReceiver(int num) throws SQLException {
        Connection connection = dataSource.getConnection();
        String query = "SELECT * FROM receivers WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet rs = preparedStatement.executeQuery();
        Receiver receiver = new Receiver();
        if(rs.next()) {
            receiver.setId(rs.getInt("id"));
            receiver.setName(rs.getString("name"));

        }
        preparedStatement.close();
        connection.close();
        return receiver;
    }

    @Override
    public ArrayList<Receiver> getReceivers() throws SQLException {
        Connection connection = dataSource.getConnection();
        String query = "SELECT* FROM receivers";
        ResultSet resultSet = connection.createStatement().executeQuery(query);
        ArrayList<Receiver> list = new ArrayList<>();
        while (resultSet.next()){
            Receiver receiver = new Receiver();
            receiver.setId(resultSet.getInt("id"));
            receiver.setName(resultSet.getString("name"));
            list.add(receiver);
        }
        return list;
    }

    @Override
    public Expense getExpense(int num) throws SQLException {
        Connection connection = dataSource.getConnection();
        String query = "SELECT * FROM expenses WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet rs = preparedStatement.executeQuery();
        Expense expense = new Expense();
        if(rs.next()) {
            expense.setId(rs.getInt("id"));
            expense.setPaydate(rs.getString("paydate"));
            expense.setReceiver(rs.getInt("receiver"));
            expense.setValue(rs.getDouble("value"));
        }
        preparedStatement.close();
        connection.close();
        return expense;
    }

    @Override
    public ArrayList<Expense> getExpenses() throws SQLException {
        Connection connection = dataSource.getConnection();
        String query = "SELECT* FROM expenses";
        ResultSet resultSet = connection.createStatement().executeQuery(query);
        ArrayList<Expense> list = new ArrayList<>();
        while (resultSet.next()){
            Expense expense = new Expense();
            expense.setId(resultSet.getInt("id"));
            expense.setPaydate(resultSet.getString("paydate"));
            expense.setReceiver(resultSet.getInt("receiver"));
            expense.setValue(resultSet.getDouble("value"));
            list.add(expense);
        }
        return list;
    }

    @Override
    public int addReceiver(Receiver receiver) throws SQLException {

        Connection connection = dataSource.getConnection();
        String query = "INSERT INTO expenses (name) VALUES (?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,receiver.getName());
        int count =  preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        return count;
    }

    @Override
    public int addExpense(Expense expense) throws SQLException {
        Connection connection = dataSource.getConnection();
        String query = "INSERT INTO expenses (paydate, receiver, value) VALUES (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,expense.getPaydate());
        preparedStatement.setInt(2,expense.getReceiver());
        preparedStatement.setDouble(3,expense.getValue());
        int count = preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        return  count;
    }
}
