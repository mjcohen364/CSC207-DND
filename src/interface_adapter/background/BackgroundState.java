package interface_adapter.background;
import java.util.ArrayList;

public class BackgroundState {
    public ArrayList<String> backgrounds;

    public String selected;
    public BackgroundState(BackgroundState copy) {this.backgrounds = copy.backgrounds;
    this.selected = copy.selected;}
    public BackgroundState(){}
    @Override
    public String toString() {return "";}
}
