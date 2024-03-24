package exercise3;

import java.util.Scanner;

class Solution {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            int p1 = sc.nextInt();
            int q1 = sc.nextInt();
            int p2 = sc.nextInt();
            int q2 = sc.nextInt();
            char op = sc.next().charAt(0);


//            String input = "12 56 10 28 /";
//            String[] values = input.split(" ");
//
//            int p1 = Integer.parseInt(values[0]);
//            int q1 = Integer.parseInt(values[1]);
//            int p2 = Integer.parseInt(values[2]);
//            int q2 = Integer.parseInt(values[3]);
//            char op = values[4].charAt(0);


            Rational r1 = new Rational(p1, q1);
            Rational r2 = new Rational(p2, q2);

            Rational result;
            switch (op) {
                case '+' -> result = r1.add(r2);
                case '-' -> result = r1.sub(r2);
                case '*' -> result = r1.mul(r2);
                case '/' -> result = r1.div(r2);
                default -> throw new RuntimeException("Operation is not defined");
            }

            System.out.println(result);
        }
    }
}
