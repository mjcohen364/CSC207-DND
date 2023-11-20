package interface_adapter.clear_characters;

import java.util.Set;

public class ClearState {
    private String name = "";
    private String nameError = null;
    private Set names;
    private String namesError = "";

    public ClearState(ClearState copy) {
        name = copy.name;
        nameError = copy.nameError;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public ClearState() {
    }

    public String getName() {
        return name;
    }

    public String getNameError() {
        return nameError;
    }
    public Set getNames() {
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
    public void setNames(Set names) {
        this.names = names;
    }

    public void setNamesError(String namesError) {
        this.namesError = namesError;
    }

    @Override
    public String toString() {
        return "ClearState{" +
                "name='" + name + '\'' +
                "names='" + names + '\'' +
                '}';
    }
}
