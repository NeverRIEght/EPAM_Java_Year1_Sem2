package section2.exercise2;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int h0 = sc.nextInt();
            int m0 = sc.nextInt();
            int s0 = sc.nextInt();
            int h1 = sc.nextInt();
            int m1 = sc.nextInt();
            int s1 = sc.nextInt();

            Watch watch = new Watch(h0, m0, s0);
            System.out.print(watch + " ");
            watch.update(h1, m1, s1);
            System.out.print(watch);
        }

        //some hidden verification code here in which all methods are called

    }
}
