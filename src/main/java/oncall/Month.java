package oncall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Month {

    JANUARY("1", 31, 1),
    FEBRUARY("2", 28),
    MARCH("3", 31, 1),
    APRIL("4", 30),
    MAY("5", 31, 5),
    JUNE("6", 30, 6),
    JULY("7", 31),
    AUGUST("8", 31, 15),
    SEPTEMBER("9", 30),
    OCTOBER("10", 31, 3, 9),
    NOVEMBER("11", 30),
    DECEMBER("12", 31, 25);

    private String monthName;
    private int length;
    private List<Integer> holidayNums = new ArrayList<>();

    Month(String monthName, int length, Integer... holidayNums) {
        this.monthName = monthName;
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

    public static Month getMonth(String name) throws IllegalArgumentException {
        for (Month month : values()) {
            if (month.monthName.equals(name)) {
                return month;
            }
        }
        throw new IllegalArgumentException("존재하지 않는 달입니다.");
    }

    @Override
    public String toString() {
        return monthName + "월";
    }
}
