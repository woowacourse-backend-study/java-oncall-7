package oncall;

import java.util.List;
import oncall.io.InputView;
import oncall.io.OutputView;

public class CompanyProgram {

    private InputView inputView;
    private OutputView outputView;
    private Company company;

    public CompanyProgram(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startProgram() {
        Calendar calendar = makeCalendar();
        company = makeCompany(calendar);
        List<DayWorker> workSchedule = company.getWorkSchedule();
        outputView.outputWorkSchedule(workSchedule);
    }

    public Calendar makeCalendar() {
        try {
            String[] inputs = inputView.inputMonthDayOfTheWeek();
            Month month = Month.getMonth(inputs[0]);
            DayOfTheWeek dayOfTheWeek = DayOfTheWeek.getDayOfTheWeek(inputs[1]);
            return new Calendar(dayOfTheWeek, month);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return makeCalendar();
        }
    }

    public Company makeCompany(Calendar calendar) {
        try {
            Roster weekDayRoster = makeWeekDayRoster();
            Roster weekEndRoster = makeWeekEndRoster();
            RosterMachine rosterMachine = new RosterMachine(weekDayRoster, weekEndRoster);
            return new Company(rosterMachine, calendar);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return makeCompany(calendar);
        }
    }

    private Roster makeWeekDayRoster() {
        String[] inputs = inputView.inputWeekDayMember();
        MemberFactory memberFactory = new MemberFactory();
        for (String name : inputs) {
            memberFactory.addMember(new Member(name));
        }
        return new Roster(memberFactory.getMembers());
    }

    private Roster makeWeekEndRoster() {
        String[] inputs = inputView.inputWeekEndMember();
        MemberFactory memberFactory = new MemberFactory();
        for (String name : inputs) {
            memberFactory.addMember(new Member(name));
        }
        return new Roster(memberFactory.getMembers());
    }
}
