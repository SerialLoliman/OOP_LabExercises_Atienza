
package monster;

import entity.Entity;
import java.util.Random;
import main.GamePanel;
import object.OBJ_BronzeCoin;
import object.OBJ_Heart;
import object.OBJ_Mana;
import object.OBJ_Rock;

public class MON_Skeleton extends Entity {
    
    GamePanel gp;
    
    public MON_Skeleton(GamePanel gp){
        super(gp);
        this.gp = gp;
        
        type = type_monster;
        name = "Skeleton";
        speed = 1;
        maxLife = 10;
        life = maxLife;
        attack = 5;
        defense = 0;
        exp = 2;
        projectile = new OBJ_Rock(gp);
        
        solidArea.x = 3;
        solidArea.y = 18;
        solidArea.width = 42;
        solidArea.height = 30;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        
        getImage();
        
    }
    public void getImage(){
        
        up1 = setup("/res/monster/skeleton/sk_up1", gp.tileSize, gp.tileSize);
        up2 = setup("/res/monster/skeleton/sk_up2", gp.tileSize, gp.tileSize);
        up3 = setup("/res/monster/skeleton/sk_up3", gp.tileSize, gp.tileSize);
        down1 = setup("/res/monster/skeleton/sk_down1", gp.tileSize, gp.tileSize);
        down2 = setup("/res/monster/skeleton/sk_down2", gp.tileSize, gp.tileSize);
        down3 = setup("/res/monster/skeleton/sk_down3", gp.tileSize, gp.tileSize);
        left1 = setup("/res/monster/skeleton/sk_left1", gp.tileSize, gp.tileSize);
        left2 = setup("/res/monster/skeleton/sk_left2", gp.tileSize, gp.tileSize);
        left3 = setup("/res/monster/skeleton/sk_left3", gp.tileSize, gp.tileSize);
        right1 = setup("/res/monster/skeleton/sk_right1", gp.tileSize, gp.tileSize);
        right2 = setup("/res/monster/skeleton/sk_right2", gp.tileSize, gp.tileSize);
        right3 = setup("/res/monster/skeleton/sk_right3", gp.tileSize, gp.tileSize);
        
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
            int i = new Random().nextInt(100)+1;
            if(i > 99 && projectile.alive == false && shotAvailableCounter == 30){
                projectile.set(worldX, worldY, direction, true, null);
                gp.projectileList.add(projectile);
                shotAvailableCounter = 0;
            }
    }
    public void damageReaction(){
        actionLockCounter = 0;
        direction = gp.player.direction;
    }
    public void checkDrop(){
        int i = new Random().nextInt(100)+1;
        
        if(i < 50){
            dropItem(new OBJ_BronzeCoin(gp));
        }
        if(i >= 50 && i < 75){
            dropItem(new OBJ_Heart(gp));
        }
        if(i >= 75 && i < 100){
            dropItem(new OBJ_Mana(gp));
        }
    }
}
