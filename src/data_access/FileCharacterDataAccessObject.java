package data_access;

import entity.Character;
import entity.CharacterFactory;
import use_case.clear_users.ClearUserDataAccessInterface;
import use_case.loggedin.LoggedInUserDataAccessInterface;
import use_case.character_name.CharacterNameDataAccessInterface;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class FileCharacterDataAccessObject implements CharacterNameDataAccessInterface, LoggedInUserDataAccessInterface, ClearUserDataAccessInterface {

    private final File jsonFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, Character> characters = new HashMap<>();

    private CharacterFactory characterFactory;

    public FileCharacterDataAccessObject(String jsonPath, CharacterFactory characterFactory) throws IOException {
        this.characterFactory = characterFactory;

        jsonFile = new File(jsonPath);
        headers.put("username", 0);
        headers.put("password", 1);
        headers.put("creation_time", 2);

        if (jsonFile.length() == 0) {
            save();
        } else {

            try (BufferedReader reader = new BufferedReader(new FileReader(jsonFile))) {
                String header = reader.readLine();

                // For later: clean this up by creating a new Exception subclass and handling it in the UI.
                assert header.equals("name,creation_time");

                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
                    String name = String.valueOf(col[headers.get("name")]);
                    String creationTimeText = String.valueOf(col[headers.get("creation_time")]);
                    LocalDateTime ldt = LocalDateTime.parse(creationTimeText);
                    Character character = characterFactory.create(name, ldt);
                    characters.put(name, character);
                }
            }
        }
    }

    @Override
    public void save(Character character) {
        characters.put(character.getName(), character);
        this.save();
    }

    public Set clear() {
        Set usernames = new HashSet<>(characters.keySet());
        this.clearCharacters();
        return usernames;
    }

    @Override
    public Character get(String name) {
        return characters.get(name);
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(jsonFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (Character character : characters.values()) {
                String line = String.format("%s,%s,%s",
                        character.getName(), character.getCreationTime());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void clearCharacters() {
        characters.clear();
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(jsonFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Return whether a user exists with username identifier.
     * @param identifier the username to check.
     * @return whether a user exists with username identifier
     */
    @Override
    public boolean existsByName(String identifier) {
        return characters.containsKey(identifier);
    }

}
