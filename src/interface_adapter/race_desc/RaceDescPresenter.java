package interface_adapter.race_desc;

import use_case.race_desc.RaceDescOutputData;
import use_case.race_desc.RaceDescOutputBoundary;

public class RaceDescPresenter implements RaceDescOutputBoundary {
    private final RaceDescViewModel raceDescViewModel;
    public RaceDescPresenter(RaceDescViewModel raceDescViewModel) {this.raceDescViewModel = raceDescViewModel;}
    @Override
    public void prepareSuccessView(RaceDescOutputData response) {
        RaceDescState raceDescState = raceDescViewModel.getState();
        raceDescState.desc = response.getDesc();
        this.raceDescViewModel.setState((RaceDescState) raceDescState);
        raceDescViewModel.firePropertyChanged();
    }
    @Override
    public void prepareFailView(String error) {

    }
}
