package main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


public class UtilityTool {
    
    public BufferedImage scaleImage(BufferedImage original, int width, int height){
    
        BufferedImage scaledImage = new BufferedImage(width, height, original.getType());
        Graphics2D g2 = scaledImage.createGraphics();//this line means that this g2 would be saved as an image with the same scale in the scaledImage
        g2.drawImage(original, 0, 0, width, height, null);
        g2.dispose();
        
        
        return scaledImage;
    
    }
    
}
