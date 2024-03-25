package section2.exercise3;

import java.util.Locale;
import java.util.Scanner;

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
