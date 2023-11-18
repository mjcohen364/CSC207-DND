package interface_adapter.background;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class BackgroundViewModel extends ViewModel {
    public ArrayList<String> Backgrounds = new ArrayList<>();
    public static final String TITLE_LABEL = "Choose Background";
    public static final String MAIN_SCREEN_LABEL = "Return to Main Screen";
    private BackgroundState state = new BackgroundState();
    public BackgroundViewModel() {super("background");}
    public void setState(BackgroundState state) {this.state = state;}
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public void firePropertyChanged() {support.firePropertyChange("state", null, this.state);}
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public BackgroundState getState() {return state;}
}
