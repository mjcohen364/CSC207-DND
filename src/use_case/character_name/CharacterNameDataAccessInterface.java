package use_case.character_name;

import entity.Character;

public interface CharacterNameDataAccessInterface {
    boolean existsByName(String identifier);

    void save(Character character);
}
