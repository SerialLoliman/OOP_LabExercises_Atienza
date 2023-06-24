
package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Mana extends Entity {
    GamePanel gp;
    public OBJ_Mana(GamePanel gp) {
        super(gp);
        
        type = type_pickupOnly;
        name = "Mana Crystal";
        value = 1;
        down1 = setup("/res/objects/manaF", gp.tileSize, gp.tileSize);
        image = setup("/res/objects/manaF", gp.tileSize, gp.tileSize);
        image2 = setup("/res/objects/manaE", gp.tileSize, gp.tileSize);
    }
        public void use (Entity entity){
        entity.mana += value;
    }
}
