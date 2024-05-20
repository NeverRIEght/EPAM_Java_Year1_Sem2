package src.exercise3;

import java.util.Scanner;

class MathUtils {
    public static ComplexNumber add(ComplexNumber a, ComplexNumber b) {
        double RealPart = a.getRe() + b.getRe();
        double ImaginePart = a.getIm() + b.getIm();
        return new ComplexNumber(RealPart, ImaginePart);
    }

    public static ComplexNumber multiply(ComplexNumber a, ComplexNumber b) {
        double RealPart = a.getRe() * b.getRe() - a.getIm() * b.getIm();
        double ImaginePart = a.getRe() * b.getIm() + a.getIm() * b.getRe();
        return new ComplexNumber(RealPart, ImaginePart);
    }

    public static ComplexNumber conjugate(ComplexNumber a) {
        return new ComplexNumber(a.getRe(), -a.getIm());
    }

    static class ComplexNumber {
        private double Re;
        private double Im;

        public ComplexNumber(double Re, double Im) {
            this.Re = Re;
            this.Im = Im;
        }

        public double getRe() {
            return this.Re;
        }

        public double getIm() {
            return this.Im;
        }
    }
}

class Executor {    //put your code here
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] commandArgs = input.split("/");
        String cmd = commandArgs[0];
        String[] args1 = commandArgs[1].split(";");
        MathUtils.ComplexNumber complex1;
        try {
            complex1 = new MathUtils.ComplexNumber(Double.parseDouble(args1[0]), Double.parseDouble(args1[1]));
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid arguments format.");
            return;
        }
        MathUtils.ComplexNumber result;
        switch (cmd) {
            case "add":
                String[] args2Add = commandArgs[2].split(";");
                MathUtils.ComplexNumber complex2Add;
                try {
                    complex2Add = new MathUtils.ComplexNumber(Double.parseDouble(args2Add[0]), Double.parseDouble(args2Add[1]));
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid arguments format for add command.");
                    return;
                }
                result = MathUtils.add(complex1, complex2Add);
                System.out.println(result.getRe() + ";" + result.getIm());
                break;
            case "multiply":
                String[] args2Multiply = commandArgs[2].split(";");
                MathUtils.ComplexNumber complex2Multiply;
                try {
                    complex2Multiply = new MathUtils.ComplexNumber(Double.parseDouble(args2Multiply[0]), Double.parseDouble(args2Multiply[1]));
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid arguments format for multiply command.");
                    return;
                }
                result = MathUtils.multiply(complex1, complex2Multiply);
                System.out.println(result.getRe() + ";" + result.getIm());
                break;
            case "conjugate":
                result = MathUtils.conjugate(complex1);
                System.out.println(result.getRe() + ";" + result.getIm());
                break;
            default:
                System.out.println("Invalid command: " + cmd);
        }
    }
}