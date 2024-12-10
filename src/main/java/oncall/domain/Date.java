package oncall.domain;

import oncall.infrastructure.constants.ExceptionMessage;
import oncall.infrastructure.exception.CustomException;

import java.util.Arrays;

public enum Date {
    일월(1, 31),
    이월(2, 28),
    삼월(3, 31),
    사월(4, 30),
    오월(5, 31),
    유월(6, 30),
    칠월(7, 31),
    팔월(8, 31),
    구월(9, 30),
    시월(10, 31),
    십일월(11, 30),
    십이월(12, 31),
    ;

    public final int month;
    public final int lastDay;

    Date(int month, int lastDay) {
        this.month = month;
        this.lastDay = lastDay;
    }

    public static Date of(int month) {
        return Arrays.stream(values())
                .filter(date -> date.month == month)
                .findAny()
                .orElseThrow(() -> new CustomException(ExceptionMessage.INVALID_DATE.getMessage()));
    }
}
