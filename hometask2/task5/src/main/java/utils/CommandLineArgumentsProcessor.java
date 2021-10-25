package utils;

import exceptions.ArgumentsException;
import dto.ExpenseDto;

import java.sql.SQLException;
import java.text.ParseException;

public class CommandLineArgumentsProcessor {

    public static ExpenseDto processToExpenseDto(String[] arguments) throws ArgumentsException, SQLException, ClassNotFoundException, ParseException {
        ExpenseDto expenseDto = new ExpenseDto();
        if (arguments.length < 3) {
            throw new ArgumentsException("Not enough arguments where given! Try again using \" java -jar \"absoluteFilepath\" argument1 argument2 argument3");
        } else {
            String date = arguments[0];
            int receiver = Integer.parseInt(arguments[1]);
            double value = Double.parseDouble(arguments[2]);
            if (Validator.validateDate(date)) {
                expenseDto.setDate(date);
            } else {
                throw new ArgumentsException("Wrong date format! Check if date response yyyy-mm-dd pattern and is real existing date!");
            }
            if (Validator.validateReceiver(receiver)) {
                expenseDto.setReceiver(receiver);
            } else {
                throw new ArgumentsException("Wrong receiver id! Receiver with this id doesn't exist!");
            }
            if (Validator.validateValue(value)) {
                expenseDto.setValue(value);
            } else {
                throw new ArgumentsException("Wrong expense value! Expense can't be less than 0!");
            }
        }
        return expenseDto;
    }
}
