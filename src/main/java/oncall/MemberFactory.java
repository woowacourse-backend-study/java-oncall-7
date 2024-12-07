package oncall;

import java.util.ArrayList;
import java.util.List;

public class MemberFactory {

    private List<Member> members = new ArrayList<>();

    public MemberFactory() {

    }

    public void addMember(Member newMember) {
        for (Member member : members) {
            if (newMember.equals(member)) {
                throw new IllegalArgumentException("이미 존재하는 근무자 입니다");
            }
        }
        members.add(newMember);
    }

    public Member getMember(String name) {
        for (Member member : members) {
            if (member.equals(name)) {
                return member;
            }
        }
        throw new IllegalArgumentException("존재하지 않는 근무자 입니다");
    }

    public List<Member> getMembers() {
        return members;
    }
}
