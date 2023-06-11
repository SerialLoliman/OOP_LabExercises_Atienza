
package main;

import java.awt.Rectangle;

public class EventHandler {
    
    GamePanel gp;
    Rectangle eventRect;
    int eventRectDefaultX, eventRectDefaultY;
    
    public EventHandler(GamePanel gp){
        this.gp = gp;
        
        
        //EVENT HITBOX SIZE
        eventRect = new Rectangle();
        eventRect.x = 23;
        eventRect.y = 23;
        eventRect.height = 4;
        eventRect.width = 4;
        eventRectDefaultX = eventRect.x;
        eventRectDefaultY = eventRect.y;
        
    }
    
    public void checkEvent(){
        
        //EVENT HITBOX LOCATIONS
//        if(hit(20, 40, "any") == true){teleport(gp.dialogueState);}
//        if(hit(24, 40, "any") == true){damagePit(gp.dialogueState);}
//        if(hit(22, 40, "any") == true){healingPool(gp.dialogueState);}
    }
    
    public boolean hit(int eventCol, int eventRow, String reqDirection){
        
        boolean hit = false;
        
        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
        eventRect.x = eventCol*gp.tileSize + eventRect.x;
        eventRect.y = eventRow*gp.tileSize + eventRect.y;
        
        if(gp.player.solidArea.intersects(eventRect)){
            if(gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals(reqDirection)){
                hit = true;
            }
        }
        
        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
        eventRect.x = eventRectDefaultX;
        eventRect.y = eventRectDefaultY;
        
        return hit;
    }
    
    public void teleport(int gameState){
        
        gp.gameState = gameState;
        gp.ui.currentDialogue = "TELEPORT";
        gp.player.worldX = gp.tileSize*17;
        gp.player.worldY = gp.tileSize*40;
        
    }
    
    public void damagePit(int gameState){
        
        gp.gameState = gameState;
        gp.ui.currentDialogue = "HIT!";
        gp.player.life -= 1;
        
    }
    
    public void healingPool(int gameState){
        
        System.out.println("HEAL");

        if(gp.keyH.enterPressed == true){
            gp.gameState = gameState;
            gp.ui.currentDialogue = "Hydrated. \n Restored hp";
            gp.player.life = gp.player.maxLife;
            
        }
        
    }

}