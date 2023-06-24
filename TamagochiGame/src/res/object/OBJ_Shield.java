
package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Shield extends Entity {
    
    public OBJ_Shield(GamePanel gp) {
        super(gp);
        type = type_shield;
        name = "Basic Shield";
        down1 = setup("/res/objects/shield1", gp.tileSize, gp.tileSize);
        defenseValue = 1;
        description = "[" + name + "]  \n Its a shield";
    }
}
