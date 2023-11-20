package interface_adapter.character_name;

import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import interface_adapter.character_name.CharacterNameViewModel;
import use_case.character_name.CharacterNameOutputData;
import use_case.character_name.CharacterNameOutputBoundary;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CharacterNamePresenter implements CharacterNameOutputBoundary {
    private final CharacterNameViewModel characterNameViewModel1;
    private final LoginViewModel loginViewModel;
    private final CharacterNameViewModel characterNameViewModel;
    private ViewManagerModel viewManagerModel;

    public CharacterNamePresenter(ViewManagerModel viewManagerModel,
                                  CharacterNameViewModel characterNameViewModel,
                                  CharacterNameViewModel characterNameViewModel1, LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.characterNameViewModel1 = characterNameViewModel1;
        this.characterNameViewModel = characterNameViewModel;
        this.loginViewModel = loginViewModel;
    }

    @Override
    public void prepareSuccessView(CharacterNameOutputData response) {
        // On success, switch to the login view.
        LocalDateTime responseTime = LocalDateTime.parse(response.getCreationTime());
        response.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));

        LoginState loginState = loginViewModel.getState();
        loginState.setUsername(response.getName());
        this.loginViewModel.setState(loginState);
        loginViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }


    @Override
    public void prepareFailView(String error) {
        CharacterNameState signupState = characterNameViewModel.getState();
        characterNameState.setNameError(error);
        characterNameViewModel.firePropertyChanged();
    }
}
