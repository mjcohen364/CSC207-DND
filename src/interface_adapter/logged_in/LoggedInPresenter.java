package interface_adapter.logged_in;

import use_case.loggedin.LoggedInOutputBoundary;
import use_case.loggedin.LoggedInOutputData;

public class LoggedInPresenter implements LoggedInOutputBoundary {
    @Override
    public void prepareSuccessView(LoggedInOutputData user) {

    }

    @Override
    public void prepareFailView(String error) {

    }
}
