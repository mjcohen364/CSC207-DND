package entity;

import java.time.LocalDateTime;

public interface CharacterFactory {
    /** Requires: password is valid. */
    entity.Character create(String name, LocalDateTime now);
}
