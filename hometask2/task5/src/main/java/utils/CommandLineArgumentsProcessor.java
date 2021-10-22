package utils;

import exceptions.ConsoleArgumentsException;
import dto.ExpenseDto;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CommandLineArgumentsProcessor {

    public static ExpenseDto processToExpenseDto(String[] arguments) throws ConsoleArgumentsException, SQLException, ClassNotFoundException, ParseException {
        ExpenseDto expenseDto = new ExpenseDto();
        if (arguments.length < 1) {
            throw new ConsoleArgumentsException("No arguments where given! Try again using \" java -jar \"absoluteFilepath\" argument1 argument2 argument3\"");
        }
        if (arguments.length < 3) {
            throw new ConsoleArgumentsException("Not enough arguments where given! Try again using \" java -jar \"absoluteFilepath\" argument1 argument2 argument3");
        } else {
            String date = arguments[0];
            int receiver = Integer.parseInt(arguments[1]);
            double value = Double.parseDouble(arguments[2]);
            if (Validator.validateDate(date)) {
                expenseDto.setDate(date);
            } else {
                throw new ConsoleArgumentsException("Wrong date format! Check if date response yyyy-mm-dd pattern and is real existing date!");
            }
            if (Validator.validateReceiver(receiver)) {
                expenseDto.setReceiver(receiver);
            } else {
                throw new ConsoleArgumentsException("Wrong receiver id! Receiver with this id doesn't exist!");
            }
            if (Validator.validateValue(value)) {
                expenseDto.setValue(value);
            } else {
                throw new ConsoleArgumentsException("Wrong expense value! Expense can't be less than 0!");
            }
        }
        return expenseDto;
    }
}
