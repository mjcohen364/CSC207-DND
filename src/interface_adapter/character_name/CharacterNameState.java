package interface_adapter.character_name;

import java.util.ArrayList;

public class CharacterNameState {
    private String name = "";
    public ArrayList<String> names = new ArrayList<>();
    private String nameError = null;
    private String namesError = null;

    public CharacterNameState(CharacterNameState copy) {
        name = copy.name;
        nameError = copy.nameError;
        names = copy.names;
        namesError = copy.namesError;
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
    public ArrayList<String> getNames() {
        return names;
    }

    public String getNamesError() {
        return namesError;
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
