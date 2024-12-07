package oncall;

import oncall.io.InputValidator;
import oncall.io.InputView;
import oncall.io.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView(new InputValidator());
        OutputView outputView = new OutputView();
        CompanyProgram companyProgram = new CompanyProgram(inputView, outputView);

        companyProgram.startProgram();
    }
}
