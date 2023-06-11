package object;

import entity.Entity;
import javax.imageio.ImageIO;
import main.GamePanel;

public class OBJ_Key extends Entity{

    public OBJ_Key(GamePanel gp){
    super(gp);
    
    name = "Key";
    down1 = setup("/res/objects/key");
    
    }
}