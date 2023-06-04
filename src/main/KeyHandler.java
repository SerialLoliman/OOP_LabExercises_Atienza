package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyHandler implements KeyListener{
    
    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed, spacePressed;
    
    //DEBUG
    boolean checkDrawTime = false;
    
    
    public KeyHandler(GamePanel gp){
        this.gp = gp;
    }
    
    @Override
    public void keyTyped(KeyEvent e){}
    @Override
    public void keyPressed(KeyEvent e){
    
        int code = e.getKeyCode();
        
        //TITLE STATE
        if(gp.gameState == gp.titleState){
            
        if(gp.ui.titleScreenState == 0){
        if(code == KeyEvent.VK_UP){
            gp.ui.commandNum--;
            if(gp.ui.commandNum < 0){
                gp.ui.commandNum = 2;
            }
        }
        if(code == KeyEvent.VK_DOWN){
            gp.ui.commandNum++;
            if(gp.ui.commandNum > 2){
                gp.ui.commandNum = 0;
            }
        }
        
        if(code == KeyEvent.VK_SPACE){
            //NEW GAME
            if(gp.ui.commandNum == 0){
                gp.ui.titleScreenState = 1;
            }
            //LOAD GAME
            if(gp.ui.commandNum == 1){
                //to be added
            }
            //QUIT TO DESKTOP
            if(gp.ui.commandNum == 2){
                System.exit(0);
            }
        }          
        }
        
        //CHARACTER SELECT
        
        else if(gp.ui.titleScreenState == 1){
        if(code == KeyEvent.VK_UP){
            gp.ui.commandNum--;
            if(gp.ui.commandNum < 0){
                gp.ui.commandNum = 3;
            }
        }
        if(code == KeyEvent.VK_DOWN){
            gp.ui.commandNum++;
            if(gp.ui.commandNum > 3){
                gp.ui.commandNum = 0;
            }
        }
        
        if(code == KeyEvent.VK_SPACE){
            if(gp.ui.commandNum == 0){
                System.out.println("GREEN SLIME");
                gp.gameState = gp.playState;
                gp.playMusic(0);
            }            
            if(gp.ui.commandNum == 1){
                System.out.println("BLUE SLIME");
                gp.gameState = gp.playState;
                gp.playMusic(0);
            }
            if(gp.ui.commandNum == 2){
                System.out.println("RED SLIME");
                gp.gameState = gp.playState;
                gp.playMusic(0);
            }
            if(gp.ui.commandNum == 3){
                gp.ui.titleScreenState = 0;
            }
        }          
        }
        }
        
        //PLAY STATE
        if(gp.gameState == gp.playState){
        
        if(code == KeyEvent.VK_UP){
            upPressed = true;
        }
        
        if(code == KeyEvent.VK_DOWN){
            downPressed = true;
        }
        
        if(code == KeyEvent.VK_LEFT){
            leftPressed = true;
        }
        
        if(code == KeyEvent.VK_RIGHT){
            rightPressed = true;
        }
        
        //PAUSE
        if(code == KeyEvent.VK_P){
            gp.gameState = gp.pauseState;
        }
        
        //START DIALOGUE
        if(code == KeyEvent.VK_SPACE){
            enterPressed = true;
        }
        
        //DEBUG
        if(code == KeyEvent.VK_T){
            if(checkDrawTime == false){
                checkDrawTime = true;
            }
            else if (checkDrawTime == true){
            checkDrawTime = false;
            }
        }
            
        }
        
        //PAUSE STATE
        else if(gp.gameState == gp.pauseState){
            if(code == KeyEvent.VK_P){
            gp.gameState = gp.playState;}
        }
        //DIALOGUE STATE
        else if(gp.gameState == gp.dialogueState){
            if (code == KeyEvent.VK_SPACE){
                gp.gameState = gp.playState;
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent e){
        
        int code = e.getKeyCode();
        
        if(code == KeyEvent.VK_UP){
            upPressed = false;
        }
        
        if(code == KeyEvent.VK_DOWN){
            downPressed = false;
        }
        
        if(code == KeyEvent.VK_LEFT){
            leftPressed = false;
        }
        
        if(code == KeyEvent.VK_RIGHT){
            rightPressed = false;
        }
        if(code == KeyEvent.VK_ENTER){
            enterPressed = false;
        }
        if(code == KeyEvent.VK_SPACE){
            spacePressed = false;
        }
    }
    
}