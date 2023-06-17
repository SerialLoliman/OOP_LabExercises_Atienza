package main;

import entity.NPC_OldMan;
import monster.MON_Skeleton;
import object.OBJ_Axe;
import object.OBJ_Boots;
import object.OBJ_BronzeCoin;
import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Heart;
import object.OBJ_Key;
import object.OBJ_Mana;
import object.OBJ_Potion;
import object.OBJ_Shield_V2;
import tile.tile_interactive.IT_DryTree;

public class AssetSetter {
    
    GamePanel gp;
    
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    
    public void setObject(){
        int i = 0;
        gp.obj[i] = new OBJ_Key(gp);
        gp.obj[i].worldX = gp.tileSize*25;
        gp.obj[i].worldY = gp.tileSize*25;
        i++;
        gp.obj[i] = new OBJ_Axe(gp);
        gp.obj[i].worldX = gp.tileSize*26;
        gp.obj[i].worldY = gp.tileSize*26;
        i++;
        gp.obj[i] = new OBJ_Shield_V2(gp);
        gp.obj[i].worldX = gp.tileSize*27;
        gp.obj[i].worldY = gp.tileSize*27;
        i++;
        gp.obj[i] = new OBJ_Potion(gp);
        gp.obj[i].worldX = gp.tileSize*28;
        gp.obj[i].worldY = gp.tileSize*28;
        i++;
        gp.obj[i] = new OBJ_BronzeCoin(gp);
        gp.obj[i].worldX = gp.tileSize*29;
        gp.obj[i].worldY = gp.tileSize*29;
        i++;
        gp.obj[i] = new OBJ_Heart(gp);
        gp.obj[i].worldX = gp.tileSize*30;
        gp.obj[i].worldY = gp.tileSize*30;
        i++;
        gp.obj[i] = new OBJ_Mana(gp);
        gp.obj[i].worldX = gp.tileSize*31;
        gp.obj[i].worldY = gp.tileSize*31;
        i++;
    }
    
    public void setNPC(){
        
    }
    
    public void setMonster(){
        int i = 0;
//        gp.monster[i] = new MON_Skeleton(gp);
//        gp.monster[i].worldX = gp.tileSize*25;
//        gp.monster[i].worldY = gp.tileSize*25;
//        i++;
//        
//        gp.monster[i] = new MON_Skeleton(gp);
//        gp.monster[i].worldX = gp.tileSize*25;
//        gp.monster[i].worldY = gp.tileSize*26;
//        i++;
//        
//        gp.monster[i] = new MON_Skeleton(gp);
//        gp.monster[i].worldX = gp.tileSize*25;
//        gp.monster[i].worldY = gp.tileSize*26;
//        i++;
//        
//        gp.monster[i] = new MON_Skeleton(gp);
//        gp.monster[i].worldX = gp.tileSize*24;
//        gp.monster[i].worldY = gp.tileSize*26;
//        i++;
//        
//        gp.monster[i] = new MON_Skeleton(gp);
//        gp.monster[i].worldX = gp.tileSize*23;
//        gp.monster[i].worldY = gp.tileSize*26;
//        i++;
//        
//        gp.monster[i] = new MON_Skeleton(gp);
//        gp.monster[i].worldX = gp.tileSize*25;
//        gp.monster[i].worldY = gp.tileSize*27;
//        i++;
//        
//        gp.monster[i] = new MON_Skeleton(gp);
//        gp.monster[i].worldX = gp.tileSize*24;
//        gp.monster[i].worldY = gp.tileSize*27;
//        i++;
//        
//        gp.monster[i] = new MON_Skeleton(gp);
//        gp.monster[i].worldX = gp.tileSize*23;
//        gp.monster[i].worldY = gp.tileSize*27;
//        i++;
//        
//        gp.monster[i] = new MON_Skeleton(gp);
//        gp.monster[i].worldX = gp.tileSize*22;
//        gp.monster[i].worldY = gp.tileSize*27;
//        i++;
//        
//        gp.monster[i] = new MON_Skeleton(gp);
//        gp.monster[i].worldX = gp.tileSize*21;
//        gp.monster[i].worldY = gp.tileSize*27;
//        i++;
//        
//        gp.monster[i] = new MON_Skeleton(gp);
//        gp.monster[i].worldX = gp.tileSize*20;
//        gp.monster[i].worldY = gp.tileSize*27;
//        i++;
//        
//        gp.monster[i] = new MON_Skeleton(gp);
//        gp.monster[i].worldX = gp.tileSize*25;
//        gp.monster[i].worldY = gp.tileSize*33;
//        i++;
//        
//        gp.monster[i] = new MON_Skeleton(gp);
//        gp.monster[i].worldX = gp.tileSize*24;
//        gp.monster[i].worldY = gp.tileSize*33;
//        i++;
//        
//        gp.monster[i] = new MON_Skeleton(gp);
//        gp.monster[i].worldX = gp.tileSize*23;
//        gp.monster[i].worldY = gp.tileSize*33;
//        i++;
//        
//        gp.monster[i] = new MON_Skeleton(gp);
//        gp.monster[i].worldX = gp.tileSize*22;
//        gp.monster[i].worldY = gp.tileSize*33;
//        i++;
//        
//        gp.monster[i] = new MON_Skeleton(gp);
//        gp.monster[i].worldX = gp.tileSize*21;
//        gp.monster[i].worldY = gp.tileSize*33;
//        i++;
        
        gp.monster[i] = new MON_Skeleton(gp);
        gp.monster[i].worldX = gp.tileSize*20;
        gp.monster[i].worldY = gp.tileSize*33;
        i++;
    }
    
    public void setInteractiveTile() {
    
        //Deadtree locations
        int i = 0;
        gp.iTile[i] = new IT_DryTree(gp,30,30);i++;
        gp.iTile[i] = new IT_DryTree(gp,31,30);i++;
        gp.iTile[i] = new IT_DryTree(gp,30,31);i++;
        gp.iTile[i] = new IT_DryTree(gp,31,31);i++;
        gp.iTile[i] = new IT_DryTree(gp,31,32);i++;
        gp.iTile[i] = new IT_DryTree(gp,32,31);i++;
        
    
    }
}
