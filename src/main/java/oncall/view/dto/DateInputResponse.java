package oncall.view.dto;

import oncall.domain.Date;
import oncall.domain.DayOfWeek;
import oncall.infrastructure.constants.ExceptionMessage;
import oncall.infrastructure.exception.CustomException;

public record DateInputResponse(Date date, DayOfWeek startDay) {
    public static DateInputResponse from(String month, String day) {
        return new DateInputResponse(Date.of(parseToInt(month)), DayOfWeek.from(day));
    }

    private static int parseToInt(String month) {
        try {
            return Integer.parseInt(month);
        } catch (NumberFormatException e) {
            throw new CustomException(ExceptionMessage.INVALID_INPUT.getMessage());
        }
    }
}
