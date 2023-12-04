package Game;


import entity.Tile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.game.TileManagerInteractor;

import java.awt.image.BufferedImage;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class TileManagerInteractorTest {

    private TileManagerInteractor tileManager;

    @BeforeEach
    void setUp() {
        tileManager = new TileManagerInteractor();
    }

    @Test
    void testTileImagesLoaded() {
        Tile[] tiles = tileManager.getTiles();

        assertNotNull(tiles[0].image, "Image for tile 0 should be loaded");
        assertNotNull(tiles[1].image, "Image for tile 1 should be loaded");
        assertTrue(tiles[1].collision, "Tile 1 should have collision");
        // ... Continue for other tiles
    }

    @Test
    void testMapLoading() {
        int[][] mapTileNum = tileManager.getMapTileNum();


        assertEquals(4, mapTileNum[0][0], "Tile number at [x,y] should be as expected");

    }

    // Helper method to simulate loading an image
    private BufferedImage mockLoadImage(String path) {
        // Load an image or return a mock image
        // Implement this based on your test environment
        return new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
    }
}
