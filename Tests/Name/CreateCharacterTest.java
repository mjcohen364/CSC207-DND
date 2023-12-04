//package Name;
//
//import data_access.DataAccessObject;
//import data_access.FileCharacterDataAccessObject;
//import entity.PlayerFactory;
//import org.junit.Test;
//import use_case.character_name.*;
//
//import java.io.IOException;
//
//import static org.junit.Assert.*;
//
//public class CreateCharacterTest {
//    @Test
//    public void successTest() throws IOException {
//        CharacterNameDataAccessInterface dao = new FileCharacterDataAccessObject();
//        DataAccessObject dao2 = new DataAccessObject();
//        CharacterNameOutputBoundary presenter = new CharacterNameOutputBoundary() {
//            @Override
//            public void prepareSuccessView(CharacterNameOutputData response) {
//                assertEquals("Alice", response.getName());
//                assertNotNull(response.getCreationTime());
//                assertTrue(dao.existsByName("Alice"));
//            }
//
//            @Override
//            public void prepareFailView(String error) {
//                fail("Use case failure is unexpected");
//            }
//        };
//        CharacterNameInputData inputData = new CharacterNameInputData("Alice");
//        CharacterNameInputBoundary interactor = new CharacterNameInteractor(dao, presenter, new PlayerFactory(), dao2);
//
//        interactor.execute(inputData);
//    }
//    public CreateCharacterTest() throws IOException {
//    }
//}
