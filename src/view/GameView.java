package view;

import interface_adapter.game_player.GamePlayerPresenter;
import interface_adapter.tile.TilePresenter;
import use_case.game.CollisionInteractor;
import use_case.game.GamePlayerInteractor;
import use_case.game.KeyHandlerInteractor;
import use_case.game.TileManagerInteractor;

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel implements Runnable{
    // works as a game screen
    // our screen settings

    final int originalTileSize = 16; // a 16 by 16 tile
    final int scale = 3; //  scale up the tile or the tiles would like pretty small

    public final int tileSize = originalTileSize*scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow =12;
    public final int screenWidth = tileSize*maxScreenCol; // 48 x 16 = 768
    public final int screenHeight = tileSize*maxScreenRow; // 48 x 12 = 576


    //world stuff
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;

    public final int worldWidth = tileSize*maxWorldCol;
    public final int worldHeight = tileSize*maxWorldRow;
    int FPS = 60;

    private TilePresenter tilePresenter;
    private TileManagerInteractor tileManagerInteractor;
    KeyHandlerInteractor keyH = new KeyHandlerInteractor();

    Thread gameThread;

    public CollisionInteractor cChecker;

    private GamePlayerPresenter gamePlayerPresenter;

    public GamePlayerInteractor gamePlayerInteractor;
    // Constructor with dependency injection
    public GameView(TilePresenter tilePresenter,
                    TileManagerInteractor tileManagerInteractor,
                    KeyHandlerInteractor keyH,
                    GamePlayerPresenter gamePlayerPresenter,
                    GamePlayerInteractor gamePlayerInteractor,
                    CollisionInteractor collisionInteractor) {
        this.tilePresenter = tilePresenter;
        this.tileManagerInteractor = tileManagerInteractor;
        this.keyH = keyH;
        this.gamePlayerPresenter = gamePlayerPresenter;
        this.gamePlayerInteractor = gamePlayerInteractor;
        this.cChecker = collisionInteractor;

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this); // passing gamepanel to thread constructor
        gameThread.start();
    }


    @Override
    public void run() {
        // create game loop here, which is the core of the game
        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread != null){
            long currentTime = System.nanoTime();

            // 1 update: update information (char position)

            update();



            // 2 draw: draw screen with updated information

            repaint();
            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000; //convert to ms

                if (remainingTime < 0){
                    remainingTime= 0;
                }
                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }




    }

    public void update(){
        gamePlayerInteractor.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        tilePresenter.draw(g2);
        gamePlayerPresenter.draw(g2);
        g2.dispose();
    }
}
