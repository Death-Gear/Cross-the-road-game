package Entities;


import Mains.Handler;
import ImageHelper.Assets;
import java.awt.Color;
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Risad
 */
public class Boat extends Creature{

    protected float speed;
    protected int index;
    public Boat(Handler handler, float x, float y, int width, int height,  float speed, int index) {
        super(handler, x, y, width, height);
        this.speed=speed;
        this.index=index;
        
        //Bounds
        
        bounds.x=5;
        bounds.y=2;
        bounds.width=width-10;
        bounds.height=height;
    }

    @Override
    public void tick() {
        
        if(index==1)xmove = speed;
        else xmove=-speed;
        move();
        if(this.getX()>=handler.getGame().getWidth())this.setX(0);
        else if(this.getX()<=0)this.setX(handler.getGame().getWidth());
    }

    @Override
    public void render(Graphics g) {
        if(handler.getWorld().getEntityManager().getPlayer().getY()-this.y<handler.getGame().getHeight()/2+100){
            g.drawImage(Assets.boat, (int)(x/*-handler.getGameCamera().getXoffset()*/), 
                (int)(y-handler.getGameCamera().getYoffset()),width,height, null);
        }      
//        g.setColor(Color.red);
//        g.fillRect((int)(x+bounds.x-handler.getGameCamera().getXoffset()),
//                (int)(y+bounds.y-handler.getGameCamera().getYoffset()), bounds.width, bounds.height);
    }
    @Override
    public void move(){
        freemoveX();
        if(checkPlayerCollisions(xmove, 0f)){
            handler.getWorld().getEntityManager().getPlayer().xmove=xmove;
            handler.getWorld().getEntityManager().getPlayer().freemoveX();
        }    
    }
    
}
