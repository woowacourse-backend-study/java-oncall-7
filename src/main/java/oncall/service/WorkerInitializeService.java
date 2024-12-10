package oncall.service;

import oncall.domain.Worker;
import oncall.repository.HolidayWorkerRepository;
import oncall.repository.WeekDayWorkerRepository;
import oncall.view.dto.WorkerInputResponse;

import java.util.List;

public class WorkerInitializeService {
    public void init(WorkerInputResponse workerInputs) {
        List<Worker> weekdayWorkers = workerInputs.weekdayWorkers();
        List<Worker> holidayWorkers = workerInputs.holidayWorkers();
        for (Worker worker : weekdayWorkers) {
            WeekDayWorkerRepository.add(worker);
        }
        for (Worker worker : holidayWorkers) {
            HolidayWorkerRepository.add(worker);
        }
    }
}
