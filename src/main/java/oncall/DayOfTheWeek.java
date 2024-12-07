package oncall;

public enum DayOfTheWeek {

    MONDAY("월", false),
    TUESDAY("화", false),
    WEDNESDAY("수", false),
    THURSDAY("목", false),
    FRIDAY("금", false),
    SATURDAY("토", true),
    SUNDAY("일", true);

    private String name;
    private boolean isDayOff;

    DayOfTheWeek(String name, boolean isDayOff) {
        this.name = name;
        this.isDayOff = isDayOff;
    }
}
