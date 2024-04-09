package exercise1;

class Demo {
    public static boolean isPrime(int n) {
        if (n < 0) {
            throw new IllegalArgumentException(n + " is not a natural number");
        }

        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        for (String arg : args) {
            try {
                boolean isPrime = isPrime(Integer.parseInt(arg));
                System.out.println(isPrime);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
