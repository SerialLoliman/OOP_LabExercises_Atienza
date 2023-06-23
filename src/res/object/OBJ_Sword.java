
package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Sword extends Entity {
    
    public OBJ_Sword(GamePanel gp) {
        super(gp);
        type = type_sword;
        name = "Basic Sword";
        down1 = setup("/res/objects/sword1", gp.tileSize, gp.tileSize);
        attackValue = 1;
        attackArea.width = 36;
        attackArea.height = 36;
        description = "[" + name + "]  \n Its a sword";
    }
}
