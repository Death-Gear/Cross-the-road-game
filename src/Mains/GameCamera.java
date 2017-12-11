package Mains;


import Tiles.Tile;
import Entities.Entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Risad
 */
public class GameCamera {
    
    private Handler handler;
    private float xoffset,yoffset;
    public GameCamera(Handler handler, float xoffset, float yoffset){
        this.handler=handler;
        this.xoffset=xoffset;
        this.yoffset=yoffset;
    }
    
    public void checkBlankSpace(){
        /*if(xoffset<0){
            xoffset=0;
        }else if(xoffset>handler.getWorld().getWidth()*Tile.TILEWIDTH-handler.getWidth()){
            xoffset=handler.getWorld().getWidth()*Tile.TILEWIDTH-handler.getWidth();
        }*/
        xoffset=0;
        if(yoffset<0){
            yoffset=0;
        }else if(yoffset>handler.getWorld().getHeight()*Tile.TILEHEIGHT-handler.getHeight()){
            yoffset=handler.getWorld().getHeight()*Tile.TILEHEIGHT-handler.getHeight();
        }
    }
    public void centerOnEntity(Entity e){
        xoffset=e.getX()-handler.getWidth()/2+e.getWidth()/2;
        yoffset=e.getY()-handler.getHeight()/2+e.getHeight()/2;
        checkBlankSpace();
    }
    public void move(float xAmt, float yAmt){
        xoffset+=xAmt;
        yoffset+=yAmt;
        checkBlankSpace();
    }
    public float getXoffset() {
        return xoffset;
    }

    public void setXoffset(float xoffset) {
        this.xoffset = xoffset;
    }

    public float getYoffset() {
        return yoffset;
    }

    public void setYoffset(float yoffset) {
        this.yoffset = yoffset;
    }
    
}
