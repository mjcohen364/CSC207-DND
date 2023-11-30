package use_case.desc;

public interface DescOutputBoundary {
    void prepareSuccessView(DescOutputData desc);
    void prepareFailView(String error);
}
