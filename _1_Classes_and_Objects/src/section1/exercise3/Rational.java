package section1.exercise3;

class Rational {
    private final int p; // numerator

    private final int q; // denominator

    public final static Rational ZERO = new Rational(0, 1);

    public Rational(int p0, int q0) {
        if (p0 == 0) {
            this.p = 0;
            this.q = 1;
        } else if (gcd(p0, q0) == 1) {
            this.p = p0;
            this.q = q0;
        } else {
            int fractionGCD = gcd(p0, q0);
            if (Math.abs(fractionGCD) != 1) {
                p0 /= fractionGCD;
                q0 /= fractionGCD;
            }

            this.p = p0;
            this.q = q0;
        }
    }

    private Rational reduceFraction() {
        int p0 = this.p;
        int q0 = this.q;

        int fractionGCD = gcd(p0, q0);
        if (Math.abs(fractionGCD) != 1) {
            p0 /= fractionGCD;
            q0 /= fractionGCD;
        }

        return new Rational(p0, q0);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

    public Rational add(Rational r) {
        Rational result;

        int commonDenominator = lcm(this.q, r.q);

        int p1 = commonDenominator / this.q * this.p;
        int p2 = commonDenominator / r.q * r.p;

        result = new Rational(p1 + p2, commonDenominator);
        result = result.reduceFraction();

        return result;
    }

    public Rational sub(Rational r) {
        Rational result;

        int commonDenominator = lcm(this.q, r.q);

        int p1 = commonDenominator / this.q * this.p;
        int p2 = commonDenominator / r.q * r.p;

        result = new Rational(p1 - p2, commonDenominator);
        result = result.reduceFraction();

        return result;
    }

    public Rational mul(Rational r) {
        Rational result;

        result = new Rational(this.p * r.p, this.q * r.q);
        result = result.reduceFraction();

        return result;
    }

    public Rational div(Rational r) {
        Rational result;

        result = new Rational(this.p * r.q, this.q * r.p);
        result = result.reduceFraction();

        return result;
    }

    @Override
    public String toString() {
        if (p == ZERO.p) {
            return "0";
        }

        boolean sign = p * q >= 0;

        int integerPart = Math.abs(p / q);
        int numerator = Math.abs(p % q);

        String result = "";
        if (integerPart != 0) {
            result += integerPart + " ";
        }

        if (numerator != 0) {
            result += numerator + "/" + Math.abs(q);
        }

        if (!sign) {
            result = "-" + result;
        }

        return result.trim();
    }
}
