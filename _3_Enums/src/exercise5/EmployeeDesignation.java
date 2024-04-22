package exercise5;

enum EmployeeDesignation {
    JUNIOR_DEVELOPER(20),
    SENIOR_DEVELOPER(30),
    TEAM_LEAD(40),
    PROJECT_MANAGER(50);

    private final int payScale;

    EmployeeDesignation(int payScale) {
        this.payScale = payScale;
    }

    public int getPayScale() {
        return payScale;
    }

    public int yearlySalary(int workingHoursPerYear) {
        return payScale * workingHoursPerYear;
    }
}

class Demo {

    public static void main(String[] args) {
        for (String arg : args) {
            String[] pair = arg.split(":");
            String designationName = pair[0];
            int workingHoursPerYear = Integer.valueOf(pair[1]);

            // TODO: Add your implementation here.
            EmployeeDesignation designation = EmployeeDesignation.valueOf(designationName);
            int salary = designation.yearlySalary(workingHoursPerYear);

            //do not change the next line
            System.out.println(salary);
        }
    }
}

