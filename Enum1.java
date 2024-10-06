public class Enum1 {
    public enum Day {
        MONDAY(true),
        TUESDAY(true),
        WEDNESDAY(true),
        THURSDAY(true),
        FRIDAY(true),
        SATURDAY(false),
        SUNDAY(false);

        private final boolean isWorkingDay;

        Day(boolean isWorkingDay) {
            this.isWorkingDay = isWorkingDay;
        }

        public boolean isWorkingDay() {
            return isWorkingDay;
        }
    }

    public static void main(String[] args) {
        for (Day day : Day.values()) {
            System.out.println(day + " is a working day: " + day.isWorkingDay());
        }
    }
}
