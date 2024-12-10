package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import oncall.infrastructure.constants.Message;
import oncall.view.dto.WorkerInputResponse;

public class InputView {
    public String getValue() {
        return Console.readLine().trim();
    }

    public WorkerInputResponse getWorkers() {
        System.out.print("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        String weekdayNames = Console.readLine().trim();

        System.out.print(Message.NEW_LINE.getValue());
        System.out.print("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        String holidayNames = Console.readLine().trim();

        return WorkerInputResponse.from(weekdayNames, holidayNames);
    }
}
