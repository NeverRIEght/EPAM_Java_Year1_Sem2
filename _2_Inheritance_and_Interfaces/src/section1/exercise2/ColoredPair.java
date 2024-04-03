package section1.exercise2;

class ColoredPair extends Pair {
    final private String color;

    public ColoredPair(int a, int b, String color) {
        super(a, b);
        this.color = color;
    }
}