package interface_adapter.character_name;

import use_case.character_name.CharacterNameInputBoundary;
import use_case.character_name.CharacterNameInputData;

public class CharacterNameController {

    final CharacterNameInputBoundary characterNameUseCaseInteractor;
    public CharacterNameController(CharacterNameInputBoundary characterNameUseCaseInteractor) {
        this.characterNameUseCaseInteractor = characterNameUseCaseInteractor;
    }

    public void execute(String name) {
        CharacterNameInputData characterNameInputData = new CharacterNameInputData(
                name);

        characterNameUseCaseInteractor.execute(characterNameInputData);
    }
}
