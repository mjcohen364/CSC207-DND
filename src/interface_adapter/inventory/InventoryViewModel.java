package interface_adapter.inventory;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class InventoryViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Inventory";

    private InventoryState state = new InventoryState();

    public InventoryViewModel() {
        super("inventory");
    }

    public void setState(InventoryState state) {
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

    public InventoryState getState() {
        return state;
    }
}
