package oncall.domain;

import oncall.infrastructure.constants.ExceptionMessage;
import oncall.infrastructure.exception.CustomException;

public record Worker(String name) {
    public static int MAX_LEN = 5;

    public Worker {
        validateName(name);
    }

    private void validateName(String name) {
        if (name.isBlank()) {
            throw new CustomException(ExceptionMessage.EMPTY_NAME.getMessage());
        }

        if (name.length() > MAX_LEN) {
            throw new CustomException(ExceptionMessage.EXCEED_NAME_LEN.getMessage());
        }
    }
}
