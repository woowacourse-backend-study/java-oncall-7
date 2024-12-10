package oncall.service;

import oncall.domain.Worker;
import oncall.infrastructure.constants.ExceptionMessage;
import oncall.infrastructure.constants.WorkerConstant;
import oncall.infrastructure.exception.CustomException;
import oncall.repository.HolidayWorkerRepository;
import oncall.repository.WeekDayWorkerRepository;
import oncall.view.dto.WorkerInputResponse;

import java.util.List;

public class WorkerInitializeService {
    public void init(WorkerInputResponse workerInputs) {
        List<Worker> weekdayWorkers = workerInputs.weekdayWorkers();
        List<Worker> holidayWorkers = workerInputs.holidayWorkers();
        validateWorkers(weekdayWorkers);
        validateWorkers(holidayWorkers);
        for (Worker worker : weekdayWorkers) {
            WeekDayWorkerRepository.add(worker);
        }
        for (Worker worker : holidayWorkers) {
            HolidayWorkerRepository.add(worker);
        }
        WeekDayWorkerRepository.resetCursor();
        HolidayWorkerRepository.resetCursor();
    }

    private void validateWorkers(List<Worker> workers) {
        if (workers.size() < WorkerConstant.MIN_COUNT || workers.size() > WorkerConstant.MAX_COUNT) {
            throw new CustomException(ExceptionMessage.INVALID_INPUT.getMessage());
        }
    }
}
