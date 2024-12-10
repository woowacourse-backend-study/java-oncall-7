package oncall.domain;

public record ScheduleOfDay(
        DayOfWeek dayOfWeek,
        boolean isHoliday,
        Worker worker
) {
    public String getDayOfWeek() {
        return dayOfWeek.name;
    }

    public String getWorkerName() {
        return worker.name();
    }
}
