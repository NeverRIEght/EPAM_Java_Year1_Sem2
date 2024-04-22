package exercise3;

class Thermometer {
    private int temperature;

    public Thermometer(String initTemperature) {
        try {
            this.temperature = Integer.parseInt(initTemperature);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(initTemperature + " is not an integer");
        }
    }

    @Override
    public String toString() {
        return String.valueOf(temperature);
    }
}

class Demo {
    public static void main(String[] args) {
        for (String arg : args) {
            try {
                Thermometer thermometer = new Thermometer(arg);
                System.out.println(thermometer);
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}