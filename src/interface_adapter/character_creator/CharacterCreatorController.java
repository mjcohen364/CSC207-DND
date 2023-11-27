package interface_adapter.character_creator;
import use_case.character_creator.CharacterCreatorInputBoundary;

public class CharacterCreatorController {
    final CharacterCreatorInputBoundary characterCreatorUseCaseInteractor;
    public CharacterCreatorController(CharacterCreatorInputBoundary characterCreatorUseCaseInteractor) {
        this.characterCreatorUseCaseInteractor = characterCreatorUseCaseInteractor;
    }
    public void execute() {
        characterCreatorUseCaseInteractor.execute();
    }
}
