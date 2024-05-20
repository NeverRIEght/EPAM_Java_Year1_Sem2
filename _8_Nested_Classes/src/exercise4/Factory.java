package src.exercise4;

class Factory {
    static Greeter englishGreeter() {
        return new Greeter() {
            @Override
            String greet(String name) {
                return "Good Afternoon " + name + "!";
            }
        };
    }

    static Greeter germanGreeter() {
        return new Greeter() {
            @Override
            String greet(String name) {
                return "Guten tag " + name + "!";
            }
        };
    }
}

abstract class Greeter {
    abstract String greet(String name);
}

class Main {
    public static void main(String[] args) {
        //some hidden verification code here
        try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {
            String[] parts = scanner.nextLine().split("/");
            String language = parts[0];
            String greeting =
                    switch (language) {
                        case "english" -> Factory.englishGreeter().greet(parts[1]);
                        case "german" -> Factory.germanGreeter().greet(parts[1]);
                        default -> throw new UnsupportedOperationException("Unsupported language " + language);
                    };
            System.out.println(greeting);
        }
    }
}