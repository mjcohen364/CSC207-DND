package interface_adapter.tile;

import entity.GamePlayer;
import entity.Tile;
import use_case.game.GamePlayerInteractor;
import use_case.game.TileManagerInteractor;

import java.awt.*;

public class TilePresenter {

    private TileManagerInteractor tileManager;
    private GamePlayerInteractor gamePlayerInteractor;

    private final int maxWorldCol = 50;
    private final int maxWorldRow = 50;
    private GamePlayer p;
    public TilePresenter(TileManagerInteractor tileManager, GamePlayer p) {
        this.tileManager = tileManager;
        this.gamePlayerInteractor = gamePlayerInteractor;
        this.p = p;
    }

    public void draw(Graphics2D g2) {
        int worldCol = 0;
        int worldRow = 0;
        Tile[] tile = tileManager.getTiles();
        int[][] mapTileNum = tileManager.getMapTileNum();

        while(worldCol < maxWorldCol && worldRow < maxWorldRow){
            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol*48;
            int worldY = worldRow*48;
            int screenX = worldX - p.worldX +p.screenX;
            int screenY = worldY -p.worldY + p.screenY;

            if(     worldX + 48 > p.worldX - p.screenX &&
                    worldX - 48 < p.worldX + p.screenX &&
                    worldY + 48 > p.worldY - p.screenY &&
                    worldY - 48 < p.worldY + p.screenY) {
                g2.drawImage(tile[tileNum].image, screenX,screenY,48, 48, null);
            }
            //g2.drawImage(tile[tileNum].image, screenX,screenY,gp.tileSize, gp.tileSize, null);
            worldCol++;


            if(worldCol==maxWorldCol){
                worldCol=0;

                worldRow+=1;

            }
        }
    }
    }

