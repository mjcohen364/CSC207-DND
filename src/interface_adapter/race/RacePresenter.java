package interface_adapter.race;
import use_case.race.RaceOutputData;
import use_case.race.RaceOutputBoundary;

public class RacePresenter implements RaceOutputBoundary {
    private final RaceViewModel raceViewModel;
    public RacePresenter(RaceViewModel raceViewModel) {this.raceViewModel = raceViewModel;}
    @Override
    public void prepareSuccessView(RaceOutputData response) {
        RaceState raceState = raceViewModel.getState();
        raceState.races = response.getRaces();
        raceViewModel.firePropertyChanged();
    }
    @Override
    public void prepareFailView(String error) {

    }
}
