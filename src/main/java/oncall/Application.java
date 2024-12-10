package oncall;

import oncall.controller.Controller;
import oncall.service.EmergencyWorkerService;
import oncall.service.WorkerInitializeService;
import oncall.view.InputView;
import oncall.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(
                new InputView(),
                new OutputView(),
                new WorkerInitializeService(),
                new EmergencyWorkerService()
        );
        controller.run();
    }
}
