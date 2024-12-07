package oncall.io;

import java.util.List;
import oncall.DayWorker;

public class OutputView {
    public void outputWorkSchedule(List<DayWorker> workSchedule) {
        workSchedule.forEach(System.out::println);
    }
}
