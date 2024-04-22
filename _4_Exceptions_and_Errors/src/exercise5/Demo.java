package exercise5;

import java.time.DateTimeException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Demo {

    public static boolean isLeap(String dateString) {

//        Pattern datePattern = Pattern.compile("^[0-9]{2}.[0-9]{2}.[0-9]{4}$");
        Pattern datePattern = Pattern.compile("/");
        Matcher dateMatcher = datePattern.matcher(dateString);

        if (!dateMatcher.lookingAt()) {
            throw new DateTimeException("Date is not correct");
        }

        Pattern dayPattern = Pattern.compile("^([0-9]{2})");
        Matcher dayMatcher = dayPattern.matcher(dateString);

        Pattern monthPattern = Pattern.compile("\\/([0-9]{2})\\/");
        Matcher monthMatcher = monthPattern.matcher(dateString);

        Pattern yearPattern = Pattern.compile("\\.([0-9]{4})");
        Matcher yearMatcher = yearPattern.matcher(dateString);

        int day;
        int month;
        int year;

        if (dayMatcher.lookingAt()) {
            day = Integer.parseInt(dayMatcher.group(1));
            System.out.println(day);
        }

        if (monthMatcher.lookingAt()) {
            month = Integer.parseInt(monthMatcher.group(1));
            System.out.println(month);
        }

        if (yearMatcher.lookingAt()) {
            year = Integer.parseInt(yearMatcher.group(1));
            System.out.println(year);
        }

        return true;
    }

    public static void main(String[] args) {
//        for (String arg : args) {
//
//        }

        isLeap("20/05/2014");
    }

}
