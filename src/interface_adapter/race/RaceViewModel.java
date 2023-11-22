package interface_adapter.race;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import entity.Race;

import java.util.List;

public class RaceViewModel {
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    private List<String> raceNames;
    private String selectedRace;
    private Race raceDetails;


    public RaceViewModel() {

    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }



    public List<String> getRaceNames() {
        return raceNames;
    }

    public void setRaceNames(List<String> raceNames) {
        this.raceNames = raceNames;

    }

    public String getSelectedRace() {
        return selectedRace;
    }
    public Race getRaceDetails(){
        return raceDetails;
    }

    public void setSelectedRace(String selectedRace) {
        this.selectedRace = selectedRace;

    }

    public void setRaceDetails(Race raceDetails) {
        this.raceDetails = raceDetails;
        // Notify observers that the race details have changed
        // For example, if you're using PropertyChangeSupport:
        propertyChangeSupport.firePropertyChange("raceDetails", null, raceDetails);
    }
}

