package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.UtilityTool;

public class Entity {
    
    GamePanel gp;
    
    public int worldX, worldY;
    public int speed;
    
    public BufferedImage up1, up2,up3, down1, down2, down3, left1, left2, left3, right1, right2, right3;
    public String direction = "down";
    
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;
    public int actionLockCounter = 0;
    String dialogues[] = new String[20]; //DIALOGUE SLOTS
    int dialogueIndex = 0;
    public BufferedImage image, image2, image3;
    public String name;
    public boolean collision = false;
    
    //CHARACTER STAT
    public int maxLife;
    public int life;
    public int level;
    public int strength;
    public int dexterity;
    public int attack;
    public int defense;
    public int exp;
    public int nextLevelExp;
    public int coin;
    
    //TO BE ADDED
    public Entity currentWeapon;
    public Entity currentShield;
    
    
    //ITEM ATTRIBUTES
    public String description = "";
    
    public Entity (GamePanel gp){
        this.gp = gp;
    }
    public void setAction(){}
    public void speak(){
                
            if(dialogues[dialogueIndex] == null){
                dialogueIndex = 0; 
            }
            gp.ui.currentDialogue =  dialogues[dialogueIndex];
            dialogueIndex++;
            
            switch(gp.player.direction){
                case "up":
                    direction ="down";
                    break;
                case "down":
                    direction = "up";
                    break;
                case "left":
                    direction = "right";
                    break;
                case "right":
                    direction = "left";
                    break;    
            }
    
    }
    public void update(){
        
        setAction();
        
        collisionOn = false;
        gp.cChecker.checkTile(this);
        gp.cChecker.checkObject(this, false);
        gp.cChecker.checkPlayer(this);
        
        //IF COLLISION IS FALSE, NPC CAN MOVE
        if(collisionOn == false){
        switch(direction){
            case "up":worldY -= speed;break;
            case "down":worldY += speed;break;
            case "left":worldX -= speed;break;
            case "right":worldX += speed;break;
        
        }
        
    spriteCounter ++;
    if(spriteCounter >10){
        if(spriteNum == 1){spriteNum = 2;}
        else if(spriteNum ==2){spriteNum = 3;}
        else if(spriteNum ==3){spriteNum = 1;}
        spriteCounter = 0;}
        }
        
    }
    public void draw(Graphics2D g2){
        
            BufferedImage image = null;    
        
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;
            
            
            if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && 
               worldX - gp.tileSize < gp.player.worldX + gp.player.screenX && 
               worldY + gp.tileSize > gp.player.worldY - gp.player.screenY && 
               worldY - gp.tileSize < gp.player.worldY + gp.player.screenY){
            
                
            switch(direction){
        
            case "up":
                if(spriteNum == 1){image = up1;}
                if(spriteNum == 2){image = up2;}
                if(spriteNum == 3){image = up3;}
                break;
            case "down":
                if(spriteNum == 1){image = down1;}
                if(spriteNum == 2){image = down2;}
                if(spriteNum == 3){image = down3;}
                break;
            case "left":
                if(spriteNum == 1){image = left1;}
                if(spriteNum == 2){image = left2;}
                if(spriteNum == 3){image = left3;}
                break;
            case "right":
                if(spriteNum == 1){image = right1;}
                if(spriteNum == 2){image = right2;}
                if(spriteNum == 3){image = right3;}
                break;
            
        }    
           g2.drawImage(image,screenX,screenY,gp.tileSize, gp.tileSize,null);
        }
    }
        public BufferedImage setup(String imagePath){
    
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;
        
        try{
            image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
            image = uTool.scaleImage(image,gp.tileSize,gp.tileSize);
              
        }catch(IOException e){
        e.printStackTrace();
        }
        return image;
    }
}
