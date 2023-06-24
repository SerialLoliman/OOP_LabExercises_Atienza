
package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_BronzeCoin extends Entity{
    GamePanel gp;
    public OBJ_BronzeCoin(GamePanel gp) {
        super(gp);
        this.gp = gp;
        
        type = type_pickupOnly;
        name = "Bronze Coin";
        value = 1;
        down1 = setup("/res/objects/bronzeCoin", gp.tileSize, gp.tileSize);
        
    }
        public void use(Entity entity){
            gp.ui.addMessage("Coin" + value);
            gp.player.coin += value;
    }
}
