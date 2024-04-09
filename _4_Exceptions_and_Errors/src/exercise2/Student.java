package exercise2;

class Student {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        if (Character.isLowerCase(newName.charAt(0)) ||
            !newName.matches("\\w[a-z]+")) {
            throw new IllegalArgumentException("Invalid student name");
        }

        this.name = newName;
    }
}