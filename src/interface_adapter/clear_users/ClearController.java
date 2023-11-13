package interface_adapter.clear_users;

import use_case.clear_users.ClearInputBoundary;
import use_case.clear_users.ClearInputData;

// TODO Complete me seems good
public class ClearController {

    final ClearInputBoundary clearUseCaseInteractor;
    public ClearController(ClearInputBoundary clearUseCaseInteractor) {
        this.clearUseCaseInteractor = clearUseCaseInteractor;
    }

    public void execute() {
        ClearInputData clearInputData = new ClearInputData();

        clearUseCaseInteractor.execute(clearInputData);
    }
}
