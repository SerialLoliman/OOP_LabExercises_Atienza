package main;

import entity.Entity;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import object.OBJ_Heart;

public class UI {
    
    GamePanel gp;
    Graphics2D g2;
    Font purisaBold;
    BufferedImage heartF, heartH, heartE;
    Font comicsans_40, arial_80B;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false; 
    public String currentDialogue = "";
    public int commandNum = 0;
    public int titleScreenState = 0; //0: first screen, 1: second screen
    public int slotCol = 0;
    public int slotRow = 0;
    
    public UI(GamePanel gp) {
    this.gp = gp;
    
    try{
    //FONT
    InputStream is = getClass().getResourceAsStream("/res/font/Purisa Bold.ttf");
    purisaBold = Font.createFont(Font.TRUETYPE_FONT, is);
    is = getClass().getResourceAsStream("/res/font/Purisa Bold.ttf"); 
    
    } catch(FontFormatException e){
        e.printStackTrace();
    } catch(IOException e){
        e.printStackTrace();
    }
    //HUD OBJECTS
    Entity heart = new OBJ_Heart(gp);
    heartF = heart.image;
    heartH = heart.image2;
    heartE = heart.image3;
    }

    
public void showMessage(String text){
message = text;
messageOn = true;

}
public void draw(Graphics2D g2){
    
    this.g2 = g2;
    
    g2.setFont(purisaBold);
    g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    g2.setColor(Color.white);
    //TITLE STATE
    if(gp.gameState == gp.titleState){
        drawTitleScreen();
    }
    //PLAY SATE
    if(gp.gameState == gp.playState){
        drawPlayerLife();
    }
    //PAUSE STATE
    if (gp.gameState == gp.pauseState){
        drawPlayerLife();
       drawPauseScreen();
    }
    //DIALOGUE STATE
    if(gp.gameState == gp.dialogueState){
        drawPlayerLife();
        drawDialogueScreen();
    }
    //CHARACTER STATE
    if(gp.gameState == gp.characterState){
        drawCharaterScreen();
        drawInventory();
    }
}
public void drawPlayerLife(){
    
    //gp.player.life = 3;
    
    int x = gp.tileSize/2;
    int y = gp.tileSize/2;
    int i = 0;
    
    //DRAW MAX LIFE
    while(i<gp.player.maxLife/2){
        g2.drawImage(heartE, x, y, null);
        i++;
        x += gp.tileSize;
        
    }
    
    //RESET
    x = gp.tileSize/2;
    y = gp.tileSize/2;
    i = 0;
    
    //DRAW CURRENT LIFE
    while(i< gp.player.life){
        g2.drawImage(heartH, x, y, null);
        i++;
        if(i < gp.player.life){
            g2.drawImage(heartF, x, y, null);
        }
        i++;
        x+= gp.tileSize;
    }
    
}
public void drawTitleScreen(){
    
    
    if(titleScreenState == 0){
        
    g2.setColor(new Color(0, 0, 0));
    g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
    
    //TITLE NAME
    g2.setFont(g2.getFont().deriveFont(Font.BOLD, 60F));
    String text = "PROJECT: PET GAME";
    int x = getXforCenteredText(text);
    int y = gp.tileSize*3;
    
    //TITLE SHADOW
    g2.setColor(Color.gray);
    g2.drawString(text, x+5, y+5);
    
    //TITLE COLOR
    g2.setColor(Color.white);
    g2.drawString(text, x, y);
    
    //TITLE SPRITE
    x = gp.screenWidth/2 - (gp.tileSize*2)/2;
    y += gp.tileSize*2;
    g2.drawImage(gp.player.down1, x, y, gp.tileSize*2, gp.tileSize*2, null);
    
    //MENU
    g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20));
    text = "NEW GAME";
    x = getXforCenteredText(text);
    y += gp.tileSize*3.5;
    g2.drawString(text, x, y);
    if(commandNum == 0){
        g2.drawString(">", x-gp.tileSize, y);
    }
    
    g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20));
    text = "LOAD GAME";
    x = getXforCenteredText(text);
    y += gp.tileSize;
    g2.drawString(text, x, y);
    if(commandNum == 1){
        g2.drawString(">", x-gp.tileSize, y);
    }
        
    g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20));
    text = "QUIT TO DESKTOP";
    x = getXforCenteredText(text);
    y += gp.tileSize;
    g2.drawString(text, x, y);
    if(commandNum == 2){
        g2.drawString(">", x-gp.tileSize, y);
    }
    }
    else if(titleScreenState == 1){
        
        //CHARACTER SELECT SCREEN
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(42F));
        
        String text = "SELECT PET";
        int x = getXforCenteredText(text);
        int y = gp.tileSize*3;
        g2.drawString(text, x, y);
        
        text = "GREEN SLIME";
        x = getXforCenteredText(text);
        y += gp.tileSize*2;
        g2.drawString(text, x, y);
        if(commandNum == 0){
            g2.drawString(">", x-gp.tileSize, y);
        }
        text = "BLUE SLIME";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);
        if(commandNum == 1){
            g2.drawString(">", x-gp.tileSize, y);
        }
        text = "RED SLIME";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);
        if(commandNum == 2){
            g2.drawString(">", x-gp.tileSize, y);
        }
        text = "BACK";
        x = getXforCenteredText(text);
        y += gp.tileSize*2;
        g2.drawString(text, x, y);
        if(commandNum == 3){
            g2.drawString(">", x-gp.tileSize, y);
        }
        
    }
}
public void drawDialogueScreen(){
    
    //WINDOW
    int x = gp.tileSize*2;
    int y = gp.tileSize/2;
    int width = gp.screenWidth - (gp.tileSize*4);
    int height = gp.tileSize*4;
    
    drawSubWindow(x, y, width, height);
    
    g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 22F));
    x += gp.tileSize;
    y += gp.tileSize;
    
    for(String line: currentDialogue.split("\n")){
    g2.drawString(line, x, y);
    y += 40;
        
    }
     
}
public void drawCharaterScreen(){
    
    //CREATE FRAME
    final int frameX = gp.tileSize*2;
    final int frameY = gp.tileSize;
    final int frameWidth = gp.tileSize*5;
    final int frameHeight = gp.tileSize*10;
    drawSubWindow(frameX, frameY, frameWidth, frameHeight);
    
    //TEXT
    g2.setColor(Color.WHITE);
    g2.setFont(g2.getFont().deriveFont(18F));
    
    int textX = frameX + 20;
    int textY = frameY + gp.tileSize;
    final int lineHeight = 31;
    
    //NAMES
    g2.drawString("LEVEL", textX, textY);
    textY += lineHeight;
    g2.drawString("LIFE", textX, textY);
    textY += lineHeight;
    g2.drawString("STRENGTH", textX, textY);
    textY += lineHeight;
    g2.drawString("DEXTERITY", textX, textY);
    textY += lineHeight;
    g2.drawString("ATTACK", textX, textY);
    textY += lineHeight;
    g2.drawString("DEFENSE", textX, textY);
    textY += lineHeight;
    g2.drawString("EXP", textX, textY);
    textY += lineHeight;
    g2.drawString("NEXT LEVEL", textX, textY);
    textY += lineHeight;
    g2.drawString("COIN", textX, textY);
    textY += lineHeight + 20;
    g2.drawString("WEAPON", textX, textY);
    textY += lineHeight + 15;
    g2.drawString("SHIELD", textX, textY);
    textY += lineHeight;
    
    //VALUES
    int tailX = (frameX + frameWidth) - 30;
    //RESET TEXTY
    textY = frameY + gp.tileSize;
    String value;
    
    //LEVEL
    value = String.valueOf(gp.player.level);
    textX = getXforAlignToRightText(value, tailX);
    g2.drawString(value, textX, textY);
        textY += lineHeight;
    //LIFE
    value = String.valueOf(gp.player.life + "/" + gp.player.maxLife);
    textX = getXforAlignToRightText(value, tailX);
    g2.drawString(value, textX, textY);
        textY += lineHeight;
    //STRENGTH
    value = String.valueOf(gp.player.strength);
    textX = getXforAlignToRightText(value, tailX);
    g2.drawString(value, textX, textY);
        textY += lineHeight;
    //DEXTERITY
    value = String.valueOf(gp.player.dexterity);
    textX = getXforAlignToRightText(value, tailX);
    g2.drawString(value, textX, textY);
        textY += lineHeight;
    //ATTACK
    value = String.valueOf(gp.player.attack);
    textX = getXforAlignToRightText(value, tailX);
    g2.drawString(value, textX, textY);
        textY += lineHeight;
    //DEFENSE
    value = String.valueOf(gp.player.defense);
    textX = getXforAlignToRightText(value, tailX);
    g2.drawString(value, textX, textY);
        textY += lineHeight;
    //EXP
    value = String.valueOf(gp.player.exp);
    textX = getXforAlignToRightText(value, tailX);
    g2.drawString(value, textX, textY);
        textY += lineHeight;
    //EXP TO NEXT LEVEL
    value = String.valueOf(gp.player.nextLevelExp);
    textX = getXforAlignToRightText(value, tailX);
    g2.drawString(value, textX, textY);
        textY += lineHeight;
    //COIN
    value = String.valueOf(gp.player.coin);
    textX = getXforAlignToRightText(value, tailX);
    g2.drawString(value, textX, textY);
        textY += lineHeight;

    //g2.drawImage(gp.player.currentWeapon.down1, tailX - gp.tileSize, textY - 14, null
    //text += gp.tileSize
    //g2.drawImage(gp.player.currentShield.down1, tailX - gp.tileSize, textY - 14, null
    //text += gp.tileSize
    
}
public void drawInventory(){
    
    //FRAME
    int frameX = gp.tileSize*9;
    int frameY = gp.tileSize;
    int frameWidth = gp.tileSize*6;
    int frameHeight = gp.tileSize*5;
    drawSubWindow(frameX, frameY, frameWidth, frameHeight);
    
    //INVENTORY SLOTS
    final int slotXstart = frameX + 20;
    final int slotYstart = frameY + 20;
    int slotX = slotXstart;
    int slotY = slotYstart;
    int slotSize = gp.tileSize+3;
    
    //DRAW ITEM
    for(int i = 0; i < gp.player.inventory.size(); i++){
        
        g2.drawImage(gp.player.inventory.get(i).down1, slotX, slotY, null);
        slotX += gp.tileSize;
        if(i == 4 || i == 9 || i == 14){
            slotX = slotXstart;
            slotY = slotSize;
        }
    }
    
    //INVENTORY CURSOR
    int cursorX = slotXstart + (slotSize * slotCol);
    int cursorY = slotYstart + (slotSize * slotRow);
    int cursorWidth = gp.tileSize;
    int cursorHeight = gp.tileSize;
    
    //DRAW CURSOR
    g2.setColor(Color.white);
    g2.setStroke(new BasicStroke(3));
    g2.drawRoundRect(cursorX, cursorY, cursorWidth, cursorHeight, 10, 10);
    
    //ITEM DESCRIPTION FRAME
    int dFrameX = frameX;
    int dFrameY = frameY + frameHeight;
    int dFrameWidth = frameWidth;
    int dFrameHeight = gp.tileSize*3;
    //DRAW ITEM DESCRIPTION TEXT
    int textX = dFrameX + 20;
    int textY = dFrameY + gp.tileSize;
    g2.setFont(g2.getFont().deriveFont(18F));
    //GET ITEM INDEX DESCRIPTION. ONLY SHOWS IF CURSOR IS ON ITEM
    int itemIndex = getItemIndexOnSlot();
    if (itemIndex < gp.player.inventory.size()){
    drawSubWindow(dFrameX, dFrameY, dFrameWidth, dFrameHeight); 
    for(String line: gp.player.inventory.get(itemIndex).description.split("\n")){
        g2.drawString(gp.player.inventory.get(itemIndex).description, textX, textY);
        textY += 22;
    }
    }
    
}
public int getItemIndexOnSlot(){
    int itemIndex = slotCol + (slotRow * 5);
    
    return itemIndex;
}
public void drawSubWindow(int x, int y, int width, int heigth){
    
    Color c = new Color (0, 0, 0, 210);
    g2.setColor(c);
    g2.fillRoundRect(x, y, width, heigth, 35, 35);
    
    c = new Color(255, 255, 255);
    g2.setColor(c);
    g2.setStroke(new BasicStroke(5));
    g2.drawRoundRect(x + 5, y + 5, width-10, heigth-10, 25, 25);
    
}
public void drawPauseScreen(){
    
    g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80F));
    String text = "PAUSED";
    int x = getXforCenteredText(text);
    int y = gp.screenHeight/2;
    
    g2.drawString(text, x, y);
    
}
public int getXforCenteredText(String text){
    
    int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
    int x = gp.screenWidth/2 - length/2;
    return x;
    
}
public int getXforAlignToRightText(String text, int tailX){
    
    int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
    int x = tailX - length;
    return x;
    
}
}

//    
//    if(gameFinished == true){
//        
//        g2.setFont(comicsans_40);
//        g2.setColor(Color.white);
//        
//        String text;
//        int textLength;
//        int x;
//        int y;
//        
//        text = "TREASURE CHEST OBTAINED!!!";
//        textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
//        x = gp.screenWidth/2 - textLength/2;
//        y = gp.screenHeight/2 - (gp.tileSize*3);
//        g2.drawString(text, x, y);
//        
//        g2.setFont(comicsans_40);
//        g2.setColor(Color.black);
//        text = "Game Time:" + dFormat.format(playTime);
//        textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
//        x = gp.screenWidth/2 - textLength/2;
//        y = gp.screenHeight/2 + (gp.tileSize*4);
//        g2.drawString(text, x, y);
//        
//        g2.setFont(arial_80B);
//        g2.setColor(Color.red);
//        text = "YOU WIN";
//        textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
//        x = gp.screenWidth/2 - textLength/2;
//        y = gp.screenHeight/2 + (gp.tileSize*2);
//        g2.drawString(text, x, y);
//        
//        gp.gameThread = null;
//        
//    }
//    else{
//        g2.setFont(comicsans_40);
//        g2.setColor(Color.white);
//        g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize,null);
//        g2.drawString(" = " + gp.player.hasKey, 69, 50);
//        
////TIME
//        playTime +=(double)1/60;
//        g2.drawString("Time: " + dFormat.format(playTime), gp.tileSize*11, 50);
//
////MESSAGE
//if(messageOn == true){
//
//    g2.setFont(g2.getFont().deriveFont(30F));
//    g2.drawString(message, gp.tileSize/2, gp.tileSize*5);
//    
//    messageCounter++;
//    
//    if(messageCounter > 100){
//
//    messageCounter = 0;
//    messageOn = false;
//}}}
