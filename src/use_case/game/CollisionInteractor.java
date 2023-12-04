package use_case.game;

import entity.GamePlayer;

public class CollisionInteractor {

    private TileManagerInteractor tileManagerInteractor;

    public CollisionInteractor(TileManagerInteractor tileManagerInteractor) {
        this.tileManagerInteractor = tileManagerInteractor;
    }

    public void checkCollision(GamePlayer entity) {
        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX / 48;
        int entityRightCol = entityRightWorldX / 48;
        int entityTopRow = entityTopWorldY / 48;
        int entityBottomRow = entityBottomWorldY / 48;

        int tileNum1, tileNum2;


        if (entity.direction == "up") {
            entityTopRow = (entityTopWorldY - entity.speed) / 48;
            tileNum1 = tileManagerInteractor.mapTileNum[entityLeftCol][entityTopRow];
            tileNum2 = tileManagerInteractor.mapTileNum[entityRightCol][entityTopRow];
            if (tileManagerInteractor.tile[tileNum1].collision == true || tileManagerInteractor.tile[tileNum2].collision == true) {
                entity.collisionOn = true;
            }
        }

        if (entity.direction == "down") {
            entityBottomRow = (entityBottomWorldY + entity.speed) / 48;
            tileNum1 = tileManagerInteractor.mapTileNum[entityLeftCol][entityBottomRow];
            tileNum2 = tileManagerInteractor.mapTileNum[entityRightCol][entityBottomRow];
            if (tileManagerInteractor.tile[tileNum1].collision == true || tileManagerInteractor.tile[tileNum2].collision == true) {
                entity.collisionOn = true;
            }

        }
        if (entity.direction == "left") {
            entityLeftCol = (entityLeftWorldX - entity.speed) / 48;
            tileNum1 = tileManagerInteractor.mapTileNum[entityLeftCol][entityTopRow];
            tileNum2 = tileManagerInteractor.mapTileNum[entityLeftCol][entityBottomRow];
            if (tileManagerInteractor.tile[tileNum1].collision == true || tileManagerInteractor.tile[tileNum2].collision == true) {
                entity.collisionOn = true;
            }

        }
        if (entity.direction == "right") {
            entityRightCol = (entityRightWorldX + entity.speed) / 48;
            tileNum1 = tileManagerInteractor.mapTileNum[entityRightCol][entityTopRow];
            tileNum2 = tileManagerInteractor.mapTileNum[entityRightCol][entityBottomRow];
            if (tileManagerInteractor.tile[tileNum1].collision == true || tileManagerInteractor.tile[tileNum2].collision == true) {
                entity.collisionOn = true;
            }

        }

    }

}
