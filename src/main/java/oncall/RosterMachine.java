package oncall;

import java.util.Optional;

public class RosterMachine {

    private Roster weekDayRoster;
    private Roster weekEndRoster;

    private Member currentMember;

    public RosterMachine(Roster weekDayRoster, Roster weekEndRoster) {
        this.weekDayRoster = weekDayRoster;
        this.weekEndRoster = weekEndRoster;
    }

    public Member getCurrentMember(boolean isWeekDay) {
        if (isWeekDay) {
            currentMember = weekDayRoster.getCurrentMemberByCriterion(getCriterionMember());
            return currentMember;
        }
        currentMember = weekEndRoster.getCurrentMemberByCriterion(getCriterionMember());
        return currentMember;
    }

    private Optional<Member> getCriterionMember() {
        if (currentMember == null) {
            return Optional.empty();
        }
        return Optional.of(currentMember);
    }
}
