package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;
import object.OBJ_Key;


public class Player extends Entity{
    
    KeyHandler keyH;
    
    public final int screenX;
    public final int screenY;
    
    int hasKey = 0;
    
    public ArrayList<Entity> inventory = new ArrayList<>();
//    public final int maxInventorySize = 20;
    
    public Player(GamePanel gp, KeyHandler keyH){
    
        super(gp);
        this.keyH = keyH;
        
        screenX = gp.screenWidth/2-(gp.tileSize/2);
        screenY = gp.screenHeight/2-(gp.tileSize/2);
        
        solidArea = new Rectangle();
        solidArea.x = 12;
        solidArea.y = 26;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 22;
        solidArea.height = 15;
        
        setDefaultValues();
        getPlayerImage();
        setItems();
    }


    public void setDefaultValues(){
    
    worldX = gp.tileSize * 23;
    worldY = gp.tileSize * 29;
    speed = 2;
    direction = "down";//shows starting image, if you leave this blank, you wont see where the character starts
    
    //PLAYER STATUS
    level = 1;
    maxLife = 6;
    life = maxLife;
    strength = 1; //MORE STR = MORE ATK
    dexterity =1; //MORE DEX = MORE DEF
    exp = 0;
    nextLevelExp = 5;
    coin = 0;
    attack = getAttack(); //TOTAL ATK FROM STRENGHTH & WEP
    defense = getDefense(); //TOTAL DEF FROM DEX & SHLD
    
    //currentWeapon
    //currentShield
    
    }
    public void setItems(){
//        inventory.add(new OBJ_Key(gp));
//        inventory.add(currentWeapon);
//        inventory.add(currentShield);
    }
    public int getAttack(){
        return attack = strength; //*currentAttack.attackValue;
    }
    public int getDefense(){
        return defense = dexterity; //*currentShield.defenseValue;
    }
    public void getPlayerImage(){
    
        up1 = setup("/res/player/char1/up1");
        up2 = setup("/res/player/char1/up2");
        up3 = setup("/res/player/char1/up3");
        down1 = setup("/res/player/char1/down1");
        down2 = setup("/res/player/char1/down2");
        down3 = setup("/res/player/char1/down3");
        left1 = setup("/res/player/char1/left1");
        left2 = setup("/res/player/char1/left2");
        left3 = setup("/res/player/char1/left3");
        right1 = setup("/res/player/char1/right1");
        right2 = setup("/res/player/char1/right2");
        right3 = setup("/res/player/char1/right3");
        
    
    }

    @Override
    public void update(){
        
        if(keyH.upPressed == true||keyH.downPressed ==true||keyH.leftPressed ==true||keyH.rightPressed ==true){
        if(keyH.upPressed == true){
            direction = "up";
        }
        else if (keyH.downPressed == true){
            direction = "down";
        }
        else if (keyH.leftPressed == true){
            direction = "left";
        }
        else if (keyH.rightPressed == true){
            direction = "right";
        }
        
        //CHECK TILE COLLISION
        collisionOn = false;
        gp.cChecker.checkTile(this);
        
        //CHECK OBJECT COLLISION
        int objIndex = gp.cChecker.checkObject(this,true);
        pickUpObject(objIndex);
        
        
        //CHECK NPC COLLISION
        int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
        interactNPC (npcIndex);
        
        //CHECK EVENT
        gp.eHandler.checkEvent();
        gp.keyH.spacePressed = false;
        gp.keyH.enterPressed = false;
        
        //IF COLLISION IS FALSE, PLAYER CAN MOVE
        if(collisionOn == false){
        switch(direction){
            case "up":worldY -= speed;break;
            case "down":worldY += speed;break;
            case "left":worldX -= speed;break;
            case "right":worldX += speed;break;
        }
        }
        
    spriteCounter ++;
    if(spriteCounter >10){
        if(spriteNum == 1){spriteNum = 2;}
        else if(spriteNum ==2){spriteNum = 3;}
        else if(spriteNum ==3){spriteNum = 1;}
        spriteCounter = 0;}
        }
    }
    
    public void pickUpObject(int i){
    
        if(i != 999){
        
            String objectName = gp.obj[i].name;
            
            switch(objectName){
                case "Key":
                    gp.playSE(1);
                    hasKey++;
                    gp.obj[i] = null;
                    System.out.println("Keys: "+hasKey);
                    gp.ui.showMessage("You obtained a key!");
                    
                    break;
                case "Door":
                    if(hasKey > 0){
                    gp.playSE(3);
                    gp.obj[i] = null;
                    hasKey--;
                    gp.ui.showMessage("You unlocked a door!");}
                    else{gp.ui.showMessage("You need a key!");}
                    break;                                          
                case "Boots":
                    gp.playSE(2);
                    speed += 2;
                    gp.obj[i] = null;
                    gp.ui.showMessage("Movement increased!");
                    break;
                case "Chest":
                    gp.ui.gameFinished = true;
                    gp.stopMusic();
                    gp.playSE(5);
                    gp.obj[i] = null;
                    break;     
            }
        }
    }
    
    public void interactNPC(int i){
        
        if(i != 999){
             
            if(gp.keyH.enterPressed == true){
            gp.gameState = gp.dialogueState;
            gp.npc[i].speak();
                
            }
        
        }
    }
    
    @Override
    public void draw(Graphics2D g2){
    
//        g2.setColor(Color.white);
//        g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;
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
        g2.drawImage(image, screenX,screenY,null);
    }
}