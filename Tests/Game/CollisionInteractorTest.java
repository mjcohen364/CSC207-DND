package Game;

import entity.GamePlayer;
import entity.Tile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.game.CollisionInteractor;
import use_case.game.TileManagerInteractor;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CollisionInteractorTest {

    private CollisionInteractor collisionInteractor;
    private GamePlayer player;
    private TileManagerInteractorStub tileManagerInteractorStub;

    @BeforeEach
    void setUp() {
        tileManagerInteractorStub = new TileManagerInteractorStub();
        collisionInteractor = new CollisionInteractor(tileManagerInteractorStub);
        player = new GamePlayer();
        // Initialize GamePlayer fields here...
        player.worldX = 100;
        player.worldY = 100;
        player.speed = 10;
        player.solidArea = new Rectangle(10, 10, 30, 30); // Example values
    }

    @Test
    void testCollisionFromTop() {
        // Set player direction to up and expect a collision
        player.direction = "up";
        tileManagerInteractorStub.setupCollisionTiles(2, 1, true);

        collisionInteractor.checkCollision(player);

        assertTrue(player.collisionOn, "Collision should be detected when moving up into a collidable tile");
    }

    @Test
    void testCollisionFromBot() {
        // Set player direction to up and expect a collision
        player.direction = "down";
        tileManagerInteractorStub.setupCollisionTiles(2, 1, true);

        collisionInteractor.checkCollision(player);

        assertTrue(player.collisionOn, "Collision should be detected when moving up into a collidable tile");
    }

    @Test
    void testCollisionFromLeft() {
        // Set player direction to up and expect a collision
        player.direction = "left";
        tileManagerInteractorStub.setupCollisionTiles(2, 1, true);

        collisionInteractor.checkCollision(player);

        assertTrue(player.collisionOn, "Collision should be detected when moving up into a collidable tile");
    }

    @Test
    void testCollisionFromRight() {
        // Set player direction to up and expect a collision
        player.direction = "right";
        tileManagerInteractorStub.setupCollisionTiles(2, 1, true);

        collisionInteractor.checkCollision(player);

        assertTrue(player.collisionOn, "Collision should be detected when moving up into a collidable tile");
    }




    static class TileManagerInteractorStub extends TileManagerInteractor {
        Tile[][] tile;
        int[][] mapTileNum;

        public TileManagerInteractorStub() {
            // Initialize tile and mapTileNum arrays here...
            tile = new Tile[10][10]; // Example size
            mapTileNum = new int[10][10];
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    tile[i][j] = new Tile();
                    mapTileNum[i][j] = 0;
                }
            }
        }

        void setupCollisionTiles(int col, int row, boolean collision) {
            tile[col][row].collision = collision;
            mapTileNum[col][row] = col; // Assuming tile number is same as column number for simplicity
        }
    }
}
