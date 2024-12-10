package oncall.domain;

import java.util.Arrays;

public enum Holiday {
    신정(1, 1),
    삼일절(3, 1),
    어린이날(5, 5),
    현충일(6, 6),
    광복절(8, 15),
    개천절(10, 3),
    한글날(10, 9),
    성탄절(12, 25),
    ;

    public final int month;
    public final int day;

    Holiday(int month, int day) {
        this.month = month;
        this.day = day;
    }

    public static boolean isExist(int month, int day) {
        return Arrays.stream(values()).anyMatch(holiday -> holiday.month == month && holiday.day == day);
    }
}
