package oncall.domain;

import oncall.infrastructure.constants.ExceptionMessage;
import oncall.infrastructure.exception.CustomException;

import java.util.Arrays;

public enum DayOfWeek {
    월요일("월", 0, false),
    화요일("화", 1, false),
    수요일("수", 2, false),
    목요일("목", 3, false),
    금요일("금", 4, false),
    토요일("토", 5, true),
    일요일("일", 6, true),
    ;

    public final String name;
    public final int value;
    public final boolean isHoliday;

    DayOfWeek(String name, int value, boolean isHoliday) {
        this.name = name;
        this.value = value;
        this.isHoliday = isHoliday;
    }

    public static DayOfWeek from(String name) {
        return Arrays.stream(values())
                .filter(dayOfWeek -> dayOfWeek.name.equals(name))
                .findAny()
                .orElseThrow(() -> new CustomException(ExceptionMessage.INVALID_DAY.getMessage()));
    }

    public static DayOfWeek getNextDay(DayOfWeek before) {
        final int nextValue = (before.value + 1) % values().length;
        return Arrays.stream(values())
                .filter(dayOfWeek -> dayOfWeek.value == nextValue)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("요일 정보가 올바르지 않습니다."));
    }
}
