package section2.exercise3;

import java.util.Locale;
import java.util.Scanner;

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
