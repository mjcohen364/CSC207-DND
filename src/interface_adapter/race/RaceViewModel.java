package interface_adapter.race;
import interface_adapter.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class RaceViewModel extends ViewModel {
    public ArrayList<String> Races = new ArrayList<>();
    public static final String TITLE_LABEL = "Choose Race";
    private RaceState state = new RaceState();
    public RaceViewModel() {super("race");}
    public void setState(RaceState state) {this.state = state;}
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public void firePropertyChanged() {support.firePropertyChange("state", null, this.state);}
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public RaceState getState() {return state;}
}
