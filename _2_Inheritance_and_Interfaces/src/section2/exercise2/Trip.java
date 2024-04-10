package section2.exercise2;

import java.util.Scanner;

class Trip {
    //declare class and instance constants according to the Java Code Conventions
    private final int dailyRate;
    private final int numberOfDays;
    private final int fare;

    //declare a parameterized constructor
    public Trip(int numberOfDays, int fare) {
        this.dailyRate = 50;
        this.numberOfDays = numberOfDays;
        this.fare = fare;
    }

    public final int totalCost() {
        //write the correct expression instead of 0
        return dailyRate * numberOfDays + fare;
    }

    //add protected method and use it the totalCost()
}

class HomeTrip extends Trip {
    //declare class constant
    private final int dailyRate;

    //declare a parameterized constructor
    public HomeTrip(int numberOfDays) {
        super(numberOfDays, 0);
        this.dailyRate = 60;
    }

    //override the protected method
}

class OneDayTrip extends Trip {
    //declare class constant
    private final int dailyRate;
    //declare a parameterized constructor

    public OneDayTrip(int fare) {
        super(1, fare);
        this.dailyRate = 35;
    }

    //override the protected method

}

class Solution {

    public static Trip getTrip(Scanner sc) {
        int id = sc.nextInt();

        int numberOfDays;
        int fare;

        switch (id) {
            case 1:
                numberOfDays = sc.nextInt();
                return new HomeTrip(numberOfDays);
            case 2:
                fare = sc.nextInt();
                return new OneDayTrip(fare);
            default:
                numberOfDays = sc.nextInt();
                fare = sc.nextInt();
                return new Trip(numberOfDays, fare);
        }
    }
}

