package oncall;

import java.util.Objects;

public class Day {

    private Month month;
    private DayOfTheWeek dayOfTheWeek;
    private int num;
    private boolean isHoliday;
    private boolean isWeekEnd;

    public Day(Month month, DayOfTheWeek dayOfTheWeek, int num, boolean isHoliday) {
        this.month = month;
        this.dayOfTheWeek = dayOfTheWeek;
        this.num = num;
        this.isHoliday = isHoliday;

        if (dayOfTheWeek.isWeekEnd()) {
            this.isWeekEnd = true;
            return;
        }
        this.isWeekEnd = false;
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

    public boolean isHolidayOrWeekEnd() {
        return isHoliday || isWeekEnd;
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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(month)
                .append(" ")
                .append(num)
                .append("일 ")
                .append(dayOfTheWeek.getName());
        if (isHoliday) {
            stringBuilder.append("(휴일)");
        }
        return stringBuilder.toString();
    }
}
