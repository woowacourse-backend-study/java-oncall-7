package oncall;

import static oncall.RosterTest.getWeekDayRoster;
import static oncall.RosterTest.getWeekEndRoster;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CompanyTest {

    @Test
    void 비상_근무자를_배정할_수_있다() {
        //given
        Calendar martchCalendar = new Calendar(DayOfTheWeek.MONDAY, Month.MARCH);
        Company company = new Company(getRosterMachine(), martchCalendar);

        //when
        List<DayWorker> workSchedule = company.getWorkSchedule();

        //then
        Assertions.assertThat(workSchedule.size()).isEqualTo(31);
    }

    @Test
    void 비상_근무자_세부정보를_확인_할_수_있다() {
        //given
        Calendar martchCalendar = new Calendar(DayOfTheWeek.MONDAY, Month.MARCH);
        Company company = new Company(getRosterMachine(), martchCalendar);

        //when
        List<DayWorker> workSchedule = company.getWorkSchedule();

        //then
        for (DayWorker dayWorker : workSchedule) {
            System.out.println(dayWorker);
        }
        Assertions.assertThat(workSchedule.size()).isEqualTo(31);
    }

    public static RosterMachine getRosterMachine() {
        return new RosterMachine(getWeekDayRoster(), getWeekEndRoster());
    }

}
