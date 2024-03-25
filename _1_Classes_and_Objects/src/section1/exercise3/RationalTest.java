package section1.exercise3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RationalTest {

    private static Rational r1;
    private static Rational r2;

    @Test
    void addTest() {
        String input = "2 3 1 2 +";
        String[] values = input.split(" ");

        r1 = new Rational(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
        r2 = new Rational(Integer.parseInt(values[2]), Integer.parseInt(values[3]));

        assertEquals(r1.add(r2).toString(), new Rational(7, 6).toString());

        input = "-1 2 5 8 +";
        values = input.split(" ");

        r1 = new Rational(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
        r2 = new Rational(Integer.parseInt(values[2]), Integer.parseInt(values[3]));

        assertEquals(r1.add(r2).toString(), new Rational(1, 8).toString());

        input = "2 15 -25 12 +";
        values = input.split(" ");

        r1 = new Rational(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
        r2 = new Rational(Integer.parseInt(values[2]), Integer.parseInt(values[3]));

        assertEquals(r1.add(r2).toString(), new Rational(-39, 20).toString());
    }

    @Test
    void subTest() {
        String input = "5 8 3 4 -";
        String[] values = input.split(" ");

        r1 = new Rational(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
        r2 = new Rational(Integer.parseInt(values[2]), Integer.parseInt(values[3]));

        assertEquals(r1.sub(r2).toString(), new Rational(-1, 8).toString());

        input = "3 1 0 4 -";
        values = input.split(" ");

        r1 = new Rational(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
        r2 = new Rational(Integer.parseInt(values[2]), Integer.parseInt(values[3]));

        assertEquals(r1.sub(r2).toString(), new Rational(3, 1).toString());
    }

    @Test
    void mulTest() {
        String input = "2 1 -1 2 *";
        String[] values = input.split(" ");

        r1 = new Rational(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
        r2 = new Rational(Integer.parseInt(values[2]), Integer.parseInt(values[3]));

        assertEquals(r1.mul(r2).toString(), new Rational(-1, 1).toString());

        input = "15 50 250 8 *";
        values = input.split(" ");

        r1 = new Rational(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
        r2 = new Rational(Integer.parseInt(values[2]), Integer.parseInt(values[3]));

        assertEquals(r1.mul(r2).toString(), new Rational(9 * 8 + 3, 8).toString());

        input = "1 2 0 1 *";
        values = input.split(" ");

        r1 = new Rational(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
        r2 = new Rational(Integer.parseInt(values[2]), Integer.parseInt(values[3]));

        assertEquals(r1.mul(r2).toString(), new Rational(0, 1).toString());
    }

    @Test
    void divTest() {
        String input = "12 56 10 28 /";
        String[] values = input.split(" ");

        r1 = new Rational(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
        r2 = new Rational(Integer.parseInt(values[2]), Integer.parseInt(values[3]));

        assertEquals(r1.div(r2).toString(), new Rational(3, 5).toString());
    }

    @Test
    void toStringTest() {
        Rational r = new Rational(3, 5);
        assertEquals(r.toString(), "3/5");

        r = new Rational(0, 1);
        assertEquals(r.toString(), "0");

        r = new Rational(-2, 1);
        assertEquals(r.toString(), "-2");

        r = new Rational(-1, 5);
        assertEquals(r.toString(), "-1/5");

        r = new Rational(7, 3);
        assertEquals(r.toString(), "2 1/3");

        r = new Rational(-15, 2);
        assertEquals(r.toString(), "-7 1/2");
    }
}