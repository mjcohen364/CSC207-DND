//package interface_adapter.clear_users;
//
//// TODO Complete me
//
//import interface_adapter.ViewManagerModel;
//import interface_adapter.signup.SignupViewModel;
//import use_case.clear_users.ClearOutputBoundary;
//import use_case.clear_users.ClearOutputData;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
//public class ClearPresenter implements ClearOutputBoundary {
//
//    private final SignupViewModel signupViewModel;
//    private final ClearViewModel clearViewModel;
//    private ViewManagerModel viewManagerModel;
//
//    public ClearPresenter(ViewManagerModel viewManagerModel,
//                           ClearViewModel clearViewModel,
//                           SignupViewModel signupViewModel) {
//        this.viewManagerModel = viewManagerModel;
//        this.clearViewModel = clearViewModel;
//        this.signupViewModel = signupViewModel;
//    }
//
//    @Override
//    public void prepareSuccessView(ClearOutputData response) {
//        // On success, switch to the signup view.
//        LocalDateTime responseTime = LocalDateTime.parse(response.getCreationTime());
//        response.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
//
//        ClearState clearState = clearViewModel.getState();
//        clearState.setUsernames(response.getUsernames());
//        this.clearViewModel.setState(clearState);
//        clearViewModel.firePropertyChanged();
//
//        viewManagerModel.setActiveView(clearViewModel.getViewName());
//        viewManagerModel.firePropertyChanged();
//    }
//
//    @Override
//    public void prepareFailView(String error) {
//        ClearState clearState = clearViewModel.getState();
//        clearState.setUsernamesError(error);
//        clearViewModel.firePropertyChanged();
//    }
//}
