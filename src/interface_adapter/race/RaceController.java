package interface_adapter.race;

import data_access.DataAccessObject;

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
        // Additional logic to handle a race selection
    }
}
