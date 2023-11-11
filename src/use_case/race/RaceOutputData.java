package use_case.race;
import java.util.ArrayList;

public class RaceOutputData {
    private final ArrayList<String> races = new ArrayList<>();
    public RaceOutputData(ArrayList<String> races) {this.races.addAll(races);}
    public ArrayList<String> getRaces() {return races;}
}
