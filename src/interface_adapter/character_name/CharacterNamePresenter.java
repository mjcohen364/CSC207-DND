package interface_adapter.character_name;

import interface_adapter.ViewManagerModel;
import interface_adapter.character_creator.CharacterCreatorState;
import interface_adapter.character_creator.CharacterCreatorViewModel;
import use_case.character_name.CharacterNameOutputData;
import use_case.character_name.CharacterNameOutputBoundary;
import view.CharacterCreatorView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CharacterNamePresenter implements CharacterNameOutputBoundary {
    private final CharacterCreatorViewModel characterCreatorViewModel;
    private final CharacterCreatorView characterCreatorView;
    private final CharacterNameViewModel characterNameViewModel;
    private final ViewManagerModel viewManagerModel;

    public CharacterNamePresenter(ViewManagerModel viewManagerModel,
                                  CharacterNameViewModel characterNameViewModel,
                                  CharacterCreatorViewModel characterCreatorViewModel,
                                  CharacterCreatorView characterCreatorView) {
        this.viewManagerModel = viewManagerModel;
        this.characterNameViewModel = characterNameViewModel;
        this.characterCreatorViewModel = characterCreatorViewModel;
        this.characterCreatorView = characterCreatorView;
    }

    @Override
    public void prepareSuccessView(CharacterNameOutputData response) {
        // On success, switch to the character creator view.
        LocalDateTime responseTime = LocalDateTime.parse(response.getCreationTime());
        response.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));

        CharacterNameState characterNameState = characterNameViewModel.getState();
        characterNameState.names.add(response.getName());
        characterNameViewModel.setState(characterNameState);
        CharacterCreatorState characterCreatorState = characterCreatorViewModel.getState();
        characterCreatorState.setName(response.getName());
        this.characterCreatorViewModel.setState(characterCreatorState);
        characterCreatorViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(characterCreatorView.viewName);
        viewManagerModel.firePropertyChanged();
    }


    @Override
    public void prepareFailView(String error) {
        CharacterNameState characterNameState = characterNameViewModel.getState();
        characterNameState.setNameError(error);
        characterNameViewModel.firePropertyChanged();
    }
}
