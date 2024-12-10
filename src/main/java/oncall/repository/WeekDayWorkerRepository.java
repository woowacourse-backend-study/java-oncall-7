package oncall.repository;

import oncall.domain.Worker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WeekDayWorkerRepository {
    private final static List<Worker> workers = new ArrayList<>();
    private static int cursor = 0;

    public static void reset() {
        workers.clear();
    }

    public static List<Worker> getWorkers() {
        return Collections.unmodifiableList(workers);
    }

    public static void add(Worker worker) {
        workers.add(worker);
    }

    public static void swap(Worker worker) {
        final int firstIndex = workers.indexOf(worker);
        if (firstIndex == -1) {
            throw new RuntimeException("존재하지 않는 근무자가 입력되었습니다.");
        }
        final int secondIndex = (firstIndex + 1) % workers.size();
        workers.set(firstIndex, workers.get(secondIndex));
        workers.set(secondIndex, worker);
    }

    public static Worker getNextWorker() {
        Worker worker = workers.get(cursor);
        cursor = (cursor + 1) % workers.size();
        return worker;
    }

    public static void resetCursor() {
        cursor = 0;
    }
}
