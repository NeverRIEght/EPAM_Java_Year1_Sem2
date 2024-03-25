package section2.exercise1;

final class Pair {
    //fields must be the private instance constants
    private final int a;
    private final int b;

    //declare and implement the private parameterized constructor
    private Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    //add modifiers to methods and implement them
    public static Pair newInstance(int a, int b) {
        return new Pair(a, b);
    }

    public Pair orderedCopy() {
        return a <= b ? new Pair(this.a, this.b) : new Pair(this.b, this.a);
    }

    public Pair swappedCopy() {
        return new Pair(this.b, this.a);
    }

    //do not change the toString() code
    @Override
    public String toString() {
        return String.format("%d;%d", a, b);
    }
}