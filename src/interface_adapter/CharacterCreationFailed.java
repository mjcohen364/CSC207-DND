package interface_adapter;

public class CharacterCreationFailed extends RuntimeException {
    public CharacterCreationFailed(String error) {
        super(error);
    }
}
