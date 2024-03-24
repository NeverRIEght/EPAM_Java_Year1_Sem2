package exercise3;

final class Rational {
    private int p; // numerator
    private int q; // denominator

    private final static int ZEROp = 0;
    private final static int ZEROq = 1;

    public Rational(int p0, int q0) {
        if (p0 == ZEROp) {
            this.p = ZEROp;
            this.q = ZEROq;
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
}
