package ai.data;

import entity.Entity;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import main.GamePanel;
import object.OBJ_Axe;
import object.OBJ_Boots;
import object.OBJ_BronzeCoin;
import object.OBJ_Potion;
import object.OBJ_Shield;
import object.OBJ_Sword;


public class SaveLoad {
    
    GamePanel gp;
    public SaveLoad(GamePanel gp){
    
        this.gp = gp;
    
    }
    
    public Entity getObject(String itemName){
    
        Entity obj = null;
        
        switch(itemName){
        
            case "Basic Axe": obj = new OBJ_Axe(gp); break;
            case "Boots": obj = new OBJ_Boots(gp); break;
            case "Bronze Coin": obj = new OBJ_BronzeCoin(gp); break;
            case "Key": obj = new OBJ_Axe(gp); break;
            case "Food": obj = new OBJ_Potion(gp); break;
            case "Basic Shield": obj = new OBJ_Shield(gp); break;
            case "Basic Sword": obj = new OBJ_Sword(gp); break;
            
        }
        return obj;
    }
    
    public void save(){
    try{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("save.dat")));
        
        DataStorage ds = new DataStorage();
        
        //PLAYER STATS
        ds.level = gp.player.level;
        ds.maxLife = gp.player.maxLife;
        ds.life = gp.player.life;
        ds.maxMana = gp.player.maxMana;
        ds.mana = gp.player.mana;
        ds.strength = gp.player.strength;
        ds.dexterity = gp.player.dexterity;
        ds.exp = gp.player.exp;
        ds.nextLevelExp = gp.player.nextLevelExp;
        ds.coin = gp.player.coin;
        
        //PLAYER INVENTORY
        for(int i=0; i<gp.player.inventory.size(); i++){
        
            ds.itemNames.add(gp.player.inventory.get(i).name);
//            ds.itemAmounts.add(gp.player.inventory.get(i).amount);
        
        }
        
        //PLAYER EQUIPMENT
        ds.currentWeaponSlot = gp.player.getCurrentWeaponSlot();
        ds.currentShieldSlot = gp.player.getCurrentShieldSlot();
        
        //OBJECTS ON MAP
        ds.mapObjectNames = new String[gp.maxMap][gp.obj[1].length];
        ds.mapObjectWorldX = new int[gp.maxMap][gp.obj[1].length];
        ds.mapObjectWorldY = new int[gp.maxMap][gp.obj[1].length];
        ds.mapObjectLootNames = new String[gp.maxMap][gp.obj[1].length];
        ds.mapObjectOpened = new boolean[gp.maxMap][gp.obj[1].length];
        
        for(int mapNum = 0; mapNum < gp.maxMap; mapNum++){
        
            for(int i = 0; i< gp.obj[1].length;i++){
            
                
                if(gp.obj[mapNum][i] == null){
                
                    ds.mapObjectNames[mapNum][i] = "NA";
                
                }
                
                else{
                
                    ds.mapObjectNames[mapNum][i] = gp.obj[mapNum][i].name;
                    ds.mapObjectWorldX[mapNum][i] = gp.obj[mapNum][1].worldX;
                    ds.mapObjectWorldY[mapNum][i] = gp.obj[mapNum][1].worldY;
//                    if(gp.obj[mapNum][i].loot != null);
//                        ds.mapObjectLootNames[mapNum][i] = gp.obj[mapNum][i].loot.name;
                }
//                    ds.mapObjectOpened[mapNum][i] = gp.obj[mapNum][i].opened;
            }
        
        }
        
        //Write the DataStorage object
        oos.writeObject(ds);
        
    }
    catch(Exception e){System.out.println("Save Exception!");}
    }
    public void load(){
        
        try{
        
          ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("save.dat")));  
          
          //Read the DataStorage object
          DataStorage ds = (DataStorage)ois.readObject();
          
          gp.player.level = ds.level;
          gp.player.maxLife = ds.maxLife;
          gp.player.life = ds.life;
          gp.player.maxMana = ds.maxMana;
          gp.player.mana = ds.mana;
          gp.player.strength = ds.strength;
          gp.player.dexterity = ds.dexterity;
          gp.player.exp = ds.exp;
          gp.player.nextLevelExp = ds.nextLevelExp;
          gp.player.coin = ds.coin;
          //PLAYER INVENTORY
          gp.player.inventory.clear();
          
          for(int i = 0; i<ds.itemNames.size(); i++){
          
              gp.player.inventory.add(getObject(ds.itemNames.get(i)));
          
          
          }
          //PLAYER EQUIPMENT
          gp.player.currentWeapon = gp.player.inventory.get(ds.currentWeaponSlot);
          gp.player.currentShield = gp.player.inventory.get(ds.currentShieldSlot);
          gp.player.getAttack();
          gp.player.getDefense();
//          gp.player.getAttackImage();

            //OBJECTS ON MAP
            for(int mapNum = 0; mapNum < gp.maxMap; mapNum++){
            
                for(int i=0; i<gp.obj[1].length;i++){
                
                    if(ds.mapObjectNames[mapNum][i].equals("NA")){
                    
                        gp.obj[mapNum][i] = null;
                    
                    }
                    else{
                    
                        gp.obj[mapNum][i] = getObject(ds.mapObjectNames[mapNum][i]);
                        gp.obj[mapNum][i].worldX = ds.mapObjectWorldX[mapNum][i];
                        gp.obj[mapNum][i].worldY = ds.mapObjectWorldY[mapNum][i];
//                        if(ds.mapObjectLootNames[mapNum][i] !=null){
//                        
//                            gp.obj[mapNum][i].loot = getObject(ds.mapObjectLootNames[mapNum][i]);
//                        }
//                        gp.obj[mapNum][i].opened = ds.mapObjectOpened[mapNum][i];
//                        if(gp.[mapNum][i].opened == true){
//                        
//                            gp.obj[mapNum][i].down1 = gp.obj[mapNum][i].image2;
//                        }
                    }
                }
            
            
            }
        }
        catch(Exception e){System.out.println("Load Exception!");}
    
    
    }
}
