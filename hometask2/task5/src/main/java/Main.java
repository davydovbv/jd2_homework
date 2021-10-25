import dao.ReceiverDao;
import exceptions.ArgumentsException;
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
            if( args.length > 1) {
                expensesDao.addNewExpense(CommandLineArgumentsProcessor.processToExpenseDto(args));
            }
            InteractiveMenu.run();
            System.out.println("|id| paydate |receiver|value|");
            expensesDao.getAllExpenses().forEach(e -> {
                System.out.println(e.toString());
            });
        } catch (ClassNotFoundException | ArgumentsException | SQLException | ParseException e) {
            System.out.println(e.getMessage());
        }
    }
}
