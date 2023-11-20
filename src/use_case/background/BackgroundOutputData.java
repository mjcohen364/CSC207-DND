package use_case.background;
import java.util.ArrayList;

public class BackgroundOutputData {
    private final ArrayList<String> backgrounds = new ArrayList<>();
    public BackgroundOutputData(ArrayList<String> races) {this.backgrounds.addAll(races);}
    public ArrayList<String> getBackgrounds() {return backgrounds;}
}
