package oncall.infrastructure.constants;

import oncall.domain.DayOfWeek;
import oncall.domain.Worker;

import java.util.Arrays;

public enum ExceptionMessage {
    EMPTY_NAME("근무자의 이름은 공백으로 설정할 수 없습니다"),
    EXCEED_NAME_LEN(String.format("근무자의 이름은 최대 %,d 글자까지 설정할 수 있습니다.", Worker.MAX_LEN)),
    INVALID_DATE("날짜는 1월부터 12월까지 존재합니다."),
    INVALID_DAY(String.format("요일은 %s 중에서만 입력할 수 있습니다.",
            String.join(", ", Arrays.stream(DayOfWeek.values()).map(DayOfWeek::name).toList()))
    ),
    INVALID_INPUT("유효하지 않은 입력 값입니다. 다시 입력해 주세요."),
    ;
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
