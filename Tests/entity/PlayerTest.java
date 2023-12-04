package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Player player;
    LocalDateTime time;
    @BeforeEach
    void init() {
        PlayerFactory pf = new PlayerFactory();
        time = LocalDateTime.now();
        player = (Player) pf.create("Paul", time);
    }

    @Test
    void getName() {
        player.setName("Emily");
        assertEquals("Emily", player.getName());
    }

    @Test
    void getCreationTime() {
        assertEquals(time, player.getCreationTime());
    }

    @Test
    void getArmourClass() {
        ArmourClass armourClass = new ArmourClass(10, 10, "nothing");
        player.setArmourClass(armourClass);
        assertEquals(armourClass, player.getArmourClass());
    }

    @Test
    void getSize() {
        Size size = Size.Tiny;
        player.setSize(size);
        assertEquals(Size.Tiny, player.getSize());
    }

    @Test
    void getBackground() {
        Background background = new Background();
        player.setBackground(background);
        assertEquals(background, player.getBackground());
    }
}