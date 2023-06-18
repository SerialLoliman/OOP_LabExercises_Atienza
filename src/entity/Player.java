package entity;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import java.util.Timer;
import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;
import object.OBJ_Fireball;
import object.OBJ_Key;
import object.OBJ_Rock;
import object.OBJ_Shield;
import object.OBJ_Sword;


public class Player extends Entity{
    
    KeyHandler keyH;
    
    public final int screenX;
    public final int screenY;
    
    int hasKey;
    
    public ArrayList<Entity> inventory = new ArrayList<>();
    public final int maxInventorySize = 20;

    
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
        
//        attackArea.width = 36;
//        attackArea.height = 36;
        
        getPlayerAttackImage();
        setDefaultValues();
        getPlayerImage();
        setItems();
    }


    public void setDefaultValues(){
    
    worldX = gp.tileSize * 23;
    worldY = gp.tileSize * 29;
    speed = 3;
    direction = "down";//shows starting image, if you leave this blank, you wont see where the character starts
    
    //PLAYER STATUS
    level = 1;
    maxLife = 6;
    maxMana = 4;
    mana = maxMana;
    life = maxLife;
    strength = 1; //MORE STR = MORE ATK
    dexterity =1; //MORE DEX = MORE DEF
    ammo = 10;
    exp = 0;
    nextLevelExp = 5;
    coin = 0;
    hunger = "Full";
    hungerPoints = 100000;
    fatigue = "Relaxed";
    fatiguePoints = 1000;
    currentWeapon = new OBJ_Sword(gp);
    currentShield = new OBJ_Shield(gp);
    projectile = new OBJ_Fireball(gp);
    projectile = new OBJ_Rock(gp);
    
    attack = getAttack(); //TOTAL ATK FROM STRENGHTH & WEP
    defense = getDefense(); //TOTAL DEF FROM DEX & SHLD
    }
    public void setItems(){
        inventory.add(currentWeapon);
        inventory.add(currentShield);
    }
    public int getAttack(){
        attackArea = currentWeapon.attackArea;
        return attack = strength * currentWeapon.attackValue;
    }
    public int getDefense(){
        return defense = dexterity * currentShield.defenseValue;
    }
    public void getPlayerImage(){
    
        up1 = setup("/res/player/char1/up1", gp.tileSize, gp.tileSize);
        up2 = setup("/res/player/char1/up2", gp.tileSize, gp.tileSize);
        up3 = setup("/res/player/char1/up3", gp.tileSize, gp.tileSize);
        down1 = setup("/res/player/char1/down1", gp.tileSize, gp.tileSize);
        down2 = setup("/res/player/char1/down2", gp.tileSize, gp.tileSize);
        down3 = setup("/res/player/char1/down3", gp.tileSize, gp.tileSize);
        left1 = setup("/res/player/char1/left1", gp.tileSize, gp.tileSize);
        left2 = setup("/res/player/char1/left2", gp.tileSize, gp.tileSize);
        left3 = setup("/res/player/char1/left3", gp.tileSize, gp.tileSize);
        right1 = setup("/res/player/char1/right1", gp.tileSize, gp.tileSize);
        right2 = setup("/res/player/char1/right2", gp.tileSize, gp.tileSize);
        right3 = setup("/res/player/char1/right3", gp.tileSize, gp.tileSize);
    }
    
    
    public void getPlayerAttackImage(){
        
        attackUp1 = setup("/res/player/char1/attackUp1", gp.tileSize, gp.tileSize);
        attackUp2 = setup("/res/player/char1/attackUp2", gp.tileSize, gp.tileSize);
        attackDown1 = setup("/res/player/char1/attackDown1", gp.tileSize, gp.tileSize);
        attackDown2 = setup("/res/player/char1/attackDown2", gp.tileSize , gp.tileSize);
        attackLeft1 = setup("/res/player/char1/attackLeft1", gp.tileSize, gp.tileSize);
        attackLeft2 = setup("/res/player/char1/attackLeft2", gp.tileSize, gp.tileSize);
        attackRight1 = setup("/res/player/char1/attackRight1", gp.tileSize, gp.tileSize);
        attackRight2 = setup("/res/player/char1/attackRight2", gp.tileSize , gp.tileSize);

    }
    
    
    @Override
    public void update(){
        
        if(attacking == true){
            attacking();
        }
        
        else if(keyH.upPressed == true||keyH.downPressed ==true||keyH.leftPressed ==true||keyH.rightPressed ==true || keyH.spacePressed == true){
        if(keyH.upPressed == true){direction = "up";}
        else if (keyH.downPressed == true){direction = "down";}
        else if (keyH.leftPressed == true){direction = "left";}
        else if (keyH.rightPressed == true){direction = "right";}
        
        //CHECK TILE COLLISION
        collisionOn = false;
        gp.cChecker.checkTile(this);
        
        //CHECK OBJECT COLLISION
        int objIndex = gp.cChecker.checkObject(this,true);
        pickUpObject(objIndex);
        
        //CHECK NPC COLLISION
        int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
        interactNPC (npcIndex);
        
        //CHECK MONSTER COLLISION
        int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
        contactMonster(monsterIndex);
        
        //CHECK INTERACTIVE TILE COLLISION
        int iTileIndex = gp.cChecker.checkEntity(this, gp.iTile);
        
        //CHECK EVENT
        gp.eHandler.checkEvent();
        gp.keyH.spacePressed = false;
        gp.keyH.enterPressed = false;
        
        //IF COLLISION IS FALSE, PLAYER CAN MOVE
        if(collisionOn == false && keyH.spacePressed == false){
        switch(direction){
            case "up":worldY -= speed;break;
            case "down":worldY += speed;break;
            case "left":worldX -= speed;break;
            case "right":worldX += speed;break;
        }
        }
        
        gp.keyH.spacePressed = false;
        
    spriteCounter ++;
    if(spriteCounter >10){
        if(spriteNum == 1){spriteNum = 2;}
        else if(spriteNum ==2){spriteNum = 3;}
        else if(spriteNum ==3){spriteNum = 1;}
        spriteCounter = 0;}
        }
        
        if(gp.keyH.shotKeyPressed == true && projectile.alive == false && shotAvailableCounter == 30 && projectile.haveResource(this) == true){
            projectile.set(worldX, worldY, direction, true, this);
            gp.projectileList.add(projectile);
            projectile.subtractResource(this);
            shotAvailableCounter = 0;
        }
        
    if(invincible == true){
    invincibleCounter++;
    if(invincibleCounter > 160){
        invincible = false;
        invincibleCounter = 0;
        }
    }
    if(shotAvailableCounter < 30){
        shotAvailableCounter++;
    }
    if(life > maxLife){
        life = maxLife;
    }
    if(mana > maxMana){
        mana = maxMana;
    }
    
    //SLEEP
    if (gp.keyH.sleeping == true){gp.player.speed = 0;}
    if (gp.keyH.sleeping == false){gp.player.speed = 3;}//always change this to default speed
    
    //HUNGER
    if (hungerPoints >100000){hungerPoints = 100000;} //sets max hungerPoints
    if (hungerPoints <0){hungerPoints = 0;} //sets min hungerPoints
    if (hungerPoints > 0 && hungerPoints < 100001) {hungerPoints--;}//decay
        if (hungerPoints >= 80000) {
            hunger = "Full";
        } else if (hungerPoints >= 60000) {
            hunger = "Normal";
        } else if (hungerPoints >= 40000) {
            hunger = "Hungry";
        } else if (hungerPoints >= 20000) {
            hunger = "Starving";
        } else {
            hunger = "Dying";
        }
        
        //FATIGUE
    if (fatiguePoints >1000){fatiguePoints = 1000;} //sets max hungerPoints
    if (fatiguePoints <0){fatiguePoints = 0;} //sets min hungerPoints
        if (fatiguePoints >= 800) {
            fatigue = "Relaxed";
        } else if (fatiguePoints >= 600) {
            fatigue = "Normal";
        } else if (fatiguePoints >= 400) {
            fatigue = "Stressed";
        } else if (fatiguePoints >= 200) {
            fatigue = "Tired";
        } else {
            fatigue = "Fainting";
        }
}
    
    


    public void attacking(){
        
        spriteCounter++;
        if(spriteCounter <= 5){
            spriteNum = 1;
        }
        if(spriteCounter < 5 && spriteCounter <= 25){
            spriteNum = 2;
            
            int currentWorldX = worldX;
            int currentWorldY = worldY;
            int solidAreaWidth = solidArea.width;
            int solidAreaHeight = solidArea.height;
            
            switch(direction){
                case "up": worldY -= attackArea.height; break;
                case "down": worldY += attackArea.height; break;
                case "left": worldX -= attackArea.width; break;
                case "right": worldX += attackArea.width; break;
            }
            solidArea.width = attackArea.width;
            solidArea.height = attackArea.height;
            
            int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
            damageMonster(monsterIndex, attack);
            
            int iTileIndex = gp.cChecker.checkEntity(this, gp.iTile);
            damageInteractiveTile(iTileIndex);
            
            worldX = currentWorldX;
            worldY = currentWorldY;
            solidArea.width = solidAreaWidth;
            solidArea.height = solidAreaHeight;
        }
        if(spriteCounter > 25){
            spriteNum = 1;
            spriteCounter = 0;
            attacking = false;
        }
    }
    public void pickUpObject(int i){
    
        if(i != 999){
            if(gp.obj[i].type == type_pickupOnly){
                gp.obj[i].use(this);
                gp.obj[i] = null;
            }
            else{
            String text;
            
            if(inventory.size() != maxInventorySize){
                inventory.add(gp.obj[i]);
                text = "Obtained " + gp.obj[i].name;
            }
            else{
                text = "Cannot carry anymore";
            }
            gp.ui.addMessage(text);
            gp.obj[i] = null;
            }
        }
    }
    
    public void interactNPC(int i){
        
        if(gp.keyH.spacePressed == true){
            
        if(i != 999){
            gp.gameState = gp.dialogueState;
            gp.npc[i].speak();
        }
        else{
                attacking = true;
            }
        }
    }
    public void contactMonster(int i){
        
        if( i != 999){
            if(invincible == false && gp.monster[i].dying == false){
                int damage = gp.monster[i].attack - defense;
                if(damage < 0){
                    damage = 0;
                }
                life -= damage;
                gp.player.fatiguePoints--;
                invincible = true;
            }
        }
    }
    public void damageMonster(int i, int attack){
        if( i != 999){
            int damage = attack - gp.monster[i].defense;
            if(damage < 0){
                damage = 0;
            }
            if(gp.monster[i].invincible == false){
                gp.monster[i].life -= damage;
                gp.ui.addMessage(damage + "damage");
                gp.monster[i].invincible = true;
                gp.monster[i].damageReaction();
                
                if(gp.monster[i].life <= 0){
                    gp.monster[i].dying = true;
                    gp.ui.addMessage("killed: " + gp.monster[i].name);
                    gp.ui.addMessage("EXP: " + gp.monster[i].exp);
                    exp += gp.monster[i].exp;
                    checkLevelUp();
                }
            }
        }
    }
    public void damageInteractiveTile(int i){if(
            i!=999&&gp.iTile[i].destructible == true
                    &&gp.iTile[i].isCorrectItem(this) == true
                        &&gp.iTile[i].invincible == false){
            
            gp.iTile[i].playSE();
            gp.iTile[i].life--;
            gp.iTile[i].invincible = true;
            
            gp.player.fatiguePoints--;
            
            if(gp.iTile[i].life==0){
            gp.iTile[i]= gp.iTile[i].getDestroyedForm();
            }
        }
    }
    public void checkLevelUp(){
        if(exp >= nextLevelExp){
            level++;
            nextLevelExp = nextLevelExp*2;
            maxLife += 2;
            strength++;
            dexterity++;
            attack = getAttack();
            defense = getDefense();
            
            gp.gameState = gp.dialogueState;
            gp.ui.currentDialogue = "You are level: " + level + "now\n" + "You feel stronger";
        }
    }
    public void selectItem(){
        int itemIndex = gp.ui.getItemIndexOnSlot();
        
        if(itemIndex < inventory.size()){
            Entity selectedItem = inventory.get(itemIndex);
            if(selectedItem.type == type_sword || selectedItem.type == type_axe){
                currentWeapon = selectedItem;
                attack = getAttack();
            }
            if(selectedItem.type == type_shield){
                currentShield = selectedItem;
                defense = getDefense();
            }
                if(selectedItem.type == type_consumable){
                selectedItem.use(this);
                inventory.remove(itemIndex);
            }
        }
    }
    @Override
    public void draw(Graphics2D g2){
    
//        g2.setColor(Color.white);
//        g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null; 
        int tempScreenX = screenX;
        int tempScreenY = screenY;
        switch(direction){
        
            case "up":
                if(attacking  == false){
                if(spriteNum == 1){image = up1;}
                if(spriteNum == 2){image = up2;}
                if(spriteNum == 3){image = up3;}
                }
                if(attacking == true){
                if(spriteNum == 1){image = attackUp1;}
                if(spriteNum == 2){image = attackUp2;}
                if(spriteNum == 2){image = attackUp2;}
                }
                break;
            case "down":
                if(attacking  == false){
                if(spriteNum == 1){image = down1;}
                if(spriteNum == 2){image = down2;}
                if(spriteNum == 3){image = down3;}
                }
                if(attacking == true){
                if(spriteNum == 1){image = attackDown1;}
                if(spriteNum == 2){image = attackDown2;}
                if(spriteNum == 2){image = attackDown2;}
                }
                break;
            case "left":
                if(attacking  == false){
                if(spriteNum == 1){image = left1;}
                if(spriteNum == 2){image = left2;}
                if(spriteNum == 3){image = left3;}
                }
                if(attacking == true){
                if(spriteNum == 1){image = attackLeft1;}
                if(spriteNum == 2){image = attackLeft2;}
                if(spriteNum == 3){image = attackLeft2;}
                }
                break;
            case "right":
                if(attacking  == false){
                if(spriteNum == 1){image = right1;}
                if(spriteNum == 2){image = right2;}
                if(spriteNum == 3){image = right3;}
                }
                if(attacking == true){
                if(spriteNum == 1){image = attackRight1;}
                if(spriteNum == 2){image = attackRight2;}
                if(spriteNum == 2){image = attackRight2;}
                }
                break;
        }
        if(invincible == true){
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4F));
        }
        
        g2.drawImage(image, tempScreenX,tempScreenY,null);

        //RESET ALPHA
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1F));        
        //DEBUG
//        g2.setFont(new Font("Arial", Font.PLAIN, 26));
//        g2.setColor(Color.WHITE);
//        g2.drawString("Invincible" + invincibleCounter, 10, 400);
    }
}