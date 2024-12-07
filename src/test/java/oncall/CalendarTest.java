package oncall;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalendarTest {

    @Test
    void 요일과_월이름을_통해_월을_생성할_수_있다() {
        //given
        Calendar martchCalendar = new Calendar(DayOfTheWeek.MONDAY, Month.MARCH);

        //when
        Day day1 = martchCalendar.getDay(1);
        Day day2 = martchCalendar.getDay(3);

        //then
        Assertions.assertThat(day1).isEqualTo(new Day(DayOfTheWeek.MONDAY, 1, true));
        Assertions.assertThat(day2).isEqualTo(new Day(DayOfTheWeek.WEDNESDAY, 3, false));
    }

    @Test
    void 휴일을_판단_할_수_있다() {
        //given
        Calendar martchCalendar = new Calendar(DayOfTheWeek.MONDAY, Month.MAY);

        //when
        Day day = martchCalendar.getDay(5);

        //then
        Assertions.assertThat(day).isEqualTo(new Day(DayOfTheWeek.FRIDAY, 5, true));
    }
}
