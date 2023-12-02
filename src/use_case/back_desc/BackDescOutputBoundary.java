package use_case.back_desc;

public interface BackDescOutputBoundary {
    void prepareSuccessView(BackDescOutputData desc);
    void prepareFailView(String error);
}
