//package use_case.character_name;
//
//import entity.Character;
//import entity.CharacterFactory;
//
//import java.time.LocalDateTime;
//
//public class CharacterNameInteractor implements CharacterNameInputBoundary {
//    final CharacterNameUserDataAccessInterface characterNameDataAccessObject;
//    final CharacterNameOutputBoundary characterNamePresenter;
//    final CharacterFactory characterFactory;
//
//    public CharacterNameInteractor(CharacterNameUserDataAccessInterface characterNameDataAccessInterface,
//                                   CharacterNameOutputBoundary characterNameOutputBoundary,
//                            CharacterFactory characterFactory) {
//        this.characterNameDataAccessObject = characterNameDataAccessInterface;
//        this.characterNamePresenter = characterNameOutputBoundary;
//        this.characterFactory = characterFactory;
//    }
//
//    @Override
//    public void execute(CharacterNameInputData characterNameInputData) {
//        if (characterNameDataAccessObject.existsByName(characterNameInputData.getName())) {
//            characterNamePresenter.prepareFailView("Character already exists.");
//        } else {
//
//            LocalDateTime now = LocalDateTime.now();
//            Character character = characterFactory.create(CharacterNameInputData.getName(), now);
//            characterNameDataAccessObject.save(character);
//
//            CharacterNameOutputData characterNameOutputData = new CharacterNameOutputData(character.getName(), now.toString(), false);
//            characterNamePresenter.prepareSuccessView(characterNameOutputData);
//        }
//    }
//}