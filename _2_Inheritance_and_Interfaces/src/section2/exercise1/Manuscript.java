package section2.exercise1;

import java.util.Scanner;

class Manuscript {
    //declare instance constants
    private String author;
    private String name;

    public Manuscript(String author, String name) {
        this.author = author;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ";" +
                author + ";" +
                name;
    }
}

class PublishedBook extends Manuscript{
    private String publisher;
    private int pagesNumber;

    public PublishedBook(String author, String name, String publisher, int pagesNumber) {
        super(author, name);
        this.publisher = publisher;
        this.pagesNumber = pagesNumber;
    }

    @Override
    public String toString() {
        String superString = super.toString();
        superString = superString.substring(superString.indexOf(";") + 1);
        return this.getClass().getSimpleName() + ";" +
                superString + ";" +
                publisher + ";" +
                pagesNumber;
    }
}

class ElectronicBook extends Manuscript{
    private String format;
    private int size;

    public ElectronicBook(String author, String name, String format, int size) {
        super(author, name);
        this.format = format;
        this.size = size;
    }

    @Override
    public String toString() {
        String superString = super.toString();
        superString = superString.substring(superString.indexOf(";") + 1);
        return this.getClass().getSimpleName() + ";" +
                superString + ";" +
                format + ";" +
                size;
    }
}

class Solution {
    public static Manuscript getManuscript(String inputLine) {
        try (Scanner sc = new Scanner(inputLine)) {
            sc.useDelimiter(";");
            Manuscript manuscript;
            int id = sc.nextInt();
            //input other values from inputLine dependantly of the id value

            String author = sc.next();
            String name = sc.next();

            //create an instance of the Manuscript type(not class!) dependantly of the id value
            switch (id) {
                case 1:
                    String publisher = sc.next();
                    int pagesNumber = Integer.parseInt(sc.next());
                    manuscript = new PublishedBook(author, name, publisher, pagesNumber);
                    break;
                case 2:
                    String format = sc.next();
                    int size = Integer.parseInt(sc.next());
                    manuscript = new ElectronicBook(author, name, format, size);
                    break;
                default:
                    manuscript = new Manuscript(author, name);
                    break;
            }

            //and return it
            return manuscript;
        }
    }
}


class Main {

    static {
        // some hidden verification code inside this block
        try {
            checkClass(Manuscript.class, Object.class, 2, 1);
            checkClass(PublishedBook.class, Manuscript.class, 2, 1);
            checkClass(ElectronicBook.class, Manuscript.class, 2, 1);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }

    }

    private static void checkClass(Class<? extends Manuscript> cl, Class<?> supercl, int fields, int methods) {
        String clName = cl.getSimpleName();
        if (cl.getSuperclass() != supercl) {
            throw new IllegalStateException(String.format("The %s class must have the %s superclass", clName, supercl.getSimpleName()));
        }
        if (cl.getFields().length != 0) {
            throw new IllegalStateException(String.format("The %s class does not need to have public fields", clName));
        }
        if (cl.getDeclaredFields().length != fields) {
            throw new IllegalStateException(String.format("The %s class must have %d private fields" + (fields > 0 ? " and no more others" : ""), clName, fields));
        }
        if (cl.getConstructors().length != 1) {
            throw new IllegalStateException(String.format("The %s class must have exactly 1 public constructor and no more others", clName));
        }
        if (cl.getDeclaredMethods().length != methods) {
            throw new IllegalStateException(String.format("The %s class must have %d methods" + (methods > 0 ? " and no more  others" : ""), clName, methods));
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String inputLine = sc.nextLine();
            System.out.println(Solution.getManuscript(inputLine));
        }
    }
}

