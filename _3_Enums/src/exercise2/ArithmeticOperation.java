package exercise2;

enum ArithmeticOperation {
    ADDITION {
        public double apply(double x, double y) {
            return x + y;
        }
    },
    SUBTRACTION {
        public double apply(double x, double y) {
            return x - y;
        }
    },
    MULTIPLICATION {
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVISION {
        public double apply(double x, double y) {
            return x / y;
        }
    };

    public abstract double apply(double x, double y);
}

class Demo {

    public static void main(String[] args) {
        for (String arg : args) {
            String[] pair = arg.split(",");
            double a = Double.parseDouble(pair[0]);
            double b = Double.parseDouble(pair[1]);
            String operationName = pair[2];

            ArithmeticOperation op = ArithmeticOperation.valueOf(operationName);
            double result = op.apply(a, b);

            //do not change the next line
            System.out.println(a + ", " + b + ", " + op + ": " + result);
        }
    }

}

