package section1.exercise1;

//add extends in the class header
class Rhombus extends Parallelogram {
    //no fields and methods

    //implement parameterized constructor with super() statement
    public Rhombus(double a, double angle) {
        super(a, a, angle);
    }
}
