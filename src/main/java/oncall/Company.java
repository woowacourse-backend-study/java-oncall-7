package oncall;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private RosterMachine rosterMachine;
    private Calendar calendar;

    public Company(RosterMachine rosterMachine, Calendar calendar) {
        this.rosterMachine = rosterMachine;
        this.calendar = calendar;
    }

    public List<DayWorker> getWorkSchedule() {
        List<DayWorker> dayWorkers = new ArrayList<>();

        int monthLength = calendar.getLength();
        for (int day = 1; day <= monthLength; day++) {
            Day today = calendar.getDay(day);
            Member todayWorker = rosterMachine.getCurrentMember(!today.isHolidayOrWeekEnd());
            dayWorkers.add(new DayWorker(today, todayWorker));
        }
        return dayWorkers;
    }
}
