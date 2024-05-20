package src.exercise2;

class Car {
    public class Engine {
        private final String type;
        private final int horsepower;

        public Engine(String type, int horsepower) {
            this.type = type;
            this.horsepower = horsepower;
        }

        public String getType() {
            return type;
        }

        public int getHorsepower() {
            return horsepower;
        }
    }

    private final String model;
    private final int year;

    public Car(String model, int year) {
        this.model = model;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }
}

class Executor {
    public static Car createCar(String model, int year) {
        return new Car(model, year);
    }

    public static Car.Engine createEngine(Car car, String type, int horsepower) {
        return car.new Engine(type, horsepower);
    }
}