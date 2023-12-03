package use_case.race;
import java.util.ArrayList;

public class RaceOutputData {
    private final ArrayList<String> races = new ArrayList<>();

    private String selected;
    public RaceOutputData(ArrayList<String> races, String selected) {this.races.addAll(races);
        this.selected = selected;
    }
    public ArrayList<String> getRaces() {return races;}
    public String getSelected() {return selected;}
}
