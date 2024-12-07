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

    public DayOfTheWeek getNextDay() {
        if (this.equals(MONDAY)) {
            return TUESDAY;
        }
        if (this.equals(TUESDAY)) {
            return WEDNESDAY;
        }
        if (this.equals(WEDNESDAY)) {
            return THURSDAY;
        }
        if (this.equals(THURSDAY)) {
            return FRIDAY;
        }
        if (this.equals(FRIDAY)) {
            return SATURDAY;
        }
        if (this.equals(SATURDAY)) {
            return SUNDAY;
        }
        return MONDAY;
    }

    public String getName() {
        return name;
    }

    public boolean isWeekEnd() {
        if (this.equals(SATURDAY) || this.equals(SUNDAY)) {
            return true;
        }
        return false;
    }

    public static DayOfTheWeek getDayOfTheWeek(String name) throws IllegalArgumentException {
        for (DayOfTheWeek dayOfTheWeek : values()) {
            if (dayOfTheWeek.getName().equals(name)) {
                return dayOfTheWeek;
            }
        }
        throw new IllegalArgumentException("존재하지 않는 요일입니다");
    }
}
