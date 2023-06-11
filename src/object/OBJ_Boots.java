package object;

import entity.Entity;
import javax.imageio.ImageIO;
import main.GamePanel;

public class OBJ_Boots extends Entity{
    
    public OBJ_Boots(GamePanel gp){
    super(gp);
    
    name = "Boots";
    down1 = setup("/res/objects/boots");
    
    }
}