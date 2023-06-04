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
            
            dialogues[0] = "This island here is but a figment\nof it's past glory...\nThe animals here have mutated into\n slimes, same as you...";
            dialogues[1] = "If you wish to redeem this place,\nit would be wise if you would get\nstronger....";
            dialogues[2] = "Strong enough to not die...\nstrong enough to fight...\nstrong enough to uncover the truth...";
            dialogues[3] = "And strong enough to save this\n irredeemable island...\nGo young slime... \nfind out it's mystery";

            
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
