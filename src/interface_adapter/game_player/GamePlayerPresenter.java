package interface_adapter.game_player;

import use_case.game.GamePlayerInteractor;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePlayerPresenter {
    private final int screenWidth = 768; // 48 x 16 = 768
    private final int screenHeight = 576; // 48 x 12 = 576
    private GamePlayerInteractor gamePlayerInteractor;


    public GamePlayerPresenter(GamePlayerInteractor gamePlayerInteractor) {
        this.gamePlayerInteractor = gamePlayerInteractor;

    }

    public void draw(Graphics2D g2) {
        BufferedImage image = gamePlayerInteractor.getCurrentImage();
        int screenX = screenWidth / 2 - (48 / 2);
        int screenY = screenHeight / 2 - (48/ 2);

        g2.drawImage(image, screenX, screenY, 48 + 16, 48 +16, null);
    }
}
