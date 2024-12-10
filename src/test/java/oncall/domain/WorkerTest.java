package oncall.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WorkerTest {
    @Test
    @DisplayName("닉네임은 5글자를 초과해서 설정할 수 없다.")
    void 닉네임_초과() {
        // given
        String name = "123456";

        // when & then
        assertThatThrownBy(() -> {
            new Worker(name);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}