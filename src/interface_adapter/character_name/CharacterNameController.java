//package interface_adapter.character_name;
//
//import use_case.character_name.CharacterNameInputBoundary;
//import use_case.character_name.CharacterNameInputData;
//
//public class CharacterNameController {
//
//    final CharacterNameInputBoundary characterNameUseCaseInteractor;
//    public CharacterNameController(CharacterNameInputBoundary userSignupUseCaseInteractor) {
//        this.characterNameUseCaseInteractor = characterNameUseCaseInteractor;
//    }
//
//    public void execute(String username) {
//        CharacterNameInputData characterNameInputData = new CharacterNameInputData(
//                username);
//
//        characterNameUseCaseInteractor.execute(characterNameInputData);
//    }
//}
