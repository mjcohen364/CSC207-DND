package interface_adapter.character_name;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.character_name.CharacterNameViewModel;
import use_case.character_name.CharacterNameOutputData;
import use_case.character_name.CharacterNameOutputBoundary;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CharacterNamePresenter implements CharacterNameOutputBoundary {
    private final LoggedInViewModel loggedInViewModel;
    private final CharacterNameViewModel characterNameViewModel;
    private final ViewManagerModel viewManagerModel;

    public CharacterNamePresenter(ViewManagerModel viewManagerModel,
                                  CharacterNameViewModel characterNameViewModel, LoggedInViewModel loggedInViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.characterNameViewModel = characterNameViewModel;
        this.loggedInViewModel = loggedInViewModel;
    }

    @Override
    public void prepareSuccessView(CharacterNameOutputData response) {
        // On success, switch to the login view.
        LocalDateTime responseTime = LocalDateTime.parse(response.getCreationTime());
        response.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));

        LoggedInState loginState = loggedInViewModel.getState();
        loginState.setUsername(response.getName());
        this.loggedInViewModel.setState(loginState);
        loggedInViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(loggedInViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }


    @Override
    public void prepareFailView(String error) {
        CharacterNameState characterNameState = characterNameViewModel.getState();
        characterNameState.setNameError(error);
        characterNameViewModel.firePropertyChanged();
    }
}
