package utils;

import dao.ReceiverDao;

import java.sql.SQLException;
import java.util.regex.Pattern;

public class Validator {

    public static boolean validateDate(String date) {
        return date.matches("((([0-9][0-9][0-9][1-9])|([1-9][0-9][0-9][0-9])|([0-9][1-9]" +
                "[0-9][0-9])|([0-9][0-9][1-9][0-9]))-((0[13578])|(1[02]))-((0[1-9])|([12][0-9])|(3[01])))|((([0-9][0-9]" +
                "[0-9][1-9])|([1-9][0-9][0-9][0-9])|([0-9][1-9][0-9][0-9])|([0-9][0-9][1-9][0-9]))-((0[469])|11)" +
                "-((0[1-9])|([12][0-9])|(30)))|(((000[48])|([0-9]0-9)|([0-9][1-9][02468][048])|([1-9][0-9][02468][048]))" +
                "-02-((0[1-9])|([12][0-9])))|((([0-9][0-9][0-9][1-9])|([1-9][0-9][0-9][0-9])|([0-9][1-9][0-9][0-9])|" +
                "([0-9][0-9][1-9][0-9]))-02-((0[1-9])|([1][0-9])|([2][0-8])))");
    }

    public static boolean validateReceiver(int id) throws SQLException, ClassNotFoundException {
        ReceiverDao receiverDao = new ReceiverDao();
        return (receiverDao.getReceiversId().containsKey(id));
    }

    public static boolean validateValue(double value) {
        return value > 0;
    }

}
