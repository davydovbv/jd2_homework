package dao;

import dto.ExpenseDto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ExpensesDao {
    DataSource dataSource;

    public ExpensesDao() throws ClassNotFoundException {
        this.dataSource = new DataSource();
    }

    public void addNewExpense(ExpenseDto expenseDto) throws SQLException {
        Connection connection = dataSource.getConnection();
        String query = "INSERT INTO expenses(paydate, receiver, value) VALUES ('" + expenseDto.getDate() + "', " +
                expenseDto.getReceiver() + ", " + expenseDto.getValue() + ")";
        Statement st = connection.createStatement();
        st.executeUpdate(query);
    }

    public List<ExpenseDto> getAllExpenses() throws SQLException {
        Connection connection = dataSource.getConnection();
        String query = "SELECT* FROM expenses";
        ResultSet resultSet = connection.createStatement().executeQuery(query);
        List<ExpenseDto> list = new ArrayList<>();
        while (resultSet.next()) {
            ExpenseDto expenseDto = new ExpenseDto(resultSet.getInt("id"), resultSet.getString("paydate"),
                    resultSet.getInt("receiver"), resultSet.getDouble("value"));
            list.add(expenseDto);
        }
        return list;
    }

}
