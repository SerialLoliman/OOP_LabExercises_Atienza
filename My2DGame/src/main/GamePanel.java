package main;

import entity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import tile.TileManager;


public class GamePanel extends JPanel implements Runnable{
    
    //SCREEN SETTINGS
    
    final int originalTileSize = 16; //16x16 tile
    final int scale = 3;
    
    public final int tileSize = originalTileSize * scale; //48x48 tile
    final int maxScreenCol = 16;
    final int maxScreenRow = 12; //4 by 3
    final int screenWidth = tileSize * maxScreenCol; //768 pixels
    final int screenHeight = tileSize * maxScreenRow; //576 pixels
    
    
    //FPS
    int FPS = 60;
    
    
    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    Player player = new Player(this,keyH);
    
    
    
    public GamePanel(){
    
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    
    public void startGameThread(){
    
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    @Override

//SLEEP METHOD:
//    public void run(){
//    
//        double drawInterval = 1000000000/FPS;//1billion nanosecods divided by FPS = 0.01666 seconds refresh rate
//        double nextDrawTime = System.nanoTime() + drawInterval;
//        
//        
//        
//        
//        
//        
//        while(gameThread != null){
//        
//        
//           long currentTime = System.nanoTime();
//           System.out.println("current Time:"+ currentTime);
//           
//           // 1 UPDATE
//           update();
//           
//           
//           //2 DRAW
//           repaint();
//           
//           
//        try{ 
//           double remainingTime = nextDrawTime - System.nanoTime();
//           remainingTime = remainingTime/1000000;//time left divided by 1million nanoseconds = milliseconds
//           
//           if(remainingTime <0){
//               remainingTime = 0;
//           }
//           
//         
//           Thread.sleep((long)remainingTime);
//           
//           nextDrawTime += drawInterval;
//           
//           
//        } catch (InterruptedException e){
//        
//        e.printStackTrace();
//        }
//        
//        }
//        
//    }
    
//DELTA METHOD:
    public void run(){
        
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        
        while(gameThread != null){
            
            currentTime = System.nanoTime();
            
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            
            lastTime = currentTime;
        
            if(delta >= 1){
        update();
        repaint();
        delta --;
        drawCount++;
            }
            
            if (timer >= 1000000000){
            System.out.println("FPS: " + drawCount);
            drawCount = 0;
            timer = 0;
            }
            
        }
    
    }
    
    
    public void update(){
        
        player.update();
    }
    @Override
    public void paintComponent(Graphics g){
    
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        
        tileM.draw(g2);//this one first before drawing player unless you want the tile to cover your player
        player.draw(g2);
        
        g2.dispose();
    }
    
}