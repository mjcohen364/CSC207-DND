package use_case.race;

public interface RaceOutputBoundary {
    void prepareSuccessView(RaceOutputData user);
    void prepareFailView(String error);
}
