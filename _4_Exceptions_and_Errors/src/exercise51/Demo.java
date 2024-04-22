package exercise51;

import java.time.DateTimeException;
import java.time.format.DateTimeParseException;

class Demo {
    public  static boolean isLeap(String dateString) {
        if (checkFormatString(dateString) && checkNumberString(dateString)) {
            return checkLeapYear(getYearFromString(dateString));
        }
        return false;
    }

    public static void main(String[] args) {
        for (String arg : args) {
            try {
                System.out.println(isLeap(arg));
            } catch(DateTimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private static int getYearFromString(String dateString) {

        String[] splitedData = dateString.split("/");
        return Integer.parseInt(splitedData[2]);
    }
    private static boolean checkLeapYear(int year) {
        boolean isLeap;
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    isLeap = true;
                } else {
                    isLeap = false;
                }
            } else {
                isLeap = true;
            }
        } else {
            isLeap = false;
        }
        return isLeap;
    }
    private static boolean checkNumberString(String dateString) {
        String[] splitedDate = dateString.split("/");
        int day = Integer.parseInt(splitedDate[0]);
        int month = Integer.parseInt(splitedDate[1]);
        int year = Integer.parseInt(splitedDate[2]);
        if (day < 10 && splitedDate[0].length() < 2) {
            throwError(dateString, 0);
        }
        if (day > 30) {
            throwError(dateString, 0);
        }
        if (day == 0) {
            throwError(dateString, 0);
        }
        if (month < 10 && splitedDate[1].length() < 2) {
            throwError(dateString, 3);
        }
        if (month > 12) {
            throwError(dateString, 3);
        }
        if (year < 1000) {
            throwError(dateString, 6);
        }
        return true;
    }
    private static boolean checkFormatString(String dateString) {
        if(dateString.charAt(1) == '/') {
            throwError(dateString, 0);
        }
        if (dateString.charAt(2) != '/') {
            throwError(dateString, 2);
        }   else if(dateString.charAt(5) != '/') {
            throwError(dateString, 5);
        }
        return true;
    }
    private static void throwError(String dateString, int index) {
        throw new DateTimeParseException(dateString + ": The illegal sequence begins with the character '" + dateString.charAt(index) + "' at index " + index, dateString,  0);
    }
}
