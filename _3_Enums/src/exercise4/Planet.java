package exercise4;

enum Planet {
    MERCURY(0.39),
    VENUS(0.72),
    EARTH(1.0),
    MARS(1.52),
    JUPITER(5.2),
    SATURN(9.58),
    URANUS(19.18),
    NEPTUNE(30.07);

    private double distanceFromSun;

    private Planet(double distanceFromSun) {
        this.distanceFromSun = distanceFromSun;
    }

    public double getDistanceFromSun() {
        return this.distanceFromSun;
    }

    public static double distanceBetween(Planet p1, Planet p2) {
        return Math.abs(p1.distanceFromSun - p2.distanceFromSun);
    }
}

class Demo {

    public static void main(String[] args) {
        for (String arg : args) {
            String[] pair = arg.split("-");
            String planetNameA = pair[0];
            String planetNameB = pair[1];

            // TODO: Add your implementation here.
            Planet planetA = Planet.valueOf(planetNameA);
            Planet planetB = Planet.valueOf(planetNameB);
            double distanceFromSunToPlanetA = planetA.getDistanceFromSun();;
            double distanceFromSunToPlanetB = planetB.getDistanceFromSun();;
            double distanceBetween = Planet.distanceBetween(planetA, planetB);

            //do noy change the next line
            System.out.format("%.2f %.2f %.2f%n", distanceFromSunToPlanetA, distanceFromSunToPlanetB, distanceBetween);
        }
    }

}

