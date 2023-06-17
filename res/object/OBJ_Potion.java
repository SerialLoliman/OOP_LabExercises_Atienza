
package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Potion extends Entity {
    GamePanel gp;
    
    public OBJ_Potion(GamePanel gp) {
        super(gp);
        this.gp = gp;
        type = type_consumable;
        name = "Red Potion";
        value = 5;
        down1 = setup("/res/objects/potion1", gp.tileSize, gp.tileSize);
        description = "[" + name + "] \n Restores your health";
    }
    public void use(Entity entity){
        gp.gameState = gp.dialogueState;
        gp.ui.currentDialogue = "You drink" + name + "\n Health restored";
        entity.life += value;
    }
}
