package section2.exercise3;

final class Material {
    //declare private instance constants: name and density
    private final String name;

    private final double density;

    //declare and implement the parameterized constructor
    public Material(String name, double density) {
        this.name = name;
        this.density = density;
    }

    //declare getters and implement them
    public String getName() {
        return name;
    }

    public double getDensity() {
        return density;
    }

    //do not change the toString() code
    @Override
    public String toString() {
        return String.format("%s;%.1f", name, density);
    }
}




