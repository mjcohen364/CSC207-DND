package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePlayer {
    public int worldX, worldY;
    public int speed;

    public BufferedImage walk1, walk2, walk3, walk4;
    public String direction;

    public int spriteCounter= 0;
    public int spriteNum =1;

    public Rectangle solidArea;

    public boolean collisionOn = false;

    public final int screenWidth = 768; // 48 x 16 = 768
    public final int screenHeight = 576; // 48 x 12 = 576

    public final int screenX;
    public final int screenY;



    public GamePlayer() {
        solidArea = new Rectangle(32,48,8,0);
        setDefaultValues();
        screenX=screenWidth/2 - (48/2);
        screenY=screenHeight/2 - (48/2);
    }

    public void setDefaultValues() {
        // Initial position and speed
        worldX = 48 * 23;
        worldY = 48 * 21;
        speed = 4;
        direction = "down";
    }




}
