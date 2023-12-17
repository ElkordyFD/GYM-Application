package src;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class DateFormating {
    public static String dateFormatMonth(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM");
        String newDateFormat = date.format(formatter);
        return newDateFormat;
    }
    public static String dateFormatMonthYear(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-yyyy");
        String newDateFormat = date.format(formatter);
        return newDateFormat;
    }
    public static String dateFormatDayMonth(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM");
        String newDateFormat = date.format(formatter);
        return newDateFormat;
    }
}
