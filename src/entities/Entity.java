package entities;


import mainutils.Handler;

import java.awt.Graphics;
import java.awt.Rectangle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Risad
 */
public abstract class Entity {
    protected Handler handler;
    protected float x,y;
    protected int width, height;
    protected Rectangle bounds;
    public Entity(Handler handler, float x, float y, int width, int height){
        this.handler=handler;
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        
        bounds=new Rectangle(0, 0, width, height);
    }
    public abstract void tick();
    public abstract void render(Graphics g);
    public boolean checkEntityCollisions(float xoffset, float yoffset){
        for(Entity e : handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this))
                continue;
            if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xoffset, yoffset))){
                return true;
            }
        }
        return false;
    }
    
    public boolean checkCarCollisions(float xoffset, float yoffset){
        for(Entity e : handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this))
                continue;
            if(!(e instanceof Car))continue;
            if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xoffset, yoffset))){
                return true;
            }
        }
        return false;
    }
    public boolean checkPlayerCollisions(float xoffset, float yoffset){
        for(Entity e : handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this))
                continue;
            if(!(e instanceof Player))continue;
            if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xoffset, yoffset))){
                return true;
            }
        }
        return false;
    }
    
    public boolean checkTreeCollisions(float xoffset, float yoffset){
        for(Entity e : handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this))
                continue;
            if(!(e instanceof Tree))continue;
            if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xoffset, yoffset))){
                return true;
            }
        }
        return false;
    }
    
    public boolean checkBoatCollisions(float xoffset, float yoffset){
        for(Entity e : handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this))
                continue;
            if(!(e instanceof Boat))continue;
            if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xoffset, yoffset))){
                return true;
            }
        }
        return false;
    }
    
    public Rectangle getCollisionBounds(float xoffset, float yoffset){
        return new Rectangle((int)(x+bounds.x+xoffset), (int)(y+bounds.y+yoffset), bounds.width, bounds.height);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
