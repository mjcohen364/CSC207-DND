package interface_adapter.back_desc;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class BackDescViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Description";
    private BackDescState state = new BackDescState();
    public BackDescViewModel() {super("Description");}
    public void setState(BackDescState state) {this.state = state;}
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public void firePropertyChanged() {
        support.firePropertyChange("DescState", null, state);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public BackDescState getState() {return state;}
}
