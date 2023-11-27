package interface_adapter.background;

import interface_adapter.ViewManagerModel;
import use_case.background.BackgroundOutputBoundary;
import use_case.background.BackgroundOutputData;

import javax.swing.text.View;

public class BackgroundPresenter implements BackgroundOutputBoundary {
    private final BackgroundViewModel backgroundViewModel;
    private final ViewManagerModel viewManagerModel;
    public BackgroundPresenter(ViewManagerModel viewManagerModel, BackgroundViewModel backgroundViewModel) {
        this.backgroundViewModel = backgroundViewModel;
        this.viewManagerModel = viewManagerModel;
    }
    @Override
    public void prepareSuccessView(BackgroundOutputData response) {
        BackgroundState backgroundState = backgroundViewModel.getState();
        backgroundState.backgrounds = response.getBackgrounds();
        this.backgroundViewModel.setState(backgroundState);
        backgroundViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(backgroundViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
    @Override
    public void prepareFailView(String error) {

    }
}
