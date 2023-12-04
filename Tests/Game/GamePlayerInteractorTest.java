package Game;

import entity.GamePlayer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.game.CollisionInteractor;
import use_case.game.GamePlayerInteractor;
import use_case.game.KeyHandlerInteractor;
import use_case.game.TileManagerInteractor;

import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.*;

class GamePlayerInteractorTest {

    private GamePlayerInteractor gamePlayerInteractor;
    private CollisionInteractor cChecker;
    private KeyHandlerInteractor keyHandler;
    private GamePlayer gamePlayer;

    private TileManagerInteractor TileM;
    @BeforeEach
    void setUp() {
        // Assuming these constructors don't have external dependencies
        TileM = new TileManagerInteractor();
        cChecker = new CollisionInteractor(TileM);
        keyHandler = new KeyHandlerInteractor(/* dependencies if any */);
        gamePlayer = new GamePlayer();

        // Initialize the GamePlayerInteractor
        gamePlayerInteractor = new GamePlayerInteractor(keyHandler, cChecker, "wizard", gamePlayer);
    }

    @Test
    void testPlayerMovement() {
        keyHandler.upPressed = true;
        gamePlayer.speed = 10;
        int initialY = gamePlayer.worldY;

        gamePlayerInteractor.update();

        assertEquals(initialY - 10, gamePlayer.worldY, "Player should have moved up");
    }


}
