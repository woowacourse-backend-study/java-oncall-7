package oncall.io;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String DELIMITER = ",";
    private static final String INPUT_MONTH_DAY_OF_THE_WEEK_MESSAGE = "비상 근무를 배정할 월과 시작 요일을 입력하세요>";
    private static final String INPUT_WEEK_DAY_MEMBER = "평일 비상 근무 순번대로 사원 닉네임을 입력하세요>";
    private static final String INPUT_WEEK_END_MEMBER = "휴일 비상 근무 순번대로 사원 닉네임을 입력하세요>";
    private final InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = new InputValidator();
    }

    public String[] inputMonthDayOfTheWeek() throws IllegalArgumentException {
        System.out.println(INPUT_MONTH_DAY_OF_THE_WEEK_MESSAGE);
        String input = Console.readLine();
        try {
            String[] inputs = input.split(DELIMITER);
            inputValidator.validateMonthDayOfTheWeek(inputs);
            return inputs;

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public String[] inputWeekDayMember() throws IllegalArgumentException {
        System.out.println(INPUT_WEEK_DAY_MEMBER);
        String weekDayInput = Console.readLine();
        try {
            String[] inputs = weekDayInput.split(DELIMITER);
            inputValidator.validateMember(inputs);
            return inputs;

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public String[] inputWeekEndMember() throws IllegalArgumentException {
        System.out.println(INPUT_WEEK_END_MEMBER);
        String weekEndInput = Console.readLine();
        try {
            String[] inputs = weekEndInput.split(DELIMITER);
            inputValidator.validateMember(inputs);
            return inputs;

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
