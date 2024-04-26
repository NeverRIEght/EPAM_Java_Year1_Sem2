package exercise2;

import java.util.Scanner;

//Declare a generic class Mark with a bounded type parameter T
class Mark<T extends Number> {
    //Declare a class constant PASS_GRADE
    public static final int PASS_GRADE = 4;

    //Declare an instance class constant grade
    public final T grade;

    //Declare a constructor
    public Mark(T grade) {
        this.grade = grade;
    }

    //Declare a boolean method isPassed()
    public boolean isPassed() {
        return grade.intValue() >= PASS_GRADE;
    }
}

class Solution {
    //put the method getMark(Scanner sc) here
    public static Mark<? extends Number> getMark(Scanner sc) {
        String input = sc.next();
        double gradeDouble;
        try {
            gradeDouble = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        return new Mark<>(gradeDouble);
    }
}