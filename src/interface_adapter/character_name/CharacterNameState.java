package interface_adapter.character_name;

public class CharacterNameState {
    private String name = "";
    private String nameError = null;

    public CharacterNameState(CharacterNameState copy) {
        name = copy.name;
        nameError = copy.nameError;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public CharacterNameState() {
    }

    public String getName() {
        return name;
    }

    public String getNameError() {
        return nameError;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNameError(String nameError) {
        this.nameError = nameError;
    }

    @Override
    public String toString() {
        return "CharacterNameState{" +
                "name='" + name + '\'' +
                '}';
    }
}
