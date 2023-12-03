package use_case.background;
import java.util.ArrayList;

public class BackgroundOutputData {
    private final ArrayList<String> backgrounds = new ArrayList<>();

    String selected;
    public BackgroundOutputData(ArrayList<String> backgrounds, String selected)
    {
        this.backgrounds.addAll(backgrounds);
        System.out.println(selected);
        this.selected = selected;
    }
    public ArrayList<String> getBackgrounds() {return backgrounds;}
    public String getSelected() {return selected;}
}
