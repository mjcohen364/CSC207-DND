package interface_adapter.background;
import use_case.background.BackgroundInputBoundary;

public class BackgroundController {
    final BackgroundInputBoundary backgroundUseCaseInteractor;
    public BackgroundController(BackgroundInputBoundary backgroundUseCaseInteractor) {
        this.backgroundUseCaseInteractor = backgroundUseCaseInteractor;
    }
    public void execute() {
        backgroundUseCaseInteractor.execute();
    }
}
