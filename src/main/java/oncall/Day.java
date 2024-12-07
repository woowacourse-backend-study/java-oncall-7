package oncall;

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
}
