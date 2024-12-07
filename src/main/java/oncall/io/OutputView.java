package oncall.io;

import java.util.List;
import oncall.DayWorker;

public class OutputView {
    public void outputWorkSchedule(List<DayWorker> workSchedule) {
        for (DayWorker dayWorker : workSchedule) {
            System.out.println(dayWorker);
        }
    }
}
