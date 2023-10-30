package use_case.clear_users;

// TODO Complete me seems good

public interface ClearOutputBoundary {
    void prepareSuccessView(ClearOutputData usernames);

    void prepareFailView(String error);
}
