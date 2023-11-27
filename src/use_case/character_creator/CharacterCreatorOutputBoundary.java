package use_case.character_creator;

public interface CharacterCreatorOutputBoundary {
    void prepareSuccessView(CharacterCreatorOutputData user);
    void prepareFailView(String error);
}
