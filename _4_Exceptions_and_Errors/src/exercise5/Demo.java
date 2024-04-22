package exercise5;

import java.time.format.DateTimeParseException;

class Demo {

    public static boolean isLeap(String dateString) {
        int day = 0;
        int month = 0;
        int year = 0;

        try {
            day = Integer.parseInt(dateString.substring(0, 2));
        } catch (NumberFormatException e) {
            throw new DateTimeParseException(dateString,
                    dateString.charAt(0) + "",
                    0);
        }
        if (day <= 0 || day > 31) {
            throw new DateTimeParseException(dateString,
                    dateString.charAt(0) + "",
                    0);
        }

        char firstSlash = dateString.charAt(2);
        if (firstSlash != '/') {
            throw new DateTimeParseException(dateString,
                    firstSlash + "",
                    2);
        }

        try {
            month = Integer.parseInt(dateString.substring(3, 5));
        } catch (NumberFormatException e) {
            throw new DateTimeParseException(dateString,
                    dateString.charAt(3) + "",
                    3);
        }
        if (month <= 0 || month > 12) {
            throw new DateTimeParseException(dateString,
                    dateString.charAt(3) + "",
                    3);
        }

        char secondSlash = dateString.charAt(5);
        if (secondSlash != '/') {
            throw new DateTimeParseException(dateString,
                    secondSlash + "",
                    5);
        }

        try {
            year = Integer.parseInt(dateString.substring(6, 10));
        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
            throw new DateTimeParseException(dateString,
                    dateString.charAt(6) + "",
                    6);
        }
        if (year <= 0 || year > 2024) {
            throw new DateTimeParseException(dateString,
                    dateString.charAt(6) + "",
                    6);
        }

        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        for (String arg : args) {
            try {
                boolean result = Demo.isLeap(arg);
                System.out.println(result);
            } catch (DateTimeParseException e) {
                System.out.println(e.getMessage() +
                        ": The illegal sequence begins with the character '" +
                        e.getParsedString() + "' at index " + e.getErrorIndex());
            }
        }
    }
}