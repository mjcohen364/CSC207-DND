package interface_adapter.race;
import java.util.ArrayList;

public class RaceState {
    public ArrayList<String> races;
    public RaceState(RaceState copy) {this.races = copy.races;}
    public RaceState(){}
    @Override
    public String toString() {return "";}
}
