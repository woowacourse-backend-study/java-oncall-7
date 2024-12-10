package oncall.service;

import oncall.view.dto.WorkerInputResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WorkerInitializeServiceTest {
    private final WorkerInitializeService workerInitializeService = new WorkerInitializeService();

    @Test
    @DisplayName("5명 미만인 경우 예외처리")
    void 인원부족_예외_테스트() {
        // given
        WorkerInputResponse response = WorkerInputResponse.from(
                List.of("1", "2", "3"),
                List.of("1", "2", "3")
        );

        // when & then
        assertThatThrownBy(() -> {
            workerInitializeService.init(response);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("35명 초과인 경우 예외처리")
    void 인원초과_예외_테스트() {
        // given
        List<String> names = new ArrayList<>();
        for (int i = 0; i < 36; ++i) {
            names.add(String.valueOf(i));
        }
        WorkerInputResponse response = WorkerInputResponse.from(
                names,
                names
        );

        // when & then
        assertThatThrownBy(() -> {
            workerInitializeService.init(response);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("주중 근무자 중복 예외처리")
    void 주중_중복_예외_테스트() {
        // given
        WorkerInputResponse response = WorkerInputResponse.from(
                List.of("1", "1", "2", "3"),
                List.of("1", "2", "3")
        );

        // when & then
        assertThatThrownBy(() -> {
            workerInitializeService.init(response);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("주말 근무자 중복 예외처리")
    void 주말_중복_예외_테스트() {
        // given
        WorkerInputResponse response = WorkerInputResponse.from(
                List.of("1", "2", "3"),
                List.of("1", "1", "2", "3")
        );

        // when & then
        assertThatThrownBy(() -> {
            workerInitializeService.init(response);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("평일/휴일에 각각 1회씩 등장하지 않은 경우 예외처리")
    void 평일_휴일_1회씩_나오지_않은_경우() {
        // given
        WorkerInputResponse response = WorkerInputResponse.from(
                List.of("1", "2", "3"),
                List.of("1", "2", "3", "4")
        );

        // when & then
        assertThatThrownBy(() -> {
            workerInitializeService.init(response);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}