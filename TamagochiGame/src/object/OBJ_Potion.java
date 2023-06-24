
package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Potion extends Entity {
    GamePanel gp;
    
    public OBJ_Potion(GamePanel gp) {
        super(gp);
        this.gp = gp;
        type = type_consumable;
        name = "Food";
        value = 5;
        down1 = setup("/res/objects/potion1", gp.tileSize, gp.tileSize);
        description = "[" + name + "] \n Restores your health and decreases hunger";
    }
    public void use(Entity entity){
        gp.gameState = gp.dialogueState;
        gp.ui.currentDialogue = "You consumed a " + name + "!\nHealth restored!";
        entity.life += value;
        entity.hungerPoints += 5000;
        entity.mana += value;
    }
}
