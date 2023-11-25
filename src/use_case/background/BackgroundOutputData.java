package use_case.background;
import java.util.ArrayList;

public class BackgroundOutputData {
    private final ArrayList<String> backgrounds = new ArrayList<>();
    public BackgroundOutputData(ArrayList<String> backgrounds) {this.backgrounds.addAll(backgrounds);}
    public ArrayList<String> getBackgrounds() {return backgrounds;}
}
