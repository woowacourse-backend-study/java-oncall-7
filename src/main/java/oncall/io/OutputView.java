package oncall.io;

import java.util.List;
import oncall.DayWorker;

public class OutputView {

    private static final String ERROR_LABEL_MESSAGE = "[ERROR] ";

    public void outputWorkSchedule(List<DayWorker> workSchedule) {
        workSchedule.forEach(System.out::println);
    }

    public void outputErrorMessage(IllegalArgumentException illegalArgumentException) {
        System.out.println(ERROR_LABEL_MESSAGE + illegalArgumentException.getMessage());
    }
}
