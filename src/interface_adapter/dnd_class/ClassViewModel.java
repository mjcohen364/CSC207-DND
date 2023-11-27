package interface_adapter.dnd_class;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ClassViewModel extends ViewModel {

    public ArrayList<String> Classes = new ArrayList<>();
    public static final String TITLE_LABEL = "Choose Class";
    public static final String MAIN_SCREEN_LABEL = "Return to Main Screen";

    private ClassState state = new ClassState();

    public ClassViewModel() {
        super("Choose Class");
    }

    public void setState(ClassState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public ClassState getState() {
        return state;
    }
}
