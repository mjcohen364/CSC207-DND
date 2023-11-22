package interface_adapter.race;

import data_access.DataAccessObject;
import entity.Race;
import use_case.race.RaceDetailsInteractor;

public class RaceController {
    private RaceViewModel raceViewModel;
    private DataAccessObject dataAccessObject;

    public RaceController(RaceViewModel raceViewModel, DataAccessObject dataAccessObject) {
        this.raceViewModel = raceViewModel;
        this.dataAccessObject = dataAccessObject;
    }

    public void loadRaces() {
        raceViewModel.setRaceNames(dataAccessObject.getRaces());
    }


    public void selectRace(String race) {
        raceViewModel.setSelectedRace(race);
        // Fetch the race details using the interactor
        RaceDetailsInteractor raceDetailsInteractor = new RaceDetailsInteractor();
        Race raceDetails = raceDetailsInteractor.getRaceDetails(race.toLowerCase());
        // Here you would update the RaceViewModel with the details of the race
        raceViewModel.setRaceDetails(raceDetails); // Assuming this setter is implemented
    }



}
