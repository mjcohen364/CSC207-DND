package interface_adapter.return_to_name;

import use_case.return_to_name.ReturnToNameInputBoundary;

public class ReturnToNameController {
    final ReturnToNameInputBoundary returnToNameUseCaseInteractor;
    public ReturnToNameController(ReturnToNameInputBoundary returnToNameUseCaseInteractor) {
        this.returnToNameUseCaseInteractor = returnToNameUseCaseInteractor;
    }
    public void execute() {
        this.returnToNameUseCaseInteractor.execute();
    }
}
