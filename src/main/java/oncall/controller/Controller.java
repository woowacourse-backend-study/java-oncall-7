package oncall.controller;

import oncall.service.WorkerInitializeService;
import oncall.view.InputView;
import oncall.view.OutputView;
import oncall.view.dto.DateInputResponse;
import oncall.view.dto.WorkerInputResponse;

import java.util.function.Supplier;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final WorkerInitializeService workerInitializeService;

    public Controller(
            InputView inputView,
            OutputView outputView,
            WorkerInitializeService workerInitializeService
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.workerInitializeService = workerInitializeService;
    }

    public void run() {
        DateInputResponse dateInputResponse = getDateInput();
        WorkerInputResponse workerInputResponse = getWorkerInput();
        workerInitializeService.init(workerInputResponse);
    }

    private DateInputResponse getDateInput() {
        return doLoop(inputView::getDate);
    }

    private WorkerInputResponse getWorkerInput() {
        return doLoop(inputView::getWorkers);
    }

    public <T> T doLoop(Supplier<T> function) {
        while (true) {
            try {
                return function.get();
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }
}

