package interface_adapter.character_name;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CharacterNameViewModel extends ViewModel {

    public static final String CLEAR_BUTTON_LABEL = "Clear Previous Characters";
    public static final String TITLE_LABEL = "Character Name View";
    public static final String NAME_LABEL = "Choose a Character Name";
    public static final String EDIT_BUTTON_LABEL = "Edit a Previous Character";
    public static final String PREVIOUS_CHARACTERS_LABEL = "Previous Characters";
    public static final String CREATECHARACTERNAME_BUTTON_LABEL = "Create Character";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";

    private CharacterNameState state = new CharacterNameState();

    public CharacterNameViewModel() {
        super("Name a character");
    }

    public void setState(CharacterNameState state) {
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

    public CharacterNameState getState() {
        return state;
    }
}
