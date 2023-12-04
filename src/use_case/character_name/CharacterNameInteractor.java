package use_case.character_name;

import data_access.DataAccessObject;
import entity.Character;
import entity.CharacterFactory;
import entity.PlayerCreator;

import java.time.LocalDateTime;

public class CharacterNameInteractor implements CharacterNameInputBoundary {
    final CharacterNameDataAccessInterface characterNameDataAccessObject;

    DataAccessObject dataAccessObject;
    final CharacterNameOutputBoundary characterNamePresenter;
    final CharacterFactory characterFactory;

    public CharacterNameInteractor(CharacterNameDataAccessInterface characterNameDataAccessInterface,
                                   CharacterNameOutputBoundary characterNameOutputBoundary,
                            CharacterFactory characterFactory, DataAccessObject dataAccessObject) {
        this.dataAccessObject = dataAccessObject;
        this.characterNameDataAccessObject = characterNameDataAccessInterface;
        this.characterNamePresenter = characterNameOutputBoundary;
        this.characterFactory = characterFactory;
    }

    @Override
    public void execute(CharacterNameInputData characterNameInputData) {
        dataAccessObject.player = PlayerCreator.readjson3(characterNameInputData.getName() + ".txt");
        if (dataAccessObject.player == null) {
            dataAccessObject.player = new PlayerCreator();
        }
        dataAccessObject.player.setname(characterNameInputData.getName());
        if (characterNameDataAccessObject.existsByName(characterNameInputData.getName())) {
            characterNamePresenter.prepareFailView("Character already exists.");
        } else {
            LocalDateTime now = LocalDateTime.now();
            Character character = characterFactory.create(characterNameInputData.getName(), now);
            characterNameDataAccessObject.save(character);

            CharacterNameOutputData characterNameOutputData = new CharacterNameOutputData(character.getName(), now.toString(), false);
            characterNamePresenter.prepareSuccessView(characterNameOutputData);
        }
    }
}