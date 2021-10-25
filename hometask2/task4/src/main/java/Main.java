import dao.ReceiverDao;
import exceptions.ConsoleArgumentsException;
import dao.ExpensesDao;
import utils.CommandLineArgumentsProcessor;

import java.sql.SQLException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) {
        try {
            ReceiverDao receiverDao = new ReceiverDao();
            receiverDao.insertDefaultReceiver();
            ExpensesDao expensesDao = new ExpensesDao();
            expensesDao.addNewExpense(CommandLineArgumentsProcessor.processToExpenseDto(args));
            System.out.println("|id| paydate |receiver|value|");
            expensesDao.getAllExpenses().forEach(e -> {
                System.out.println(e.toString());
            });
        } catch (ClassNotFoundException | ConsoleArgumentsException | SQLException | ParseException e) {
            System.out.println(e.getMessage());
        }
    }
}
