package use_case.return_to_name;

public class ReturnToNameInteractor implements ReturnToNameInputBoundary {
    final ReturnToNameOutputBoundary returnPresenter;
    public ReturnToNameInteractor(ReturnToNameOutputBoundary returnToNameOutputBoundary) {
        returnPresenter = returnToNameOutputBoundary;
    }
    @Override
    public void execute() {
        returnPresenter.prepareSuccessView(new ReturnToNameOutputData());
    }
}
