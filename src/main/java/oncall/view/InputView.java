package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import oncall.infrastructure.constants.ExceptionMessage;
import oncall.infrastructure.constants.Message;
import oncall.infrastructure.exception.CustomException;
import oncall.view.dto.DateInputResponse;
import oncall.view.dto.WorkerInputResponse;

import java.util.Arrays;
import java.util.List;

public class InputView {
    public static final String DELIMITER = ",";

    public DateInputResponse getDate() {
        System.out.print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
        List<String> parsed = parseDelimiter(Console.readLine().trim());
        if (parsed.size() != 2) {
            throw new CustomException(ExceptionMessage.INVALID_INPUT.getMessage());
        }
        return DateInputResponse.from(parsed.get(0), parsed.get(1));
    }

    public WorkerInputResponse getWorkers() {
        System.out.print("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        List<String> weekdayNames = parseDelimiter(Console.readLine().trim());

        System.out.print(Message.NEW_LINE.getValue());
        System.out.print("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        List<String> holidayNames = parseDelimiter(Console.readLine().trim());

        validateNames(weekdayNames, holidayNames);

        return WorkerInputResponse.from(weekdayNames, holidayNames);
    }

    private List<String> parseDelimiter(String input) {
        return Arrays.stream(input.split(DELIMITER)).map(String::trim).toList();
    }

    private void validateNames(List<String> weekdayNames, List<String> holidayNames) {
        validateDuplicate(weekdayNames);
        validateDuplicate(holidayNames);
        validateBothExist(weekdayNames, holidayNames);
    }

    private void validateDuplicate(List<String> names) {
        List<String > distinct = names.stream().distinct().toList();
        if (names.size() != distinct.size()) {
            throw new CustomException(ExceptionMessage.INVALID_INPUT.getMessage());
        }
    }

    private void validateBothExist(List<String> weekdays, List<String> holidays) {
        for (String weekday : weekdays) {
            if (holidays.stream().noneMatch(holiday -> holiday.equals(weekday))) {
                throw new CustomException(ExceptionMessage.INVALID_INPUT.getMessage());
            }
        }
    }
}
