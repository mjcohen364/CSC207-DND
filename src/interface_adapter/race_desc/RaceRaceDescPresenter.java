package interface_adapter.race_desc;

import use_case.desc.RaceDescOutputData;
import use_case.desc.RaceDescOutputBoundary;

public class RaceRaceDescPresenter implements RaceDescOutputBoundary {
    private final RaceDescViewModel raceDescViewModel;
    public RaceRaceDescPresenter(RaceDescViewModel raceDescViewModel) {this.raceDescViewModel = raceDescViewModel;}
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
