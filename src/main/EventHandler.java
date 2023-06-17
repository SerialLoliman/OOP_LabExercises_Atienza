
package main;

import java.awt.Rectangle;

public class EventHandler {
    
    GamePanel gp;
    EventRect eventRect [][];
    int previousEventX, previousEventY;
    boolean canTouchEvent = true;
    
    public EventHandler(GamePanel gp){
        this.gp = gp;
        
        eventRect = new EventRect[gp.maxWorldCol][gp.maxWorldRow];
        int col = 0;
        int row = 0;
         while(col < gp.maxWorldCol && row < gp.maxWorldRow){
        //EVENT HITBOX SIZE
        eventRect[col][row] = new EventRect();
        eventRect[col][row].x = 23;
        eventRect[col][row].y = 23;
        eventRect[col][row].height = 4;
        eventRect[col][row].width = 4;
        eventRect[col][row].eventRectDefaultX = eventRect[col][row].x;
        eventRect[col][row].eventRectDefaultY = eventRect[col][row].y;
        
        col++; 
        if(col == gp.maxWorldCol){
            col = 0;
            row++;
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
//        if(hit(20, 40, "any") == true){teleport(20, 40, gp.dialogueState);}
//        if(hit(24, 40, "any") == true){damagePit(24, 40, gp.dialogueState);}
//        if(hit(22, 40, "any") == true){healingPool(22, 40, gp.dialogueState);}
        }
    }
    
    public boolean hit(int row, int col, String reqDirection){
        
        boolean hit = false;
        
        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
        eventRect[col][row].x = col*gp.tileSize + eventRect[col][row].x;
        eventRect[col][row].y = row*gp.tileSize + eventRect[col][row].y;
        
        if(gp.player.solidArea.intersects(eventRect[col][row]) && eventRect[col][row].eventDone == false){
            if(gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals(reqDirection)){
                hit = true;
                
                previousEventX = gp.player.worldX;
                previousEventY = gp.player.worldY;
            }
        }
        
        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
        eventRect[col][row].x = eventRect[col][row].eventRectDefaultX;
        eventRect[col][row].y = eventRect[col][row].eventRectDefaultY;
        
        return hit;
    }
    
    public void teleport(int col, int row, int gameState){
        
        gp.gameState = gameState;
        gp.ui.currentDialogue = "TELEPORT";
        gp.player.worldX = gp.tileSize*17;
        gp.player.worldY = gp.tileSize*40;
        
    }
    
    public void damagePit(int col, int row, int gameState){
        
        gp.gameState = gameState;
        gp.ui.currentDialogue = "HIT!";
        gp.player.life -= 1;
//        eventRect[col][row].eventDone = true;
        canTouchEvent = false;
    }
    
    public void healingPool(int col, int row, int gameState){
        
        System.out.println("HEAL");

        if(gp.keyH.enterPressed == true){
            gp.gameState = gameState;
            gp.ui.currentDialogue = "Hydrated. \n Restored hp";
            gp.player.life = gp.player.maxLife;
            gp.aSetter.setMonster();
            
        }
        
    }

}