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
            
            dialogues[0] = "Press >E< to check your\ninventory and stats " ;
            dialogues[1] = "Press >Z< to use your melee\nor interact";
            dialogues[2] = "Press >X< to use your skill\nrock throw";
            dialogues[3] = "Be careful out there";

            
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
