package use_case.loggedin;

import entity.Character;

public interface LoggedInUserDataAccessInterface {
    boolean existsByName(String identifier);

    void save(Character character);

    Character get(String name);
}
