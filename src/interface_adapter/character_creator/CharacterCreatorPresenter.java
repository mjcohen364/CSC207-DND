package interface_adapter.character_creator;
import interface_adapter.ViewManagerModel;
import use_case.character_creator.CharacterCreatorOutputBoundary;
import use_case.character_creator.CharacterCreatorOutputData;

public class CharacterCreatorPresenter implements CharacterCreatorOutputBoundary {
    private final CharacterCreatorViewModel characterCreatorViewModel;
    private final ViewManagerModel viewManagerModel;
    public CharacterCreatorPresenter(ViewManagerModel viewManagerModel,
                                     CharacterCreatorViewModel characterCreatorViewModel) {
        this.characterCreatorViewModel = characterCreatorViewModel;
        this.viewManagerModel = viewManagerModel;
    }
    @Override
    public void prepareSuccessView(CharacterCreatorOutputData response) {
        CharacterCreatorState characterCreatorState = characterCreatorViewModel.getState();
        this.characterCreatorViewModel.setState(characterCreatorState);
        characterCreatorState.characterName = response.getCharacterName();
        characterCreatorViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(characterCreatorViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
    @Override
    public void prepareFailView(String error) {

    }
}
