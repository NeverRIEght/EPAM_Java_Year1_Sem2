package section1.exercise1;

import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            double alpha = sc.nextDouble();

            //Create an array with 4 elements: parallelogram, rectangle, rhombus, square,
            //and initialize them with input values.
            Parallelogram[] parallelogramArray = new Parallelogram[4];
            parallelogramArray[0] = new Parallelogram(a, b, alpha);
            parallelogramArray[1] = new Rectangle(a, b);
            parallelogramArray[2] = new Rhombus(a, alpha);
            parallelogramArray[3] = new Square(a);

            //Calculate the sums of perimeters and areas of the array elements
            double perimetersSum = 0;
            double areasSum = 0;
            for (Parallelogram p : parallelogramArray) {
                perimetersSum += p.perimeter();
                areasSum += p.area();
            }

            //Output them rounded to 3 decimal places throw a space
            System.out.printf("%.3f %.3f", perimetersSum, areasSum);
        }
    }
}
