package exercise2;

class Demo {
    public static void main(String[] args) {
        for (String arg : args) {
            Student student = new Student();

            try {
                student.setName(arg);
                System.out.println(student.getName());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}