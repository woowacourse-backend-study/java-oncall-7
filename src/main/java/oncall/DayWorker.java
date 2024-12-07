package oncall;

public class DayWorker {
    
    private Day day;
    private Member worker;

    public DayWorker(Day day, Member worker) {
        this.day = day;
        this.worker = worker;
    }

    @Override
    public String toString() {
        return day + " " + worker;
    }
}
