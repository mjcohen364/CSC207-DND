package interface_adapter.character_creator;

public class CharacterCreatorState {
    public String characterName;
    public CharacterCreatorState(CharacterCreatorState copy) {this.characterName = copy.characterName;}
    public CharacterCreatorState() {}
    @Override
    public String toString() {return "";}
    public void setName(String name) {
        this.characterName = name;
    }
}
