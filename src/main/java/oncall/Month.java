package oncall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Month {

    JANUARY(31, 1),
    FEBRUARY(28),
    MARCH(31, 1),
    APRIL(30),
    MAY(31, 5),
    JUNE(30, 6),
    JULY(31),
    AUGUST(31, 15),
    SEPTEMBER(30),
    OCTOBER(31, 3, 9),
    NOVEMBER(30),
    DECEMBER(31, 25);

    private int length;
    private List<Integer> holidayNums = new ArrayList<>();

    Month(int length, Integer... holidayNums) {
        this.length = length;
        this.holidayNums.addAll(Arrays.asList(holidayNums));
    }

    public int getLength() {
        return length;
    }

    public boolean isHoliday(int day) {
        for (Integer holidayNum : holidayNums) {
            if (day == holidayNum) {
                return true;
            }
        }
        return false;
    }
}
