package interface_adapter.desc;

import use_case.desc.DescInputData;
import use_case.desc.DescOutputData;
import use_case.desc.DescOutputBoundary;

public class DescPresenter implements DescOutputBoundary {
    private final DescViewModel descViewModel;
    public DescPresenter(DescViewModel descViewModel) {this.descViewModel = descViewModel;}
    @Override
    public void prepareSuccessView(DescOutputData response) {
        DescState descState = descViewModel.getState();
        descState.desc = response.getDesc();
        this.descViewModel.setState(descState);
        descViewModel.firePropertyChanged();
    }
    @Override
    public void prepareFailView(String error) {

    }
}
