
package object;

import javax.imageio.ImageIO;
import main.GamePanel;

public class OBJ_Heart extends SuperObject{
        
    GamePanel gp;
    
    public OBJ_Heart(GamePanel gp){
    
    name = "Key";
    try{
        image = ImageIO.read(getClass().getResourceAsStream("/res/objects/heartF.png"));
        image2 = ImageIO.read(getClass().getResourceAsStream("/res/objects/heartH.png"));
        image3 = ImageIO.read(getClass().getResourceAsStream("/res/objects/heartE.png"));
        
        image = uTool.scaleImage(image, gp.tileSize,gp.tileSize);
        image2 = uTool.scaleImage(image2, gp.tileSize,gp.tileSize);
        image3 = uTool.scaleImage(image3, gp.tileSize,gp.tileSize);
    
    }catch(Exception e){
    e.printStackTrace();
    }
    
    }
}
