package main;

import entity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import object.SuperObject;
import tile.TileManager;


public class GamePanel extends JPanel implements Runnable{
    
    //SCREEN SETTINGS
    
    final int originalTileSize = 16; //16x16 tile
    final int scale = 3;
    
    public final int tileSize = originalTileSize * scale; //48x48 tile
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12; //4 by 3
    public final int screenWidth = tileSize * maxScreenCol; //768 pixels
    public final int screenHeight = tileSize * maxScreenRow; //576 pixels
    
    //WORLD SETTINGS
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    
    //FPS
    int FPS = 60;
    
    //SYSTEM
    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Sound music = new Sound();
    Sound se = new Sound();
    public CollisionChecker cChecker = new CollisionChecker(this);
    public  AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    Thread gameThread;
    
    //ENTITY and OBJECT
    public Player player = new Player(this,keyH);
    public SuperObject obj[] = new SuperObject[10]; //Object Slots
    
    
    
    public GamePanel(){
    
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    
    public void setupGame(){
    
        aSetter.setObject();
        
        playMusic(0);
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
        
        //DEBUG
        long drawStart = 0;
        if(keyH.checkDrawTime == true){drawStart = System.nanoTime();
        }
        

        //TILE
        tileM.draw(g2);//this one first before drawing the player and other stuff unless you want the tile to cover your player
        
        //OBJECT
        for(int i = 0; i < obj.length; i++){
            if(obj[i] != null){
            obj[i].draw(g2, this);
            }
        }
        
        //PLAYER
        player.draw(g2);
        
        //UI
        ui.draw(g2);
        
        //DEBUG
        if(keyH.checkDrawTime == true){
        long drawEnd = System.nanoTime();
        long passed = drawEnd - drawStart;
        g2.setColor(Color.white);
        g2.drawString("Draw time: " + passed, 10,400);
        System.out.println("Draw time: "+passed);}
        
        
        g2.dispose();
    }
    public void playMusic(int i){
    
        music.setFile(i);
        music.play();
        music.loop();
    }
    public void stopMusic(){
        music.stop();
    }
    public void playSE(int i){
        se.setFile(i); 
        se.play();
    }
}