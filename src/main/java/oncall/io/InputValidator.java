package oncall.io;

import oncall.DayOfTheWeek;
import oncall.Member;
import oncall.MemberFactory;
import oncall.Month;

public class InputValidator {

    public void validateMonthDayOfTheWeek(String[] inputs) throws IllegalArgumentException {
        if (inputs.length != 2) {
            throw new IllegalArgumentException("유효하지 않은 입력 값입니다.");
        }
        Month.getMonth(inputs[0]);
        DayOfTheWeek.getDayOfTheWeek(inputs[1]);
    }

    public void validateMember(String[] inputs) {
        if (inputs.length <= 2) {
            throw new IllegalArgumentException("유효하지 않은 입력 값입니다.");
        }
        MemberFactory memberFactory = new MemberFactory();
        for (String name : inputs) {
            memberFactory.addMember(new Member(name));
        }
    }
}
