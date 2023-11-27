package interface_adapter.character_creator;
import interface_adapter.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CharacterCreatorViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Create Character";
    public static final String MAIN_SCREEN_LABEL = "Return to Main Screen";
    private CharacterCreatorState state = new CharacterCreatorState();
    public CharacterCreatorViewModel() {super("character creator");}
    public void setState(CharacterCreatorState state) {this.state = state;}
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public void firePropertyChanged() {support.firePropertyChange("state", null, this.state);}
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public CharacterCreatorState getState() {return state;}
}
