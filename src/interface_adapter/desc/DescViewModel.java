package interface_adapter.desc;

import interface_adapter.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DescViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Description";
    private DescState state = new DescState();
    public DescViewModel() {super("Description");}
    public void setState(DescState state) {this.state = state;}
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public void firePropertyChanged() {support.firePropertyChange("state", null, this.state);}
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public DescState getState() {return state;}
}
