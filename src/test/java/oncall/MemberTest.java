package oncall;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberTest {

    @Test
    void 사원은_이름이_있다() {
        //given
        String name = "사원이름";

        //when
        Member member = new Member(name);

        //then
        Assertions.assertThat(member.equals(name)).isEqualTo(true);
    }

    @Test
    void 중복된_이름을_가진_사원은_예외로_간주한다() {
        //given
        String name = "사원이름";
        Member member = new Member(name);
        MemberFactory memberFactory = new MemberFactory();
        memberFactory.addMember(member);

        //when
        Member copyMember = new Member(name);

        //then
        Assertions.assertThatThrownBy(() -> memberFactory.addMember(copyMember))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이미 존재하는 근무자 입니다");
    }

}
