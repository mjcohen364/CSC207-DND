package interface_adapter.back_desc;

import use_case.back_desc.BackDescInputBoundary;
import use_case.back_desc.BackDescInputData;

public class BackDescController {
    final BackDescInputBoundary descUseCaseInteractor;
    public BackDescController(BackDescInputBoundary descUseCaseInteractor) {
        this.descUseCaseInteractor = descUseCaseInteractor;
    }
    public void execute(String api) {
        BackDescInputData backDescInputData = new BackDescInputData(api);

        descUseCaseInteractor.execute(backDescInputData);
    }
}
