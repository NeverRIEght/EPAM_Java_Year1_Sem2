package section1.exercise2;

class Counter {
    private int state;

    private final static int DOWN_BOUND = 5;

    private final static int UP_BOUND = 10;

    public Counter() {
        this.state = (DOWN_BOUND + UP_BOUND) / 2;
    }

    public Counter(int state) {
        if (state <= DOWN_BOUND) {
            this.state = DOWN_BOUND;
        } else {
            this.state = Math.min(state, UP_BOUND);
        }
    }

    public void inc() {
        if (state >= UP_BOUND) {
            this.state = UP_BOUND;
        } else {
            this.state++;
        }
    }

    public void dec() {
        if (state <= DOWN_BOUND) {
            this.state = DOWN_BOUND;
        } else {
            this.state--;
        }
    }

    public int getState() {
        return this.state;
    }
}