package section1.exercise1;

class Parallelogram {
    //declare fields and implement parameterized constructor
    //and two methods for the parallelogram perimeter and area

    protected double a;
    protected double b;
    protected double angle;

    public Parallelogram(double a, double b, double angle) {
        this.a = a;
        this.b = b;
        this.angle = angle;
    }

    protected double perimeter() {
        return (a + b) * 2;
    }
    protected double area() {
        return a * b * Math.sin(angle * Math.PI / 180);
    }
}


