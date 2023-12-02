package use_case.desc;

public interface RaceDescOutputBoundary {
    void prepareSuccessView(RaceDescOutputData desc);
    void prepareFailView(String error);
}
