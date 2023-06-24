package main;

import ai.PathFinder;
import ai.data.SaveLoad;
import entity.Entity;
import entity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JPanel;
import tile.TileManager;
import tile.tile_interactive.InteractiveTile;


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
    public final int maxMap = 10;
    public int currentMap = 0;
    
    //FPS
    int FPS = 60;
    
    //SYSTEM
    public TileManager tileM = new TileManager(this);
    public KeyHandler keyH = new KeyHandler(this);
    Sound music = new Sound();
    Sound se = new Sound();
    public CollisionChecker cChecker = new CollisionChecker(this);
    public  AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    public EventHandler eHandler = new EventHandler(this);
    
    public PathFinder pFinder = new PathFinder (this);
    public SaveLoad saveLoad = new SaveLoad(this);
    Thread gameThread;
    
    //ENTITY and OBJECT
    public Player player = new Player(this,keyH);
    public Entity obj[][] = new Entity[maxMap][20]; //Object Slots
    public Entity npc[][] = new Entity[maxMap][10]; //NPC Slots
    public Entity monster[][] = new Entity[maxMap][20]; //Monster Slots
    public InteractiveTile iTile[][] = new InteractiveTile[maxMap][50];//Interactive Tile Slots
    public ArrayList<Entity> projectileList = new ArrayList<>();
    public ArrayList<Entity> particleList = new ArrayList<>();
    ArrayList<Entity> entityList = new ArrayList<>();
    
    //GAME STATE
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogueState = 3;
    public final int characterState = 4;
    
    public final int gameOverState = 6;
    
    public GamePanel(){
    
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    
    public void setupGame(){
    
        aSetter.setObject();
        aSetter.setNPC();
        aSetter.setMonster();
        aSetter.setInteractiveTile();
//        playMusic(0);
        
        gameState = titleState;
        
    }
    
    public void resetGame(boolean restart){
        player.setDefaultPositions();
        player.restoreStatus();
        aSetter.setNPC();
        aSetter.setMonster();
        
        if (restart == true){
        player.setDefaultValues();
        aSetter.setObject();
        aSetter.setInteractiveTile();
        }
    }
    
//    public void retry(){
//        player.setDefaultPositions();
//        player.restoreLifeAndMana();
//        aSetter.setNPC();
//        aSetter.setMonster();}
//    
//    public void restart(){
//        player.setDefaultValues();
//        player.setDefaultPositions();
//        player.restoreLifeAndMana();
//        player.setItems();
//        aSetter.setObject();
//        aSetter.setNPC();
//        aSetter.setMonster();
//        aSetter.setInteractiveTile();}
    
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
        
        if(gameState == playState){
            //PLAYER
            player.update();
            //NPC
            for(int i = 0; i < npc[1].length; i++){
                if(npc[currentMap][i] != null){
                    npc[currentMap][i].update();
                }
            }
            for(int i = 0; i < monster[1].length; i++){
                if(monster[currentMap][i] != null){
                    if(monster[currentMap][i].alive == true && monster[currentMap][i].dying == false){
                    monster[currentMap][i].update();
                    }
                    if(monster[currentMap][i].alive == false){
                        monster[currentMap][i].checkDrop();
                        monster[currentMap][i] = null;
                    }
                }
            }
            for(int i = 0; i < projectileList.size(); i++){
                if(projectileList.get(i) != null){
                    if(projectileList.get(i).alive == true){
                    projectileList.get(i).update();
                    }
                    if(projectileList.get(i).alive == false){
                        projectileList.remove(i);
                    }
                }
            }
            for(int i = 0; i < particleList.size(); i++){
                if(particleList.get(i) != null){
                    if(particleList.get(i).alive == true){
                    particleList.get(i).update();
                    }
                    if(particleList.get(i).alive == false){
                        particleList.remove(i);
                    }
                }
            }
            for (int i = 0; i< iTile[1].length; i++) {
            
                if (iTile[currentMap][i] != null) {
                    iTile[currentMap][i].update();
                }
            }
        }
        if (gameState == pauseState){
            //NOTHING
        }
    }
    @Override
    public void paintComponent(Graphics g){
    
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        
        //DEBUG
        long drawStart = 0;
        if(keyH.checkDrawTime == true){drawStart = System.nanoTime();
        }
        
        
        //TITLE SCREEN
        if(gameState == titleState){
            ui.draw(g2);
        }
        //OTHERS        
        else{
            
        //TILE
        tileM.draw(g2);//this one first before drawing the player and other stuff unless you want the tile to cover your player
        
        //INTERACTIVE TILE
        for(int i = 0; i< iTile[1].length; i++){
            if (iTile[currentMap][i] != null) {
                iTile[currentMap][i].draw(g2);
            }
        }
        
        //ADD ENTITIES TO THE LIST
        entityList.add(player);
        
        for(int i = 0; i< npc[1].length; i++){
        
        if (npc[currentMap][i] != null) {
        entityList.add(npc[currentMap][i]);
            }
        }
        
        for(int i = 0; i < obj[1].length; i++) {
        
        if(obj[currentMap][i] != null) {
        
            entityList.add(obj[currentMap][i]);
            }
        }
        for(int i = 0; i < monster[1].length; i++) {
        
        if(monster[currentMap][i] != null) {
        
            entityList.add(monster[currentMap][i]);
            }
        }
        for(int i = 0; i < projectileList.size(); i++) {
        
        if(projectileList.get(i) != null) {
        
            entityList.add(projectileList.get(i));
            }
        }
        for(int i = 0; i < particleList.size(); i++) {
        
        if(particleList.get(i) != null) {
        
            entityList.add(particleList.get(i));
            }
        }
        
        // SORT
        Collections.sort(entityList, new Comparator<Entity>(){
        
        @Override
        public int compare(Entity e1, Entity e2) {
        
        int result = Integer.compare(e1.worldY, e2.worldY);
        return result;
        
        }
        
        });
        
        //DRAW ENTITIES
        for(int i = 0; i < entityList.size(); i++) {
            entityList.get(i).draw(g2);
        }
        
        //EMPTY ENTITY LIST
        entityList.clear();
        
        //UI
        ui.draw(g2);
            
        }
        
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