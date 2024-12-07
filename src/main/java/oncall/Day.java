package oncall;

import java.util.Objects;

public class Day {

    private DayOfTheWeek dayOfTheWeek;
    private int num;
    private boolean isHoliday;

    public Day(DayOfTheWeek dayOfTheWeek, int num, boolean isHoliday) {
        this.dayOfTheWeek = dayOfTheWeek;
        this.num = num;
        this.isHoliday = isHoliday;
    }

    public DayOfTheWeek getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public int getNum() {
        return num;
    }

    public boolean isHoliday() {
        return isHoliday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Day day = (Day) o;
        return num == day.num && isHoliday == day.isHoliday && dayOfTheWeek == day.dayOfTheWeek;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dayOfTheWeek, num, isHoliday);
    }
}
