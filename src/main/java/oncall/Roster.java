package oncall;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Optional;

public class Roster {

    private Deque<Member> members = new ArrayDeque<>();

    public Roster(List<Member> members) {
        this.members.addAll(members);
    }

    private Member getCurrentMember() {
        Member member = members.removeFirst();
        members.addLast(member);
        return member;
    }

    public Member getCurrentMemberByCriterion(Optional<Member> criterion) {
        if (criterion.isEmpty()) {
            return getCurrentMember();
        }
        Member preMember = criterion.get();
        Member currentMember = getCurrentMember();
        if (preMember.equals(currentMember)) {
            Member futureMember = getCurrentMember();
            members.addFirst(currentMember);
            return futureMember;
        }
        return currentMember;
    }
}
