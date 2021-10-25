import dao.ExpensesDao;
import dto.ExpenseDto;
import exceptions.ArgumentsException;
import utils.Validator;

import java.sql.SQLException;
import java.util.Scanner;

public class InteractiveMenu {

    public static void run() throws ArgumentsException, ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean isRun = true;
        while (isRun) {
            String date = null;
            int receiver = 0;
            double value = 0;
            boolean isCorrectDate = false;
            while (!isCorrectDate) {
                System.out.println("\nEnter paydate according to the format yyyy-MM-dd:\n");
                date = scanner.nextLine();
                if (!Validator.validateDate(date)) {
                    System.out.println("Wrong date format! Try again!");
                } else {
                    isCorrectDate = true;
                }
            }
            boolean isCorrectReciver = false;
            while (!isCorrectReciver) {
                try {
                    System.out.println("\nEnter receiver id:\n");
                    receiver = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Wrong number format!");
                }
                if (!Validator.validateReceiver(receiver)) {
                    System.out.println("Receiver doesn't exist! Try again!");
                } else {
                    isCorrectReciver = true;
                }
            }
            boolean isCorrectValue = false;
            while (!isCorrectValue) {
                System.out.println("\nEnter amount of expense:\n");
                try {
                    value = Double.parseDouble(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Wrong number format!");
                }
                if (!Validator.validateValue(value)) {
                    System.out.println("Value can't be less than 1.0 and should be a digit !Try again!");
                } else {
                    isCorrectValue = true;
                }
            }
            ExpensesDao expensesDao = new ExpensesDao();
            if (date != null && receiver != 0 && value != 0)
                expensesDao.addNewExpense(new ExpenseDto(date, receiver, value));
            System.out.println("\nWould you like to continue y/n ?");
            String continueWorking = scanner.nextLine();
            isRun = continueWorking.equals("y");
        }
    }
}
