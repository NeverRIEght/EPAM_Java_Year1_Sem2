package section2;

import java.util.Locale;
import java.util.Scanner;


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

class Solution {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("EN"));
        try (Scanner sc = new Scanner(System.in)) {
            //input material’s name and density
            String materialName = sc.nextLine();
//            double materialDensity = sc.nextDouble(); // конец строки здесь не воспринимается при нажатии Enter
            //sc.next();
            double materialDensity = Double.parseDouble(sc.nextLine());
            Material material = new Material(materialName, materialDensity);

            //input subject’s name and volume
            String subjectName = sc.nextLine(); // конец строки провериться после ввода следующей строки и вызовет ошибку
//            double subjectVolume = sc.nextDouble();
            double subjectVolume = Double.parseDouble(sc.nextLine());

            //create a Subject instance that consists of the given material with input values
            Subject subject = new Subject(subjectName, material, subjectVolume);

            //output a Subject instance
            System.out.println(subject);

            //update a subject material by the "copper" whose density is 8500.0
            Material copper = new Material("copper", 8500.0);
            subject.setMaterial(copper);

            //output the mass of the updated subject to 2 decimal places after a space character
            System.out.printf("%.02f%n", subject.getMass());
        }
    }
}
class Main {

    static {
        // some hidden verification code inside this block
        try {
            checkMaterial();
            checkSubject();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }

    public static void main(String[] args) {
        Solution.main(args);
    }

    private static void checkMaterial() {
        Class<Material> cl = Material.class;
        String className = cl.getSimpleName();
        if (cl.getFields().length != 0) {
            throw new IllegalStateException("The " + className + " class does not needs to have public fields");
        }
        checkField("name", String.class, true, cl);
        checkField("density", double.class, true, cl);
        if (cl.getDeclaredFields().length != 2) {
            throw new IllegalStateException("The " + className + " class must have 2 private fields");
        }
        if (cl.getConstructors().length != 1) {
            throw new IllegalStateException("The " + className + " class must have 1 public constructor");
        }
        try {
            cl.getConstructor(String.class, double.class);
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException("Wrong list of arguments for the constructor of the " + className + " class");
        }
    }

    private static void checkSubject() {
        Class<Subject> cl = Subject.class;
        String className = cl.getSimpleName();
        if (cl.getFields().length != 0) {
            throw new IllegalStateException("The " + className + " class does not needs to have public fields");
        }
        if (cl.getDeclaredFields().length != 3) {
            throw new IllegalStateException("The " + className + " class must have 3 private fields");
        }
        checkField("name", String.class, false, cl);
        checkField("material", Material.class, false, cl);
        checkField("volume", double.class, false, cl);
        if (cl.getConstructors().length != 1) {
            throw new IllegalStateException("The " + className + " class must have 1 public constructor");
        }
        try {
            cl.getConstructor(String.class, Material.class, double.class);
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException("Wrong list of arguments for the constructor of the " + className + " class");
        }
    }

    private static void checkField(String fieldName, Class<?> fieldType, boolean isFieldFinal, Class<?> cl) {
        try {
            java.lang.reflect.Field field = cl.getDeclaredField(fieldName);
            int modifiers = field.getModifiers();
            if (!java.lang.reflect.Modifier.isPrivate(modifiers)) {
                throw new IllegalStateException("The field " + fieldName + " must be private");
            }
            if (isFieldFinal && !java.lang.reflect.Modifier.isFinal(modifiers)) {
                throw new IllegalStateException("The field " + fieldName + " must be final");
            }
            if(field.getType() != fieldType) {
                throw new IllegalStateException("Wrong type for the field " + fieldName);
            }
        } catch (NoSuchFieldException e) {
            throw new IllegalStateException("The " + cl.getSimpleName() + " class must have the field " + fieldName);
        }
    }

}
