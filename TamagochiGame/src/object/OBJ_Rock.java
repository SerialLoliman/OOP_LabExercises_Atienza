
package object;

import entity.Entity;
import entity.Projectile;
import java.awt.Color;
import main.GamePanel;

public class OBJ_Rock extends Projectile{
    GamePanel gp;
    public OBJ_Rock(GamePanel gp) {
        super(gp);
        this.gp = gp;
        
        name = "Rock";
        speed = 8;
        maxLife = 80;
        life = maxLife;
        attack = 2;
        useCost = 1;
        alive = false;
        getImage();
    }
    public void getImage(){
        up1 = setup("/res/projectile/rockThrow_up1", gp.tileSize, gp.tileSize);
        up2 = setup("/res/projectile/rockThrow_up2", gp.tileSize, gp.tileSize);
        up3 = setup("/res/projectile/rockThrow_up3", gp.tileSize, gp.tileSize);
        down1 = setup("/res/projectile/rockThrow_down1", gp.tileSize, gp.tileSize);
        down2 = setup("/res/projectile/rockThrow_down2", gp.tileSize, gp.tileSize);
        down3 = setup("/res/projectile/rockThrow_down3", gp.tileSize, gp.tileSize);
        left1 = setup("/res/projectile/rockThrow_left1", gp.tileSize, gp.tileSize);
        left2 = setup("/res/projectile/rockThrow_left2", gp.tileSize, gp.tileSize);
        left3 = setup("/res/projectile/rockThrow_left3", gp.tileSize, gp.tileSize);
        right1 = setup("/res/projectile/rockThrow_right1", gp.tileSize, gp.tileSize);
        right2 = setup("/res/projectile/rockThrow_right2", gp.tileSize, gp.tileSize);
        right3 = setup("/res/projectile/rockThrow_right3", gp.tileSize, gp.tileSize);
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
    public Color getParticleColor(){
    
        Color color = new Color (40,50,0);
    return color;
    }
    
    public int getParticleSize(){
    
        int size = 10; // 10pixels
        return size;
    
    }
    
    public int getParticleSpeed(){
    
        int speed = 1;
        return speed;
    
    }
    
    public int getParticleMaxLife(){
    
        int maxLife = 20;
        return maxLife;
    
    }
}
