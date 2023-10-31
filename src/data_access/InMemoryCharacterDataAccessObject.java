//package data_access;
//
//import entity.User;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class InMemoryCharacterDataAccessObject implements CharacterNameDataAccessInterface {
//
//    private final Map<String, User> users = new HashMap<>();
//
//    /**
//     * @param identifier the user's username
//     * @return whether the user exists
//     */
//    @Override
//    public boolean existsByName(String identifier) {
//        return users.containsKey(identifier);
//    }
//
//    /**
//     * @param user the data to save
//     */
//    @Override
//    public void save(User user) {
//        users.put(user.getName(), user);
//    }
//}
