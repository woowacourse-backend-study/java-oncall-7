package oncall.service.dto;

import oncall.domain.*;

import java.util.ArrayList;
import java.util.List;

public record ScheduleResponse(
        int month,
        List<ScheduleOfDay> schedules
) {
    public static ScheduleResponse from(final int month, DayOfWeek startDay, List<Worker> workers) {
        Date date = Date.of(month);
        DayOfWeek dayOfWeek = startDay;
        List<ScheduleOfDay> result = new ArrayList<>();
        for (int currentDate = 1; currentDate <= date.lastDay; currentDate++) {
            result.add(new ScheduleOfDay(
                    dayOfWeek,
                    isWeekHoliday(dayOfWeek, month, currentDate),
                    workers.get(currentDate-1))
            );
            dayOfWeek = dayOfWeek.getNextDay();
        }
        return new ScheduleResponse(month, result);
    }

    private static boolean isWeekHoliday(DayOfWeek day, int month, int date) {
        return !day.isHoliday && Holiday.isExist(month, date);
    }
}
