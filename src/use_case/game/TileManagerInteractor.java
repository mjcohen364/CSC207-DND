package use_case.game;

import entity.Tile;

import javax.imageio.ImageIO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManagerInteractor {

    public Tile[] tile;
    public int[][] mapTileNum;

    private final int maxWorldCol = 50;
    private final int maxWorldRow = 50;

    public TileManagerInteractor() {

        tile = new Tile[10];
        mapTileNum = new int[maxWorldCol][maxWorldRow];
        getTileImage();
        loadMap("/maps/world01.txt");
    }

    private void getTileImage() {
        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass01.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water01.png"));
            tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
            tile[4].collision = true;

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/road00.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private void loadMap(String filePath) {
        try{
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col =0;
            int row= 0;
            while(col<maxWorldCol && row<maxWorldRow){
                String line = br.readLine();
                while(col < maxWorldCol){
                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row]= num;
                    col++;

                }
                if (col ==maxWorldCol){
                    col =0;
                    row++;
                }
            }
            br.close();
        }catch(Exception e){


        }
    }

    public Tile[] getTiles() {
        return tile;
    }

    public int[][] getMapTileNum() {
        return mapTileNum;
    }
}