package tile;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.UtilityTool;

public class TileManager {
    
    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];
    
    
    public TileManager(GamePanel gp){
    
    this.gp = gp;
    
    tile = new Tile[50];//max number of tile object variations
    mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
    
    getTileImage();
    loadMap("/res/maps/world03.txt");
    }
    
    public void getTileImage(){
    
    //PLACEHOLDER
    setup(0, "grass", false);
    setup(1, "grass", false);
    setup(2, "grass", false);
    setup(3, "grass", false);
    setup(4, "grass", false);
    setup(5, "grass", false);
    setup(6, "grass", false);
    setup(7, "grass", false);
    setup(8, "grass", false);
    setup(9, "grass", false);
    //PLACEHOLDER
    
    setup(10, "grass", false);
    setup(11, "wall", true);
    setup(12, "water", true);
    setup(13, "road", false);
    setup(14, "tree", true);
    setup(15, "earth", false);
    setup(16, "grass2", false);
    setup(17, "waterU", true);
    setup(18, "waterUL", true);
    setup(19, "waterUR", true);
    setup(20, "waterD", true);
    setup(21, "waterDL", true);
    setup(22, "waterDR", true);
    setup(23, "waterL", true);
    setup(24, "waterR", true);
    setup(25, "waterULs", true);
    setup(26, "waterURs", true);
    setup(27, "waterDLs", true);
    setup(28, "waterDRs", true);
    setup(29, "watersh", true);
    
    setup(30, "roadU", false);
    setup(31, "roadUL", false);
    setup(32, "roadUR", false);
    setup(33, "roadD", false);
    setup(34, "roadDL", false);
    setup(35, "roadDR", false);
    setup(36, "roadL", false);
    setup(37, "roadR", false);
    setup(38, "roadULs", false);
    setup(39, "roadURs", false);
    setup(40, "roadDRs", false);
    setup(41, "roadDLs", false);
    
}
    
    public void setup(int index, String imageName, boolean collision){
    
    UtilityTool uTool = new UtilityTool();
    
    try{
        tile[index] = new Tile();
        tile[index].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/" + imageName + ".png"));
        tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
        tile[index].collision = collision;
        
    }
    catch(IOException e){
        e.printStackTrace();}
        
    }
    public void loadMap(String filePath){
    
    try{
    InputStream is = getClass().getResourceAsStream(filePath);
    BufferedReader br = new BufferedReader(new InputStreamReader(is));
    
    int col = 0;
    int row = 0;
    
    while (col<gp.maxWorldCol&& row<gp.maxWorldRow){
    
    String line = br.readLine();
    
    while (col<gp.maxWorldCol){
    String numbers[] = line.split(" ");
    
    int num = Integer.parseInt(numbers[col]);
    
    mapTileNum[col][row] = num;
    col++;
    }
    
    if (col == gp.maxWorldCol){
    col = 0;
    row++;
    }
    }
    br.close();
    
    }catch (Exception e){}
    }
    
    public void draw(Graphics2D g2){
    
        int worldCol = 0;
        int worldRow = 0;
        
        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow){
        
            int tileNum = mapTileNum[worldCol][worldRow];
            
            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;
            
            
            //Draws only the tiles on the screen to save extra processing speed
            if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && 
               worldX - gp.tileSize < gp.player.worldX + gp.player.screenX && 
               worldY + gp.tileSize > gp.player.worldY - gp.player.screenY && 
               worldY - gp.tileSize < gp.player.worldY + gp.player.screenY){
            
               g2.drawImage(tile[tileNum].image,screenX,screenY,null);
            }
            
        
        worldCol++;
        
        if (worldCol == gp.maxWorldCol){
        worldCol = 0;
        worldRow++;
        
        
        }
        
        }
    }
}
