package oncall.view.dto;

import oncall.domain.Worker;
import oncall.infrastructure.constants.Delimiter;
import oncall.infrastructure.constants.ExceptionMessage;
import oncall.infrastructure.exception.CustomException;

import java.util.Arrays;
import java.util.List;

public record WorkerInputResponse(
        // 평일 근무자 명단
        List<Worker> weekdayWorkers,
        // 휴일 근무자 명단
        List<Worker> holidayWorkers
) {
    public static WorkerInputResponse from(String weekdayNames, String holidayNames) {
        List<Worker> weekdays = Arrays.stream(weekdayNames.split(Delimiter.COMMA.getValue()))
                .map(String::trim)
                .map(Worker::new)
                .toList();
        List<Worker> holidays = Arrays.stream(holidayNames.split(Delimiter.COMMA.getValue()))
                .map(String::trim)
                .map(Worker::new)
                .toList();
        validateDuplicate(weekdays);
        validateDuplicate(holidays);
        validateBothExist(weekdays, holidays);
        return new WorkerInputResponse(weekdays, holidays);
    }

    private static void validateDuplicate(List<Worker> names) {
        List<Worker> distinct = names.stream().distinct().toList();
        if (names.size() != distinct.size()) {
            throw new CustomException(ExceptionMessage.INVALID_INPUT.getMessage());
        }
    }

    private static void validateBothExist(List<Worker> weekdays, List<Worker> holidays) {
        for (Worker weekday : weekdays) {
            if (holidays.stream().noneMatch(holiday -> holiday.equals(weekday))) {
                throw new CustomException(ExceptionMessage.INVALID_INPUT.getMessage());
            }
        }
    }
}
