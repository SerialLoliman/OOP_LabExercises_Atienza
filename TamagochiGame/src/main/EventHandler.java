
package main;

import java.awt.Rectangle;

public class EventHandler {
    
    GamePanel gp;
    EventRect eventRect [][][];
    int previousEventX, previousEventY;
    boolean canTouchEvent = true;
    
    public EventHandler(GamePanel gp){
        this.gp = gp;
        
        eventRect = new EventRect[gp.maxMap][gp.maxWorldCol][gp.maxWorldRow];
        
        int map = 0;
        int col = 0;
        int row = 0;
         while(map< gp.maxMap && col < gp.maxWorldCol && row < gp.maxWorldRow){
        //EVENT HITBOX SIZE
        eventRect[map][col][row] = new EventRect();
        eventRect[map][col][row].x = 23;
        eventRect[map][col][row].y = 23;
        eventRect[map][col][row].height = 4;
        eventRect[map][col][row].width = 4;
        eventRect[map][col][row].eventRectDefaultX = eventRect[map][col][row].x;
        eventRect[map][col][row].eventRectDefaultY = eventRect[map][col][row].y;
        
        col++; 
        if(col == gp.maxWorldCol){
            col = 0;
            row++;
            
            if (row == gp.maxWorldRow){
            row = 0;
            map++;
            }
        }
    }
    }
    
    public void checkEvent(){
        
        int xDistance = Math.abs(gp.player.worldX - previousEventX);
        int yDistance = Math.abs(gp.player.worldY - previousEventY);
        int distance = Math.max(xDistance, yDistance);
        if(distance > gp.tileSize){
            canTouchEvent = true;
        }
        
        if(canTouchEvent == true){
        //EVENT HITBOX LOCATIONS
//        if(hit(0, 20, 40, "any") == true){shift( gp.dialogueState);}//is 
//        if(hit(0, 24, 40, "any") == true){damagePit(gp.dialogueState);}
//        if(hit(0, 22, 40, "any") == true){healingPool(gp.dialogueState);}
          if(hit(0, 16, 22, "any") == true){teleport(1,16,22);}//to arena
          if(hit(1, 22, 22, "any") == true){teleport(0,22,22);}//to maze
        }
    }
    
    public boolean hit(int map, int row, int col, String reqDirection){
        
        boolean hit = false;
        
        if (map == gp.currentMap){
        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
        eventRect[map][col][row].x = col*gp.tileSize + eventRect[map][col][row].x;
        eventRect[map][col][row].y = row*gp.tileSize + eventRect[map][col][row].y;
        
        if(gp.player.solidArea.intersects(eventRect[map][col][row]) && eventRect[map][col][row].eventDone == false){
            if(gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals(reqDirection)){
                hit = true;
                
                previousEventX = gp.player.worldX;
                previousEventY = gp.player.worldY;
            }
        }
        
        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
        eventRect[map][col][row].x = eventRect[map][col][row].eventRectDefaultX;
        eventRect[map][col][row].y = eventRect[map][col][row].eventRectDefaultY;
        }
        
        return hit;
    }
    
    public void shift(int gameState){
        
        gp.gameState = gameState;
        gp.ui.currentDialogue = "TELEPORT";
        gp.player.worldX = gp.tileSize*17;
        gp.player.worldY = gp.tileSize*40;
        
    }
    
    public void damagePit(int gameState){
        
        gp.gameState = gameState;
        gp.ui.currentDialogue = "HIT!";
        gp.player.life -= 1;
//        eventRect[col][row].eventDone = true;
        canTouchEvent = false;
    }
    
    public void healingPool( int gameState){
        
        System.out.println("HEAL");

        if(gp.keyH.enterPressed == true){
            gp.gameState = gameState;
            gp.ui.currentDialogue = "Hydrated. \n Restored hp";
            gp.player.life = gp.player.maxLife;
            gp.aSetter.setMonster();
            
        }
        
    }

    public void teleport( int map, int col, int row){
        
      gp.currentMap = map;
      gp.player.worldX = gp.tileSize * col;
      gp.player.worldY = gp.tileSize * row;
      previousEventX = gp.player.worldX;
      previousEventY = gp.player.worldY;
      canTouchEvent = false;
      gp.aSetter.setMonster();
      gp.playSE(2);
        }
        
    }
    