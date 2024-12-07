package oncall.io;

import oncall.DayOfTheWeek;
import oncall.Member;
import oncall.MemberFactory;
import oncall.Month;

public class InputValidator {

    private static final String INVALID_INPUT_MESSAGE = "유효하지 않은 입력 값입니다.";

    public void validateMonthDayOfTheWeek(String[] inputs) throws IllegalArgumentException {
        if (inputs.length != 2) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
        Month.getMonth(inputs[0]);
        DayOfTheWeek.getDayOfTheWeek(inputs[1]);
    }

    public void validateMember(String[] inputs) {
        if (inputs.length <= 2) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
        MemberFactory memberFactory = new MemberFactory();
        for (String name : inputs) {
            memberFactory.addMember(new Member(name));
        }
    }
}
