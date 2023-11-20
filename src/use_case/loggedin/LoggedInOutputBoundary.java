package use_case.loggedin;

public interface LoggedInOutputBoundary {
    void prepareSuccessView(LoggedInOutputData user);

    void prepareFailView(String error);
}