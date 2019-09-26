package ua.planetakino.helper;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Interval;

/**
 * The class {@code DateHelper} converts String to a DataTime object and asserts that
 * the date is within the specific range
 * @author Daria Ivanova
 */
public class DateHelper {

    /** The method counts the range from the current date
     * and checks whether the given date is in the range*/
    public boolean isThisDateWithinRange(DateTime dateToValidate, int dayRange) {
        DateTimeZone timeZone = DateTimeZone.forID("Europe/Kiev");
        DateTime now = DateTime.now(timeZone);

        DateTime startDate;
        if (dayRange == 1) {
            startDate = now.plusDays(1).withTimeAtStartOfDay();
            dayRange = 0;
        } else {
            startDate = now.withTimeAtStartOfDay();
        }
        DateTime endDate = startDate.plusDays(dayRange + 1).withTimeAtStartOfDay();
        Interval interval = new Interval(startDate, endDate);

        return interval.contains(dateToValidate);
    }

    /** Date in String format is being converted to a DateTime object */
    public DateTime dateConverter(String date) {
        date = date.trim();
        int spaceIndex = date.indexOf(" ");
        int comaIndex = date.indexOf(",");
        String day = date.substring(0, spaceIndex);
        String month = date.substring(spaceIndex, comaIndex).trim();
        DateTime convertedDate = new DateTime(new DateTime().year().get(), monthConverter(month), Integer.parseInt(day), 12, 0, 0, 0);
        return convertedDate;
    }

    private int monthConverter(String month) {
        switch (month) {
            case "січня":
                return 1;
            case "лютого":
                return 2;
            case "березня":
                return 3;
            case "квітня":
                return 4;
            case "травня":
                return 5;
            case "червня":
                return 6;
            case "липня":
                return 7;
            case "серпня":
                return 8;
            case "вересня":
                return 9;
            case "жовтня":
                return 10;
            case "листопада":
                return 11;
            case "грудня":
                return 12;
            default:
                return 0;
        }
    }
}

