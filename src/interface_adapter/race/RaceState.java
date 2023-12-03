package interface_adapter.race;
import java.util.ArrayList;

public class RaceState {
    public ArrayList<String> races;

    public String selected;
    public RaceState(RaceState copy) {
        this.races = copy.races;
        this.selected = copy.selected;
    }
    public RaceState(){}
    @Override
    public String toString() {return "";}
}
