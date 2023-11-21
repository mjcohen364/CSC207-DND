package interface_adapter.race;

import java.util.List;

public class RaceViewModel {
    private List<String> raceNames;
    private String selectedRace;

    // Constructor if needed
    public RaceViewModel() {
        // Initialize with empty or default values if necessary
    }

    public List<String> getRaceNames() {
        return raceNames;
    }

    public void setRaceNames(List<String> raceNames) {
        this.raceNames = raceNames;
        // If you have observers, notify them of the update
    }

    public String getSelectedRace() {
        return selectedRace;
    }

    public void setSelectedRace(String selectedRace) {
        this.selectedRace = selectedRace;
        // If you have observers, notify them of the update
    }
}

