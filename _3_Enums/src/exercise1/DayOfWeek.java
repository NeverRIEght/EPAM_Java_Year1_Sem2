package exercise1;

enum DayOfWeek {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    public DayOfWeek next() {
        int newIndex = this.ordinal() + 1;
        return DayOfWeek.values()[(newIndex) % DayOfWeek.values().length];
    }
}

class Demo {

    public static void main(String[] args) {
        try {
            for (String arg : args) {
                DayOfWeek day = DayOfWeek.valueOf(arg);
                System.out.println(day.next());
            }
        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }

}
