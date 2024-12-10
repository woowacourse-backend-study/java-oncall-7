package oncall.view.dto;

import oncall.domain.Worker;

import java.util.List;

public record WorkerInputResponse(
        // 평일 근무자 명단
        List<Worker> weekdayWorkers,
        // 휴일 근무자 명단
        List<Worker> holidayWorkers
) {
    public static WorkerInputResponse from(List<String> weekdayNames, List<String> holidayNames) {
        List<Worker> weekdays = weekdayNames.stream().map(Worker::new).toList();
        List<Worker> holidays = holidayNames.stream().map(Worker::new).toList();
        return new WorkerInputResponse(weekdays, holidays);
    }
}
