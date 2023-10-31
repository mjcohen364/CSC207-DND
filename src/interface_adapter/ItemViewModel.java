package interface_adapter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ItemViewModel extends ViewModel {

    public static final String ITEM_ADD_BUTTON_LABEL = "Add Item";
    public static final String TITLE_LABEL = "Item View";
    public static final String ITEM_LABEL = "Input API";

    private ItemState state = new ItemState();

    public ItemViewModel() {
        super("item");
    }

    public void setState(ItemState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Signup Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public ItemState getState() {
        return state;
    }
}
