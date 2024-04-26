package exercise1;

import java.util.Scanner;

//Declare a generic class Pair with two type parameters A and B
class Pair <A, B> {
    //declare two private fields: a of the type A and b of the type B
    private A a;
    private B b;
    //declare a coonstructor
    public Pair(A a, B b) {
        if ((a instanceof Integer || a instanceof String) &&
                (b instanceof Integer || b instanceof String)) {
            this.a = a;
            this.b = b;
        } else {
            throw new ClassCastException();
        }
    }

    //do not change the toString method
    @Override
    public String toString() {
        return "Pair [a=" + a + ", b=" + b + "]";
    }
}

class Solution {
    //put the getPair(Scanner sc) method here
    static Pair<?, ?> getPair(Scanner sc) {
        return new Pair<>(sc.next(), sc.next());
    }
}




