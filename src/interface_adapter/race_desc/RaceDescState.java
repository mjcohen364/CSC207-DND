package interface_adapter.race_desc;

public class RaceDescState {
    public String desc;
    public String api;
    public RaceDescState(RaceDescState copy) {this.desc = copy.desc;}
    public RaceDescState() {
    }
    @Override
    public String toString() {return "";}
}
