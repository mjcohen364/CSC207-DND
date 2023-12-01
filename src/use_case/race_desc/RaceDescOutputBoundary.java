package use_case.race_desc;

public interface RaceDescOutputBoundary {
    void prepareSuccessView(RaceDescOutputData desc);
    void prepareFailView(String error);
}
