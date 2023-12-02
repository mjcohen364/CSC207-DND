package data_access;

import java.io.File;
import entity.Character;
import entity.CharacterFactory;
import use_case.clear_users.ClearUserDataAccessInterface;
import use_case.character_name.CharacterNameDataAccessInterface;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class FileCharacterDataAccessObject implements CharacterNameDataAccessInterface, ClearUserDataAccessInterface {
    private final Map<String, Character> characters = new HashMap<>();

    public FileCharacterDataAccessObject() throws IOException {
    }

    @Override
    public void save(Character character) {
        characters.put(character.getName(), character);
    }

    public Set clear() {
        Set names = new HashSet<>(characters.keySet());
        this.clearCharacters();
        return names;
    }

    public Character get(String name) {
        return characters.get(name);
    }

    private void clearCharacters() {
        characters.clear();
        File[] characters = new File("src/characters").listFiles();

        assert characters != null;
        for (File file : characters) {
            file.delete();
        }
    }


    /**
     * Return whether a character exists in the character folder with character identifier.
     * @param identifier the character name to check.
     * @return whether a character exists with character identifier
     */
    @Override
    public boolean existsByName(String identifier) {
        boolean found = false;
        File[] characters = new File("src/characters").listFiles();

        assert characters != null;
        for (File file : characters) {
            if (file.getName().equals(identifier)) {
                found = true;
                break;
            }
        }
        return found;
    }
}
