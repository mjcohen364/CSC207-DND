package use_case.character_creator;
import data_access.DataAccessObject;

public class CharacterCreatorInteractor implements CharacterCreatorInputBoundary{
    final DataAccessObject dataAccessObject;
    final CharacterCreatorOutputBoundary characterCreatorPresenter;
    public CharacterCreatorInteractor(DataAccessObject dataAccess,
                                      CharacterCreatorOutputBoundary characterCreatorOutputBoundary) {
        this.dataAccessObject = dataAccess;
        characterCreatorPresenter = characterCreatorOutputBoundary;
    }
    @Override
    public void execute() {
        var test = dataAccessObject.getCharacterName();
        characterCreatorPresenter.prepareSuccessView(new CharacterCreatorOutputData(test));
    }
}
