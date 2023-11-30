package use_case.return_to_name;

public interface ReturnToNameOutputBoundary {
    void prepareSuccessView(ReturnToNameOutputData data);
    void prepareFailView(String error);
}
