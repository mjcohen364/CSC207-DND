package interface_adapter.back_desc;

import use_case.back_desc.BackDescOutputBoundary;
import use_case.back_desc.BackDescOutputData;

public class BackDescPresenter implements BackDescOutputBoundary {
    private final BackDescViewModel backDescViewModel;
    public BackDescPresenter(BackDescViewModel backDescViewModel) {this.backDescViewModel = backDescViewModel;}
    @Override
    public void prepareSuccessView(BackDescOutputData response) {
        BackDescState backDescState = backDescViewModel.getState();
        backDescState.desc = response.getDesc();
        this.backDescViewModel.setState((BackDescState) backDescState);
        backDescViewModel.firePropertyChanged();
    }
    @Override
    public void prepareFailView(String error) {

    }
}
