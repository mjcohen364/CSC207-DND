package use_case.character_name;

public interface CharacterNameOutputBoundary {
    void prepareSuccessView(CharacterNameOutputData character);

    void prepareFailView(String error);
}