package main;

import entity.NPC_OldMan;
import object.OBJ_Boots;
import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Key;

public class AssetSetter {
    
    GamePanel gp;
    
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
public void setObject(){
    
    gp.obj[0] = new OBJ_Key(gp);
    gp.obj[0].worldX = 39 * gp.tileSize;
    gp.obj[0].worldY = 11 * gp.tileSize;
    
    gp.obj[1] = new OBJ_Key(gp);
    gp.obj[1].worldX = 9 * gp.tileSize;
    gp.obj[1].worldY = 40 * gp.tileSize;

    gp.obj[2] = new OBJ_Key(gp);
    gp.obj[2].worldX = 40 * gp.tileSize;
    gp.obj[2].worldY = 40 * gp.tileSize;
    
    gp.obj[3] = new OBJ_Door(gp);
    gp.obj[3].worldX = 22 * gp.tileSize;
    gp.obj[3].worldY = 22 * gp.tileSize;

    gp.obj[4] = new OBJ_Door(gp);
    gp.obj[4].worldX = 22 * gp.tileSize;
    gp.obj[4].worldY = 23 * gp.tileSize;

    gp.obj[5] = new OBJ_Door(gp);
    gp.obj[5].worldX = 22 * gp.tileSize;
    gp.obj[5].worldY = 24 * gp.tileSize;
    
    gp.obj[6] = new OBJ_Boots(gp);
    gp.obj[6].worldX = 30 * gp.tileSize;
    gp.obj[6].worldY = 30 * gp.tileSize;
    
    gp.obj[7] = new OBJ_Chest(gp);
    gp.obj[7].worldX = 22 * gp.tileSize;
    gp.obj[7].worldY = 15 * gp.tileSize;
}
public void setNPC(){
    
    gp.npc[0] = new NPC_OldMan(gp);
    gp.npc[0].worldX = gp.tileSize*23;
    gp.npc[0].worldY = gp.tileSize*25;
    
    
}
}
