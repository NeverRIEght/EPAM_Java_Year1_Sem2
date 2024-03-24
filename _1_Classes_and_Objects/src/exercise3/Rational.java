package exercise3;

class Rational {
    private int p; // numerator

    private int q; // denominator

    public final static Rational ZERO = new Rational(0, 1);

    public Rational(int p0, int q0) {
        if (p0 == 0) {
            this.p = 0;
            this.q = 1;
        } else if (gcd(p0, q0) == 1) {
            this.p = p0;
            this.q = q0;
        } else {
            this.p = p0;
            this.q = q0;
            reduceFraction();
        }
    }

    private void reduceFraction() {
        int fractionGCD = gcd(this.p, this.q);
        while (fractionGCD != 1) {
            this.p /= fractionGCD;
            this.q /= fractionGCD;
            fractionGCD = gcd(this.p, this.q);
        }
    }

    private int gcd(int p, int q) {
        return q == 0 ? p : gcd(q, p % q);
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
        result.reduceFraction();

        return result;
    }

    public Rational sub(Rational r) {
        Rational result;

        int commonDenominator = lcm(this.q, r.q);

        int p1 = commonDenominator / this.q * this.p;
        int p2 = commonDenominator / r.q * r.p;

        result = new Rational(p1 - p2, commonDenominator);
        result.reduceFraction();

        return result;
    }

    public Rational mul(Rational r) {
        Rational result;

        result = new Rational(this.p * r.p, this.q * r.q);
        result.reduceFraction();

        return result;
    }

    public Rational div(Rational r) {
        Rational result;

        result = new Rational(this.p * r.q, this.q * r.p);
        result.reduceFraction();

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

        return result;
    }
}
