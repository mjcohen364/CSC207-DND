package interface_adapter.race;
import interface_adapter.ViewManagerModel;
import use_case.race.RaceOutputData;
import use_case.race.RaceOutputBoundary;

public class RacePresenter implements RaceOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final RaceViewModel raceViewModel;
    public RacePresenter(ViewManagerModel viewManagerModel,
                         RaceViewModel raceViewModel) {
        this.raceViewModel = raceViewModel;
        this.viewManagerModel = viewManagerModel;
    }
    @Override
    public void prepareSuccessView(RaceOutputData response) {
        RaceState raceState = raceViewModel.getState();
        raceState.races = response.getRaces();
        raceState.selected = response.getSelected();
        this.raceViewModel.setState(raceState);
        raceViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(raceViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
    @Override
    public void prepareFailView(String error) {

    }
}
