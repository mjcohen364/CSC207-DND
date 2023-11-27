package interface_adapter.background;
import java.util.ArrayList;

public class BackgroundState {
    public ArrayList<String> backgrounds;
    public BackgroundState(BackgroundState copy) {this.backgrounds = copy.backgrounds;}
    public BackgroundState(){}
    @Override
    public String toString() {return "";}
}
