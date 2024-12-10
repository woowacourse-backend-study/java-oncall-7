package oncall.repository;

import oncall.domain.Worker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HolidayWorkerRepository {
    private final static List<Worker> workers = new ArrayList<>();

    public static List<Worker> getWorkers() {
        return Collections.unmodifiableList(workers);
    }

    public static void add(Worker worker) {
        workers.add(worker);
    }

    public static void replace(int index, Worker worker) {
        workers.set(index, worker);
    }
}
