package entity;

import java.time.LocalDateTime;

public interface CharacterFactory {
    /** Requires: password is valid. */
    Character create(String name);
}
