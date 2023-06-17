package entity;

import java.util.Random;
import main.GamePanel;

public class NPC_OldMan extends Entity {
    
    public NPC_OldMan(GamePanel gp){
        
        super(gp);
        
        type = type_npc;
        direction = "down";
        speed = 0;
        
        getImage();
        setDialogue();
    }
        public void getImage(){
    
        up1 = setup("/res/npc/oldman/char1", gp.tileSize, gp.tileSize);
        up2 = setup("/res/npc/oldman/char1", gp.tileSize, gp.tileSize);
        up3 = setup("/res/npc/oldman/char1", gp.tileSize, gp.tileSize);
        down1 = setup("/res/npc/oldman/char1", gp.tileSize, gp.tileSize);
        down2 = setup("/res/npc/oldman/char1", gp.tileSize, gp.tileSize);
        down3 = setup("/res/npc/oldman/char1", gp.tileSize, gp.tileSize);
        left1 = setup("/res/npc/oldman/char1", gp.tileSize, gp.tileSize);
        left2 = setup("/res/npc/oldman/char1", gp.tileSize, gp.tileSize);
        left3 = setup("/res/npc/oldman/char1", gp.tileSize, gp.tileSize);
        right1 = setup("/res/npc/oldman/char1", gp.tileSize, gp.tileSize);
        right2 = setup("/res/npc/oldman/char1", gp.tileSize, gp.tileSize);
        right3 = setup("/res/npc/oldman/char1", gp.tileSize, gp.tileSize);
        
    }
        public void setDialogue(){
            
            dialogues[0] = "IN THE FIRST AGE, THE FIRST\nBATTLE,ONE STOOD,BURNED BY\nTHE FIRES OF HATRED, HE SCOURED\nTHE UMBRAL PLAINS";
            dialogues[1] = "AGAINST ALL THE EVILS\nTHAT HELL CAN CONJURE\nALL THE WICKEDNESS MAN\nCAN PRODUCE";
            dialogues[2] = "WE WILL SEND UNTO THEM\nONLY YOU";
            dialogues[3] = "Aking pinusta sa manok napola";

            
        }
        public void setAction(){
            
            actionLockCounter++;
            if(actionLockCounter == 120){
                
            Random random = new Random();
            int i = random.nextInt(100)+1; // CHOOSES RANDOM NUMBER FROM 1-100
            
            if(i <= 25){
                direction = "up";
            }
            if(i > 25 && i <= 50){
                direction = "up";
            }
            if(i > 50 && i <= 75){
                direction = "left";
            }
            if(i > 75 && i <= 100){
                direction = "right";
            }
            actionLockCounter = 0;
            }
            
        }
        public void speak(){
            //DO CHARACTER STUFF
            super.speak();
        }
}
