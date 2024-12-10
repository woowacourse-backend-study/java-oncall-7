package oncall.infrastructure.constants;

import oncall.domain.Worker;

public enum ExceptionMessage {
    EMPTY_NAME("근무자의 이름은 공백으로 설정할 수 없습니다"),
    EXCEED_NAME_LEN(String.format("근무자의 이름은 최대 %,d 글자까지 설정할 수 있습니다.", Worker.MAX_LEN)),
    ;
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
