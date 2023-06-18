package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyHandler implements KeyListener{
    
    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed, spacePressed, shotKeyPressed, sleeping;
    
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
            titleState(code);     
        }
        //PLAY STATE
        else if(gp.gameState == gp.playState){
            playState(code); 
        }
        //PAUSE STATE
        else if(gp.gameState == gp.pauseState){
            pauseState(code); 
        }
        //DIALOGUE STATE
        else if(gp.gameState == gp.dialogueState){
            dialogueState(code); 
        }
        //CHARACTER STATE
        else if(gp.gameState == gp.characterState){
            characterState(code); 
        }  
    }
    
    public void titleState(int code){
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
        
        if(code == KeyEvent.VK_Z){
            //NEW GAME
            if(gp.ui.commandNum == 0){
                gp.gameState = gp.playState;
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
    public void playState(int code){
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
        
        //START DIALOGUE & ATTACK
        if(code == KeyEvent.VK_Z){
            spacePressed = true;
            gp.player.fatiguePoints--;
        }
        
        //SLEEP
        if(code == KeyEvent.VK_S){
            if(sleeping == true){sleeping = false;}
            else{
                sleeping = true; 
                gp.player.fatiguePoints = 1000;}
        }
        
        //OPEN CHARACTER STATS
        if(code == KeyEvent.VK_E){
            gp.gameState = gp.characterState;
        }
        //PROJECTILE
        if(code == KeyEvent.VK_X){
            shotKeyPressed = true;
            gp.player.fatiguePoints--;
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
    public void pauseState(int code){
            if(code == KeyEvent.VK_P){
            gp.gameState = gp.playState;
            }
    }
    public void dialogueState(int code){
            if (code == KeyEvent.VK_Z){
            gp.gameState = gp.playState;
            }
    }
    public void characterState(int code){
        
        //INVENTORY
        if(code == KeyEvent.VK_E){
        gp.gameState = gp.playState;
        }
        
        //MOVE INVENTORY CURSOR
        if(code == KeyEvent.VK_UP){
            if(gp.ui.slotRow != 0){
            gp.ui.slotRow--;
            }
        }
        
        if(code == KeyEvent.VK_DOWN){
            if(gp.ui.slotRow != 3){
            gp.ui.slotRow++;
            }
        }
        
        if(code == KeyEvent.VK_LEFT){
            if(gp.ui.slotCol != 0){
            gp.ui.slotCol--;
            }
        }
        
        if(code == KeyEvent.VK_RIGHT){
            if(gp.ui.slotCol != 4){
            gp.ui.slotCol++;
            }
        }
        if(code == KeyEvent.VK_Z){
            gp.player.selectItem();
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
        if(code == KeyEvent.VK_Z){
            spacePressed = false;
        }
        if(code == KeyEvent.VK_X){
            shotKeyPressed = false;
        }
    }
}

//CHARACTER SELECT       
//        else if(gp.ui.titleScreenState == 1){
//        if(code == KeyEvent.VK_UP){
//            gp.ui.commandNum--;
//            if(gp.ui.commandNum < 0){
//                gp.ui.commandNum = 3;
//            }
//        }
//        if(code == KeyEvent.VK_DOWN){
//            gp.ui.commandNum++;
//            if(gp.ui.commandNum > 3){
//                gp.ui.commandNum = 0;
//            }
//        }
//        
//        if(code == KeyEvent.VK_SPACE){
//            if(gp.ui.commandNum == 0){
//                System.out.println("GREEN SLIME");
//                gp.gameState = gp.playState;
//                gp.playMusic(0);
//            }            
//            if(gp.ui.commandNum == 1){
//                System.out.println("BLUE SLIME");
//                gp.gameState = gp.playState;
//                gp.playMusic(0);
//            }
//            if(gp.ui.commandNum == 2){
//                System.out.println("RED SLIME");
//                gp.gameState = gp.playState;
//                gp.playMusic(0);
//            }
//            if(gp.ui.commandNum == 3){
//                gp.ui.titleScreenState = 0;
//            }
//        }          
//        }