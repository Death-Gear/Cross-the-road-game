package Entities;


import Mains.Handler;
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
public abstract class Creature extends Entity{
    public static final int DEFAULT_HEALTH=10;
    public static final float DEFAULT_SPEED=1f;
    public static final int DEFAULT_CREATURE_WIDTH=64;
    public static final int DEFAULT_CREATURE_HEIGHT=64;
    
    protected int health;
    protected float speed,xmove,ymove;
    public Creature(Handler handler, float x, float y,int width, int height) {
        super(handler, x, y, width, height);
        health=DEFAULT_HEALTH;
        speed=DEFAULT_SPEED;
        xmove=0;
        ymove=0;
    }
    
    public void move(){
        if(checkBoatCollisions(xmove, 0f)){
            freemoveX();
        }
        else if(!checkTreeCollisions(xmove, 0f)){
            moveX();
        }
        if(checkCarCollisions(xmove, 0f)){
            handler.getWorld().getEntityManager().getPlayer().health--;
        }
        if(checkBoatCollisions(0f, ymove)){
            freemoveY();
        }
        else if(!checkTreeCollisions(0f, ymove)){
            moveY();
        }
        if(checkCarCollisions(0f, ymove)){
            handler.getWorld().getEntityManager().getPlayer().health--;
        }
        
        
    }
    public void freemoveX(){
        x+=xmove;
    }
    public void freemoveY(){
        y+=ymove;
    }
    
    public void moveX(){
        if(xmove>0){//moving right
            int tx = (int)(x+xmove+bounds.x+bounds.width)/Tile.TILEWIDTH;
            if(!collisionWithTile(tx, (int)(y+bounds.y)/Tile.TILEHEIGHT)&&
                    !collisionWithTile(tx, (int)(y+bounds.y+bounds.height)/Tile.TILEHEIGHT)){
                x+=xmove;
            }else{
                handler.getWorld().getEntityManager().getPlayer().health--;
                //x=tx*Tile.TILEWIDTH-bounds.x-bounds.width-1;
            }
        }else if(xmove<0){//moving left
            int tx = (int)(x+xmove+bounds.x)/Tile.TILEWIDTH;
            if(!collisionWithTile(tx, (int)(y+bounds.y)/Tile.TILEHEIGHT)&&
                    !collisionWithTile(tx, (int)(y+bounds.y+bounds.height)/Tile.TILEHEIGHT)){
                x+=xmove;
            }else{
                handler.getWorld().getEntityManager().getPlayer().health--;
                //x=tx*Tile.TILEWIDTH+Tile.TILEWIDTH-bounds.x;
            }
        }
//            if(xmove>0)x+=xmove;
//            else if(xmove<0)x+=xmove;
    }
    public void moveY(){
        if(ymove<0){//moving up
            int ty = (int)(y+ymove+bounds.y)/Tile.TILEHEIGHT;
            if(!collisionWithTile((int)(x+bounds.x)/Tile.TILEWIDTH,ty)&&
                    !collisionWithTile((int)(x+bounds.x+bounds.width)/Tile.TILEWIDTH,ty)){
                y+=ymove;
            }else{
                handler.getWorld().getEntityManager().getPlayer().health--;
                //y=ty*Tile.TILEHEIGHT+Tile.TILEHEIGHT-bounds.y;
            }
        }else if(ymove>0){//moving down
            int ty = (int)(y+ymove+bounds.y+bounds.height)/Tile.TILEHEIGHT;
            if(!collisionWithTile((int)(x+bounds.x)/Tile.TILEWIDTH,ty)&&
                    !collisionWithTile((int)(x+bounds.x+bounds.width)/Tile.TILEWIDTH,ty)){
                y+=ymove;
            }else{
                handler.getWorld().getEntityManager().getPlayer().health--;
                //y=ty*Tile.TILEHEIGHT-bounds.y-bounds.height-1;
            }
        }
    }
    
    protected boolean collisionWithTile(int x, int y){
        return handler.getWorld().getTile(x, y).isSolid();
    }

    public float getXmove() {
        return xmove;
    }

    public void setXmove(float xmove) {
        this.xmove = xmove;
    }

    public float getYmove() {
        return ymove;
    }

    public void setYmove(float ymove) {
        this.ymove = ymove;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
    
}
