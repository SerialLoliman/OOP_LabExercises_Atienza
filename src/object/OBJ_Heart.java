
package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Heart extends Entity{
    
    public OBJ_Heart(GamePanel gp){
    super(gp);
    
    name = "Heart";
    image = setup("/res/objects/heartF");
    image = setup("/res/objects/heartH");
    image = setup("/res/objects/heartE");

    }
}
