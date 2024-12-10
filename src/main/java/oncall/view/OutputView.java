package oncall.view;

import oncall.domain.ScheduleOfDay;
import oncall.service.dto.ScheduleResponse;

import java.util.List;

public class OutputView {
    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printSchedule(ScheduleResponse scheduleResponse) {
        final int month = scheduleResponse.month();
        List<ScheduleOfDay> schedules = scheduleResponse.schedules();
        int day = 1;
        for (ScheduleOfDay schedule : schedules) {
            printMessage(getScheduleText(month, day++, schedule));
        }
    }

    private String getScheduleText(final int month, final int day, ScheduleOfDay schedule) {
        return String.format("%d월 %d일 %s%s %s",
                month, day, schedule.getDayOfWeek(), getHolidayText(schedule.isHoliday()), schedule.getWorkerName());
    }

    private String getHolidayText(boolean isHoliday) {
        if (isHoliday) {
            return "(휴일)";
        }
        return "";
    }
}
