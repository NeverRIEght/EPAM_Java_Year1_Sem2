package section3.exercise5;

interface UpdateOnCondition {
    boolean check();
    void update();
}

class Single implements UpdateOnCondition {
    private double x;

    public Single(double x) {
        this.x = Math.max(x, 0.0);
    }

    @Override
    public boolean check() {
        return x <= 0.0;
    }

    @Override
    public void update() {
        x = 0.0;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [x=" + x + "]";
    }
}

class Pair implements UpdateOnCondition {
    private int a;
    private int b;

    public Pair(int a, int b) {
        this.a = Math.max(a, b);
        this.b = Math.min(a, b);
    }

    @Override
    public boolean check() {
        return a < b;
    }

    @Override
    public void update() {
        a = a + b;
        b = a - b;
        a = a - b;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [a=" + a + ", b=" + b + "]";
    }
}