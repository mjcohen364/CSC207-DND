package interface_adapter.return_to_name;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ReturnToNameViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Name a Character!";
    private ReturnToNameState state = new ReturnToNameState();
    public ReturnToNameViewModel() {super("Name a Character!");}
    public void setState(ReturnToNameState state) {this.state = state;}
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public void firePropertyChanged() {support.firePropertyChange("state", null, this.state);}
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public ReturnToNameState getState() {return state;}
}
