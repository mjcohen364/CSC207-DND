package interface_adapter.back_desc;


public class BackDescState {
    public String desc;
    public String api;
    public BackDescState(BackDescState copy) {this.desc = copy.desc;}
    public BackDescState() {
    }
    @Override
    public String toString() {return "";}
}
