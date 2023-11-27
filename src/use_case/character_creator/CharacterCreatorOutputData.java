package use_case.character_creator;

public class CharacterCreatorOutputData {
    private final String characterName;
    public CharacterCreatorOutputData(String characterName) {
        this.characterName = characterName;
    }
    public String getCharacterName() {return characterName;}
}
