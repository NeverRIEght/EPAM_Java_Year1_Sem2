package section1.exercise2;

class Pair {
    private int a;
    private int b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;

        if(obj.getClass().equals(Pair.class) || obj.getClass().equals(ColoredPair.class)) {
            Pair objPair = (Pair) obj;
            if (this.a == objPair.a && this.b == objPair.b) {
                result = true;
            } else if (this.a == objPair.b) {
                result = true;
            } else if (this.b == objPair.a) {
                result = true;
            }
        }

        return result;
    }
}

