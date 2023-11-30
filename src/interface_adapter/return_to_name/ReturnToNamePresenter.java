package interface_adapter.return_to_name;

import interface_adapter.ViewManagerModel;
import use_case.return_to_name.ReturnToNameOutputBoundary;
import use_case.return_to_name.ReturnToNameOutputData;

public class ReturnToNamePresenter implements ReturnToNameOutputBoundary {
    private final ReturnToNameViewModel returnToNameViewModel;
    private final ViewManagerModel viewManagerModel;
    public ReturnToNamePresenter(ViewManagerModel viewManagerModel, ReturnToNameViewModel returnToNameViewModel) {
        this.returnToNameViewModel = returnToNameViewModel;
        this.viewManagerModel = viewManagerModel;
    }
    @Override
    public void prepareSuccessView(ReturnToNameOutputData response) {
        ReturnToNameState returnState = returnToNameViewModel.getState();
        this.returnToNameViewModel.setState(returnState);
        returnToNameViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(returnToNameViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
    @Override
    public void prepareFailView(String error) {

    }
}
