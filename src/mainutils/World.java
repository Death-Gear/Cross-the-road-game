package mainutils;


import entities.Player;
import entities.CustomCar;
import entities.EntityManager;
import tiles.Tile;
import entities.Car;
import entities.Boat;
import entities.Tree;
import java.awt.Graphics;
import oop.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Risad
 */
public class World {
    private Handler handler;
    private int width, height;
    private static int spawnx, spawny;
    private int[][] tiles;
    //Entities
    private EntityManager entityManager;
    public World(Handler handler, String path){
        this.handler=handler;
        entityManager=new EntityManager(handler, new Player(handler,400,500));
                
        //tree start
        entityManager.addEntity(new Tree(handler, 100, 2870));
        entityManager.addEntity(new Tree(handler, 400, 2860));
        entityManager.addEntity(new Tree(handler, 250, 2480));
        entityManager.addEntity(new Tree(handler, 460, 2480));
        entityManager.addEntity(new Tree(handler, 80, 2480));
        entityManager.addEntity(new Tree(handler, 120, 2040));
        entityManager.addEntity(new Tree(handler, 20, 2040));
        entityManager.addEntity(new Tree(handler, 420, 2040));
        entityManager.addEntity(new Tree(handler, 520, 2040));
        entityManager.addEntity(new Tree(handler, 140, 1850));
        entityManager.addEntity(new Tree(handler, 290, 1850));
        entityManager.addEntity(new Tree(handler, 440, 1850));
        entityManager.addEntity(new Tree(handler, 540, 1850));
        entityManager.addEntity(new Tree(handler, 40, 1850));
        entityManager.addEntity(new Tree(handler, 520, 1520));
        entityManager.addEntity(new Tree(handler, 120, 1530));
        entityManager.addEntity(new Tree(handler, 20, 1530));
        entityManager.addEntity(new Tree(handler, 420, 1520));
        entityManager.addEntity(new Tree(handler, 250, 1130));
        entityManager.addEntity(new Tree(handler, 460, 1140));
        entityManager.addEntity(new Tree(handler, 80, 1130));
        entityManager.addEntity(new Tree(handler, 520, 930));
        entityManager.addEntity(new Tree(handler, 120, 940));
        entityManager.addEntity(new Tree(handler, 20, 935));
        entityManager.addEntity(new Tree(handler, 420, 940));
        entityManager.addEntity(new Tree(handler, 250, 440));
        entityManager.addEntity(new Tree(handler, 460, 450));
        entityManager.addEntity(new Tree(handler, 80, 450));
        entityManager.addEntity(new Tree(handler, 140, 250));
        entityManager.addEntity(new Tree(handler, 280, 250));
        entityManager.addEntity(new Tree(handler, 440, 250));
        entityManager.addEntity(new Tree(handler, 540, 250));
        entityManager.addEntity(new Tree(handler, 40, 250));
        //tree end
        loadWorld(path);
        //Car start
        if(OOP.getIndx()>=0)
            entityManager.addEntity(new CustomCar(handler, 0, 3050, 128, 68, 2f, 0));
        else 
            entityManager.addEntity(new Car(handler, 0, 3050, 128, 68, 2f, 0));
        if(OOP.getIndx()>=1)
            entityManager.addEntity(new CustomCar(handler, 300, 3060, 128, 68, 2f, 1));
        else
            entityManager.addEntity(new Car(handler, 300, 3060, 128, 68, 2f, 2));
        if(OOP.getIndx()>=2)
            entityManager.addEntity(new CustomCar(handler, 200, 2980, 138, 88, 2f, 2));
        else
            entityManager.addEntity(new Car(handler, 200, 2980, 138, 88, 2f, 1));
        if(OOP.getIndx()>=3)
            entityManager.addEntity(new CustomCar(handler, 450, 2975, 138, 88, 2f, 3));
        else
            entityManager.addEntity(new Car(handler, 450, 2975, 138, 88, 2f, 3));
        if(OOP.getIndx()>=4)
            entityManager.addEntity(new CustomCar(handler, 50, 2720, 138, 88, 2f, 4));
        else
            entityManager.addEntity(new Car(handler, 50, 2720, 230, 92, 2f, 13));
        if(OOP.getIndx()>=5)
            entityManager.addEntity(new CustomCar(handler, 350, 2700, 138, 88, 2f, 5));
        else
            entityManager.addEntity(new Car(handler, 350, 2700, 146, 104, 2f, 5));
        if(OOP.getIndx()>=6)
            entityManager.addEntity(new CustomCar(handler, 20, 2660, 128, 72, 2f, 6));
        else
            entityManager.addEntity(new Car(handler, 20, 2660, 128, 72, 2f, 8));
        if(OOP.getIndx()>=7)
            entityManager.addEntity(new CustomCar(handler, 290, 2680, 100, 64, 2f, 7));
        else
            entityManager.addEntity(new Car(handler, 290, 2680, 100, 64, 2f, 6));
        if(OOP.getIndx()>=8)
            entityManager.addEntity(new CustomCar(handler, 65, 2600, 292, 94, 2f, 8));
        else
            entityManager.addEntity(new Car(handler, 65, 2600, 292, 94, 2f, 11));
        if(OOP.getIndx()>=9)
            entityManager.addEntity(new CustomCar(handler, 400, 2590, 136, 70, 2f, 9));
        else
            entityManager.addEntity(new Car(handler, 400, 2590, 136, 70, 2f, 7));
        
        entityManager.addEntity(new Car(handler, 70, 2200, 132, 78, 2.5f, 10));
        entityManager.addEntity(new Car(handler, 400, 2222, 132, 68, 2.5f, 4));
        entityManager.addEntity(new Car(handler, 70, 2150, 128, 68, 2f, 2));
        entityManager.addEntity(new Car(handler, 380, 2165, 116, 68, 2.5f, 12));
        entityManager.addEntity(new Car(handler, 0, 2010, 136, 78, 2f, 3));
        entityManager.addEntity(new Car(handler, 290, 2035, 140, 84, 2.5f, 9));
        entityManager.addEntity(new Car(handler, 70, 1950, 128, 72, 2f, 8));
        entityManager.addEntity(new Car(handler, 380, 1960, 132, 84, 2.5f, 14));
        entityManager.addEntity(new Car(handler, 400, 1820, 132, 68, 2f, 4));
        entityManager.addEntity(new Car(handler, 380, 1845, 116, 68, 2.5f, 12));
        entityManager.addEntity(new Car(handler, 70, 1770, 132, 78, 3f, 10));
        entityManager.addEntity(new Car(handler, 50, 1690, 230, 92, 3f, 11));
        entityManager.addEntity(new Car(handler, 0, 1630, 128, 68, 2.5f, 0));
        entityManager.addEntity(new Car(handler, 350, 1630, 146, 104, 2f, 5));
        entityManager.addEntity(new Car(handler, 380, 1320, 132, 84, 2.5f, 14));
        entityManager.addEntity(new Car(handler, 290, 1280, 140, 84, 3f, 9));
        entityManager.addEntity(new Car(handler, 20, 1260, 128, 72, 2.5f, 8));
        entityManager.addEntity(new Car(handler, 200, 1120, 138, 88, 2.5f, 1));
        entityManager.addEntity(new Car(handler, 70, 1115, 128, 68, 3f, 2));
        entityManager.addEntity(new Car(handler, 50, 1060, 230, 92, 3f, 13));
        entityManager.addEntity(new Car(handler, 70, 1050, 128, 72, 2.5f, 8));
        entityManager.addEntity(new Car(handler, 380, 680, 132, 84, 3f, 14));
        entityManager.addEntity(new Car(handler, 65, 680, 128, 68, 3f, 2));
        entityManager.addEntity(new Car(handler, 450, 540, 138, 88, 3f, 3));
        entityManager.addEntity(new Car(handler, 130, 540, 136, 70, 3f, 7));
        entityManager.addEntity(new Car(handler, 0, 380, 128, 68, 3.5f, 0));
        entityManager.addEntity(new Car(handler, 50, 325, 230, 92, 3.5f, 11));
        entityManager.addEntity(new Car(handler, 350, 220, 146, 104, 3.5f, 5));
        entityManager.addEntity(new Car(handler, 290, 220, 100, 64, 3.5f, 6));
        entityManager.addEntity(new Car(handler, 380, 120, 116, 68, 3.5f, 12));
        entityManager.addEntity(new Car(handler, 50, 120, 132, 68, 3.5f, 4));
        entityManager.addEntity(new Car(handler, 200, 75, 138, 88, 3.5f, 1));
        //Car end
        //Boat start
        entityManager.addEntity(new Boat(handler, 100, 2877, 128, 68, 1.5f, 1));
        entityManager.addEntity(new Boat(handler, 400, 2877, 128, 68, 1.5f, 1));
        entityManager.addEntity(new Boat(handler, 70, 2493, 128, 68, 1.5f, 0));
        entityManager.addEntity(new Boat(handler, 350, 2493, 128, 68, 1.5f, 0));
        entityManager.addEntity(new Boat(handler, 40, 2364, 128, 68, 1.5f, 1));
        entityManager.addEntity(new Boat(handler, 310, 2364, 128, 68, 1.5f, 1));
        entityManager.addEntity(new Boat(handler, 70, 1535, 128, 68, 2f, 0));
        entityManager.addEntity(new Boat(handler, 350, 1535, 128, 68, 2f, 0));
        entityManager.addEntity(new Boat(handler, 40, 1468, 128, 68, 1.5f, 1));
        entityManager.addEntity(new Boat(handler, 310, 1468, 128, 68, 1.5f, 1));
        entityManager.addEntity(new Boat(handler, 40, 890, 128, 68, 2.5f, 1));
        entityManager.addEntity(new Boat(handler, 290, 825, 128, 68, 2f, 1));
        entityManager.addEntity(new Boat(handler, 70, 635, 128, 68, 2.5f, 0));
        entityManager.addEntity(new Boat(handler, 290, 445, 128, 68, 2.5f, 1));
        entityManager.addEntity(new Boat(handler, 0, 445, 128, 68, 2.5f, 1));
        entityManager.addEntity(new Boat(handler, 70, 187, 128, 68, 2.5f, 0));
        entityManager.addEntity(new Boat(handler, 350, 187, 128, 68, 3f, 0));
        entityManager.addEntity(new Boat(handler, 290, 60, 128, 68, 3f, 1));
        entityManager.addEntity(new Boat(handler, 10, 60, 128, 68, 3f, 1));
        //Boat end
        
        entityManager.getPlayer().setX(spawnx);
        entityManager.getPlayer().setY(spawny);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
    
    public void tick(){
        entityManager.tick();
    }
    
    public void render(Graphics g){
        int xstart = (int)Math.max(0, handler.getGameCamera().getXoffset()/Tile.TILEWIDTH);
        int xend = (int)Math.min(width, (handler.getGameCamera().getXoffset()+handler.getWidth())/Tile.TILEWIDTH+1);
        int ystart = (int)Math.max(0, handler.getGameCamera().getYoffset()/Tile.TILEHEIGHT);
        int yend = (int)Math.min(height, (handler.getGameCamera().getYoffset()+handler.getHeight())/Tile.TILEHEIGHT+1);;
        for(int y=ystart; y<yend; y++){
            for(int x=xstart; x<xend; x++){
                getTile(x, y).render(g, (int)(x * Tile.TILEWIDTH-handler.getGameCamera().getXoffset()), 
                        (int)(y * Tile.TILEHEIGHT - handler.getGameCamera().getYoffset()));
            }
        }
        //Entities
        entityManager.render(g);
    }
    
    public Tile getTile(int x, int y){
        if(x<0 || y<0 || x>=width || y>=height)
            return Tile.grassTile;
        Tile t = Tile.tiles[tiles[x][y]];
        if(t==null)
            return Tile.rockTile;
        return t;
    }
    
    private void loadWorld(String path){
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnx = Utils.parseInt(tokens[2]);
        spawny = Utils.parseInt(tokens[3]);
        
        tiles = new int[width][height];
        for(int y=0; y<height; y++){
            for(int x=0; x<width; x++){
                tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
            }
        }
    }

    public static int getSpawnx() {
        return spawnx;
    }

    public static int getSpawny() {
        return spawny;
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
}
