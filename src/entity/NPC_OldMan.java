package entity;

import java.util.Random;
import main.GamePanel;

public class NPC_OldMan extends Entity {
    
    public NPC_OldMan(GamePanel gp){
        
        super(gp);
        
        direction = "down";
        speed = 0;
        
        getImage();
        setDialogue();
    }
        public void getImage(){
    
        up1 = setup("/res/npc/oldman/char1");
        up2 = setup("/res/npc/oldman/char1");
        up3 = setup("/res/npc/oldman/char1");
        down1 = setup("/res/npc/oldman/char1");
        down2 = setup("/res/npc/oldman/char1");
        down3 = setup("/res/npc/oldman/char1");
        left1 = setup("/res/npc/oldman/char1");
        left2 = setup("/res/npc/oldman/char1");
        left3 = setup("/res/npc/oldman/char1");
        right1 = setup("/res/npc/oldman/char1");
        right2 = setup("/res/npc/oldman/char1");
        right3 = setup("/res/npc/oldman/char1");
        
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
