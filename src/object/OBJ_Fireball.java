
package object;

import entity.Entity;
import entity.Projectile;
import main.GamePanel;

public class OBJ_Fireball extends Projectile{
    GamePanel gp;
    
    public OBJ_Fireball(GamePanel gp) {
        super(gp);
        this.gp = gp;
        
        name = "Fireball";
        speed = 10;
        maxLife = 80;
        life = maxLife;
        attack = 2;
        useCost = 1;
        alive = false;
        getImage();
    }
    public void getImage(){
        up1 = setup("/res/projectile/up1", gp.tileSize, gp.tileSize);
        up2 = setup("/res/projectile/up2", gp.tileSize, gp.tileSize);
        up3 = setup("/res/projectile/up3", gp.tileSize, gp.tileSize);
        down1 = setup("/res/projectile/down1", gp.tileSize, gp.tileSize);
        down2 = setup("/res/projectile/down2", gp.tileSize, gp.tileSize);
        down3 = setup("/res/projectile/down3", gp.tileSize, gp.tileSize);
        left1 = setup("/res/projectile/left1", gp.tileSize, gp.tileSize);
        left2 = setup("/res/projectile/left2", gp.tileSize, gp.tileSize);
        left3 = setup("/res/projectile/left3", gp.tileSize, gp.tileSize);
        right1 = setup("/res/projectile/right1", gp.tileSize, gp.tileSize);
        right2 = setup("/res/projectile/right2", gp.tileSize, gp.tileSize);
        right3 = setup("/res/projectile/right3", gp.tileSize, gp.tileSize);
    }
    public boolean haveResource(Entity user){
        boolean haveResource = false;
        if(user.mana >= useCost){
            haveResource = true;
        }
        return haveResource;
    }
    public void subtractResource(Entity user){
        user.mana -= useCost;
    }
}
