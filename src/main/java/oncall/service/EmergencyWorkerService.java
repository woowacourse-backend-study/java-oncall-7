package oncall.service;

import oncall.domain.DayOfWeek;
import oncall.domain.Holiday;
import oncall.domain.Worker;
import oncall.repository.HolidayWorkerRepository;
import oncall.repository.WeekDayWorkerRepository;
import oncall.service.dto.ScheduleResponse;
import oncall.view.dto.DateInputResponse;

import java.util.ArrayList;
import java.util.List;

public class EmergencyWorkerService {
    private final List<Worker> schedule = new ArrayList<>();

    public ScheduleResponse getSchedule(DateInputResponse dateInput) {
        schedule.clear();
        final int month = dateInput.date().month;
        final int lastDay = dateInput.date().lastDay;
        DayOfWeek startDay = dateInput.startDay();
        while (isExistUpdate(month, lastDay, startDay)) {
            schedule.clear();
            WeekDayWorkerRepository.resetCursor();
            HolidayWorkerRepository.resetCursor();
        }
        return ScheduleResponse.from(month, startDay, schedule);
    }

    private boolean isExistUpdate(final int month, final int lastDay, DayOfWeek startDay) {
        DayOfWeek day = startDay;
        for (int currentDate = 1; currentDate <= lastDay; ++currentDate) {
            Worker nextWorker = getNextWorker(month, currentDate, day);
            if (!schedule.isEmpty() && schedule.getLast().equals(nextWorker)) {
                swapWorker(month, currentDate, day, nextWorker);
                return true;
            }
            schedule.add(nextWorker);
            day = day.getNextDay();
        }
        return false;
    }

    private Worker getNextWorker(final int month, final int day, DayOfWeek dayOfWeek) {
        if (isHoliday(month, day, dayOfWeek)) {
            return HolidayWorkerRepository.getNextWorker();
        }
        return WeekDayWorkerRepository.getNextWorker();
    }

    private boolean isHoliday(int month, int day, DayOfWeek dayOfWeek) {
        return dayOfWeek.isHoliday || Holiday.isExist(month, day);
    }

    private void swapWorker(int month, int day, DayOfWeek dayOfWeek, Worker nextWorker) {
        if (isHoliday(month, day, dayOfWeek)) {
            HolidayWorkerRepository.swap(nextWorker);
            return ;
        }
        WeekDayWorkerRepository.swap(nextWorker);
    }
}
