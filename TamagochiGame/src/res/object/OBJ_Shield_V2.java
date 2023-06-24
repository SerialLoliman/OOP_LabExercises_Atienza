
package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Shield_V2 extends Entity {
    
    public OBJ_Shield_V2(GamePanel gp) {
        super(gp);
        type = type_shield;
        name = "Shield";
        down1 = setup("/res/objects/shield2", gp.tileSize, gp.tileSize);
        defenseValue = 2;
        description = "[" + name + "]  \n Its a shield";
    }
    
}
