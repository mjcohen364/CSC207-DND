package use_case.game;


import entity.GamePlayer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GamePlayerInteractor {

    KeyHandlerInteractor keyH;
    private CollisionInteractor cChecker;

    private GamePlayer gamePlayer;

    public GamePlayerInteractor(KeyHandlerInteractor keyH, CollisionInteractor cChecker, String playerClass, GamePlayer gamePlayer){
        this.keyH= keyH;
        this.cChecker = cChecker;
        this.gamePlayer = gamePlayer;
        getPlayerImage(playerClass);
    }


    public void getPlayerImage(String playerClass){
        try {
            // Load the entire sprite sheet
            BufferedImage spriteSheet = ImageIO.read(getClass().getResourceAsStream("/"+ playerClass + "/Run/Run-Sheet.png"));

            // Width and height of each sprite on the sprite sheet
            int spriteWidth = spriteSheet.getWidth() / 6; //number of sprites in sprite sheet
            int spriteHeight = spriteSheet.getHeight();

            // Extract each sprite from the sprite sheet
            gamePlayer.walk1 = spriteSheet.getSubimage(0 * spriteWidth, 0, spriteWidth, spriteHeight);
            gamePlayer.walk2 = spriteSheet.getSubimage(1 * spriteWidth, 0, spriteWidth, spriteHeight);
            gamePlayer.walk3 = spriteSheet.getSubimage(2 * spriteWidth, 0, spriteWidth, spriteHeight);
            gamePlayer.walk4 = spriteSheet.getSubimage(3 * spriteWidth, 0, spriteWidth, spriteHeight);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if(keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed){

            if (keyH.upPressed==true){
                gamePlayer.direction="up";

            }

            if (keyH.downPressed==true){
                gamePlayer.direction="down";

            }

            if (keyH.leftPressed==true){
                gamePlayer.direction="left";

            }
            if (keyH.rightPressed==true){
                gamePlayer.direction="right";

            }

            //tile collision check
            gamePlayer.collisionOn = false;
            cChecker.checkCollision(gamePlayer);

            // if collision is false, player can move
            if(gamePlayer.collisionOn==false){
                if (gamePlayer.direction=="up"){
                    gamePlayer.worldY -= gamePlayer.speed;
                }
                if (gamePlayer.direction=="down"){
                    gamePlayer.worldY += gamePlayer.speed;
                }
                if (gamePlayer.direction=="left"){
                    gamePlayer.worldX -= gamePlayer.speed;
                }
                if (gamePlayer.direction=="right"){
                    gamePlayer.worldX += gamePlayer.speed;
                }
            }

            gamePlayer.spriteCounter++;
            if(gamePlayer.spriteCounter > 12){
                if(gamePlayer.spriteNum==4){
                    gamePlayer.spriteNum =1;
                }
                else{
                    gamePlayer.spriteNum++;
                }

                gamePlayer.spriteCounter=0;
            }

        }
    }

    // Getters for player properties for rendering
    public BufferedImage getCurrentImage() {
        switch (gamePlayer.spriteNum) {
            case 1: return gamePlayer.walk1;
            case 2: return gamePlayer.walk2;
            case 3: return gamePlayer.walk3;
            case 4: return gamePlayer.walk4;
            default: return null;
        }
    }
}
