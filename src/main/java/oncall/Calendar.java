package oncall;

import java.util.ArrayList;
import java.util.List;

public class Calendar {

    private List<Day> days = new ArrayList<>();

    public Calendar(DayOfTheWeek dayOfTheWeek, Month month) {
        int monthLength = month.getLength();
        for (int dayNum = 1; dayNum <= monthLength; dayNum++) {
            boolean isHoliday = month.isHoliday(dayNum);
            days.add(new Day(dayOfTheWeek, dayNum, isHoliday));
            dayOfTheWeek = dayOfTheWeek.getNextDay();
        }
    }

    public Day getDay(int dayNum) {
        for (Day day : days) {
            if (day.getNum() == dayNum) {
                return day;
            }
        }
        throw new IllegalArgumentException("존재하지 않는 날짜 입니다");
    }
}
