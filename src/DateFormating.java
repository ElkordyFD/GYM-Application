package src;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class DateFormating {
    public static String dateFormatMonth(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM");
        String newDateFormate = date.format(formatter);
        return newDateFormate;
    }
    public static String dateFormatMonthYear(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-yyyy");
        String newDateFormate = date.format(formatter);
        return newDateFormate;
    }
    public static String dateFormatDayMonth(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM");
        String newDateFormate = date.format(formatter);
        return newDateFormate;
    }
}
