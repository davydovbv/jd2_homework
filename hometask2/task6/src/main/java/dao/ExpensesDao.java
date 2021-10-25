package dao;

import dto.ExpenseDto;
import dto.ExpensesWithReceiversDto;
import dto.SumOfExpensesOnDateWithBiggestExpenseDto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ExpensesDao {
    DataSource dataSource;

    public ExpensesDao() throws ClassNotFoundException {
        this.dataSource = new DataSource();
    }

    public SumOfExpensesOnDateWithBiggestExpenseDto getSumOfExpensesOnDateWithBiggestExpense() throws SQLException {
        Connection connection = dataSource.getConnection();
        String query = "SELECT paydate, SUM(value) as S " +
                "FROM expenses " +
                "WHERE paydate IN (SELECT paydate " +
                "                 FROM expenses " +
                "                 WHERE value = (SELECT MAX(value) FROM expenses)) " +
                "GROUP BY paydate";
        ResultSet resultSet = connection.createStatement().executeQuery(query);
        SumOfExpensesOnDateWithBiggestExpenseDto sum = new SumOfExpensesOnDateWithBiggestExpenseDto();
        if (resultSet.next()) {
            sum.setPaydate(resultSet.getString("paydate"));
            sum.setSumOfExpenses(resultSet.getDouble("S"));
        }
        connection.close();
        return sum;
    }

    public List<ExpensesWithReceiversDto> getReceiversWithExpenses() throws SQLException {
        Connection connection = dataSource.getConnection();
        String query = "SELECT name, SUM(value) AS S " +
                "FROM receivers r, expenses e " +
                "WHERE r.id = e.receiver " +
                "GROUP BY name";
        ResultSet resultSet = connection.createStatement().executeQuery(query);
        List<ExpensesWithReceiversDto> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(new ExpensesWithReceiversDto(resultSet.getString("name"),resultSet.getDouble("S")));
        }
        connection.close();
        return list;
    }

    public double getBiggestExpenseForDayWithBiggestSum() throws SQLException {
        Connection connection = dataSource.getConnection();
        String query = "SELECT result.m AS 'MAX AMOUNT OF EXPENSE' " +
                "FROM (SELECT paydate, SUM(value) as s, MAX(value) as m " +
                "      FROM expenses " +
                "      GROUP BY paydate) result " +
                "WHERE result.s IN (" +
                "    SELECT max(s) " +
                "    FROM (SELECT sum(value) AS s " +
                "          FROM expenses " +
                "          GROUP BY paydate) maxSum)";
        ResultSet resultSet = connection.createStatement().executeQuery(query);
        double expense = 0;
        if (resultSet.next()) {
            expense = resultSet.getDouble("MAX AMOUNT OF EXPENSE");
        }
        connection.close();
        return expense;
    }

}
