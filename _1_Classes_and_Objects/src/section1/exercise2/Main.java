package section1.exercise2;

class Main {
    static {
        //some hidden verification code inside this block
    }
    public static void main(String[] args) {
        try (java.util.Scanner sc = new java.util.Scanner(System.in)) {
            int state0 = sc.nextInt();
            Counter counter = state0 < 0 ? new Counter() : new Counter(state0);
            System.out.printf("%d ", counter.getState());
            counter.inc();
            System.out.printf("%d ", counter.getState());
            counter.dec();
            counter.dec();
            System.out.printf("%d", counter.getState());
        }
    }
}
