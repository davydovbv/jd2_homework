import dao.ExpensesDao;
import dto.SumOfExpensesOnDateWithBiggestExpenseDto;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            ExpensesDao expensesDao = new ExpensesDao();
            System.out.println("|Receivers| SUM |");
            expensesDao.getReceiversWithExpenses().forEach(e -> System.out.println(e.toString()));
            System.out.println("\n");
            SumOfExpensesOnDateWithBiggestExpenseDto sum = expensesDao.getSumOfExpensesOnDateWithBiggestExpense();
            System.out.println(sum.toString());
            double expense = expensesDao.getBiggestExpenseForDayWithBiggestSum();
            System.out.println("\nBiggestExpenseForDayWithBiggestSum - " + expense);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
