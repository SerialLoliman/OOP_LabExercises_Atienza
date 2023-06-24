
package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Heart extends Entity{
    GamePanel gp;
    public OBJ_Heart(GamePanel gp){
    super(gp);
    
    type = type_pickupOnly;
    name = "Heart";
    value = 2;
    down1 = setup("/res/objects/heartF", gp.tileSize, gp.tileSize);
    image = setup("/res/objects/heartF", gp.tileSize, gp.tileSize);
    image2 = setup("/res/objects/heartH", gp.tileSize, gp.tileSize);
    image3 = setup("/res/objects/heartE", gp.tileSize, gp.tileSize);

    }
    public void use (Entity entity){
        entity.life += value;
        
    }
}
