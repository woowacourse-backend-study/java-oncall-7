package oncall.io;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String DELIMITER = ",";
    private InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = new InputValidator();
    }

    public String[] inputMonthDayOfTheWeek() throws IllegalArgumentException {
        System.out.println("비상 근무를 배정할 월과 시작 요일을 입력하세요>");
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
        System.out.println("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
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
        System.out.println("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요>");
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
