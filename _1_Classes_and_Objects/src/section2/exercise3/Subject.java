package section2.exercise3;

class Subject {

    //declare private instance fields: name, material, and volume
    private String name;

    private Material material;

    private double volume;

    //declare and implement the parameterized constructor
    public Subject(String name, Material material, double volume) {
        this.name = name;
        this.material = material;
        this.volume = volume;
    }


    //declare getters/setters and implement them
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    //implement the method
    public double getMass() {
        return material.getDensity() * volume;
    }

    //do not change the toString() code
    @Override
    public String toString() {
        return String.format("%s;%s;%.2f;%.1f", name, material, volume, getMass());
    }
}