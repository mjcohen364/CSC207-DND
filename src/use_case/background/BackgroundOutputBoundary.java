package use_case.background;

public interface BackgroundOutputBoundary {
    void prepareSuccessView(BackgroundOutputData user);
    void prepareFailView(String error);
}
