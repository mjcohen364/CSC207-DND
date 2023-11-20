package interface_adapter.background;

import use_case.background.BackgroundOutputBoundary;
import use_case.background.BackgroundOutputData;

public class BackgroundPresenter implements BackgroundOutputBoundary {
    private final BackgroundViewModel backgroundViewModel;
    public BackgroundPresenter(BackgroundViewModel backgroundViewModel) {this.backgroundViewModel = backgroundViewModel;}
    @Override
    public void prepareSuccessView(BackgroundOutputData response) {
        BackgroundState backgroundState = backgroundViewModel.getState();
        backgroundState.backgrounds = response.getBackgrounds();
        backgroundViewModel.firePropertyChanged();
    }
    @Override
    public void prepareFailView(String error) {

    }
}
