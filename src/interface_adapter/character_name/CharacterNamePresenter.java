//package interface_adapter.character_name;
//
//import interface_adapter.ViewManagerModel;
//import interface_adapter.login.LoginState;
//import interface_adapter.login.LoginViewModel;
//import use_case.character_name.SignupOutputData;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
//public class CharacterNamePresenter implements CharacterNameOutputBoundary {
//
//    private final CharacterNameViewModel characterNameViewModel;
//    private final LoginViewModel loginViewModel;
//    private ViewManagerModel viewManagerModel;
//
//    public CharacterNamePresenter(ViewManagerModel viewManagerModel,
//                                  CharacterNameViewModel characterNameViewModel,
//                           LoginViewModel loginViewModel) {
//        this.viewManagerModel = viewManagerModel;
//        this.CharacterNameViewModel = characterNameViewModel;
//        this.loginViewModel = loginViewModel;
//    }
//
//    @Override
//    public void prepareSuccessView(SignupOutputData response) {
//        // On success, switch to the login view.
//        LocalDateTime responseTime = LocalDateTime.parse(response.getCreationTime());
//        response.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
//
//        LoginState loginState = loginViewModel.getState();
//        loginState.setUsername(response.getUsername());
//        this.loginViewModel.setState(loginState);
//        loginViewModel.firePropertyChanged();
//
//        viewManagerModel.setActiveView(loginViewModel.getViewName());
//        viewManagerModel.firePropertyChanged();
//    }
//
//    @Override
//    public void prepareFailView(String error) {
//        CharacterNameState signupState = characterNameViewModel.getState();
//        characterNameState.setNameError(error);
//        characterNameViewModel.firePropertyChanged();
//    }
//}
