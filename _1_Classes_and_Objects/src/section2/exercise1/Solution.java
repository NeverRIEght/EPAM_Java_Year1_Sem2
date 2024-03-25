package section2.exercise1;

import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int a0 = sc.nextInt();
            int b0 = sc.nextInt();
            //put your code here

            Pair pair = Pair.newInstance(a0, b0);
            System.out.println(pair + " " +
                    pair.orderedCopy() + " " +
                    pair.swappedCopy());
        }
    }
}
