package interface_adapter.race_desc;

import interface_adapter.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class RaceDescViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Description";
    private RaceDescState state = new RaceDescState();
    public RaceDescViewModel() {super("Description");}
    public void setState(RaceDescState state) {this.state = state;}
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public void firePropertyChanged() {
        support.firePropertyChange("DescState", null, state);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public RaceDescState getState() {return state;}
}
