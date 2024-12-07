package oncall;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RosterTest {

    @Test
    void 평일_순번과_휴일_순번을_생성하고_평일_비상근무자를_선택할_수_있다() {
        //given
        String name1 = "사원1";
        String name2 = "사원2";
        String name3 = "사원3";
        RosterMachine rosterMachine = new RosterMachine(getWeekDayRoster(), getWeekEndRoster());

        //when
        Member currentMember = rosterMachine.getCurrentMember(true);

        //then
        Assertions.assertThat(currentMember.equals(name1)).isEqualTo(true);
        Assertions.assertThat(rosterMachine.getCurrentMember(true).equals(name2)).isEqualTo(true);
        Assertions.assertThat(rosterMachine.getCurrentMember(true).equals(name3)).isEqualTo(true);
        Assertions.assertThat(rosterMachine.getCurrentMember(true).equals(name1)).isEqualTo(true);
    }

    @Test
    void 주말_비상근무자를_선택할_수_있다() {
        //given
        String name1 = "사원1";
        String name2 = "사원2";
        String name3 = "사원3";
        RosterMachine rosterMachine = new RosterMachine(getWeekDayRoster(), getWeekEndRoster());

        //when
        Member currentMember = rosterMachine.getCurrentMember(false);

        //then
        Assertions.assertThat(currentMember.equals(name2)).isEqualTo(true);
        Assertions.assertThat(rosterMachine.getCurrentMember(false).equals(name3)).isEqualTo(true);
        Assertions.assertThat(rosterMachine.getCurrentMember(false).equals(name1)).isEqualTo(true);
        Assertions.assertThat(rosterMachine.getCurrentMember(false).equals(name2)).isEqualTo(true);
        Assertions.assertThat(rosterMachine.getCurrentMember(false).equals(name3)).isEqualTo(true);
    }

    private Roster getWeekDayRoster() {
        String name1 = "사원1";
        Member member1 = new Member(name1);
        String name2 = "사원2";
        Member member2 = new Member(name2);
        String name3 = "사원3";
        Member member3 = new Member(name3);
        MemberFactory memberFactory = new MemberFactory();
        memberFactory.addMember(member1);
        memberFactory.addMember(member2);
        memberFactory.addMember(member3);

        return new Roster(memberFactory.getMembers());
    }

    private Roster getWeekEndRoster() {
        String name1 = "사원1";
        Member member1 = new Member(name1);
        String name2 = "사원2";
        Member member2 = new Member(name2);
        String name3 = "사원3";
        Member member3 = new Member(name3);
        MemberFactory memberFactory = new MemberFactory();

        memberFactory.addMember(member2);
        memberFactory.addMember(member3);
        memberFactory.addMember(member1);

        return new Roster(memberFactory.getMembers());
    }
}
