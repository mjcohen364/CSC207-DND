package entity;

import java.time.LocalDateTime;

public class PlayerFactory implements CharacterFactory {
    /**
     * Requires: password is valid.
     * @param name
     * @return Character
     */

    @Override
    public entity.Character create(String name, LocalDateTime now) {
        return new Player(/*name*/);
    }
}
