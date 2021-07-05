package entities;


import mainutils.Handler;
import imagehelper.Assets;

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
public class Car extends Creature{

    protected float speed;
    protected int index;
    public Car(Handler handler, float x, float y, int width, int height, float speed, int index) {
        super(handler, x, y, width, height);
        this.speed=speed;
        this.index=index;
        
        //bounds
        
        bounds.x=0;
        bounds.y=height/2;
        bounds.width=width;
        bounds.height=height/2-10;
        
    }

    @Override
    public void tick() {
        if(index%2==0)
            xmove=speed;
        else 
            xmove=-speed;
        move();
        if(this.getX()>=handler.getGame().getWidth())this.setX(0);
        else if(this.getX()<=0)this.setX(handler.getGame().getWidth());
    }

    @Override
    public void render(Graphics g) {
        if(handler.getWorld().getEntityManager().getPlayer().getY()-this.y<handler.getGame().getHeight()/2+100){
            g.drawImage(Assets.car[index], (int)(x/*-handler.getGameCamera().getXoffset()*/), 
                (int)(y-handler.getGameCamera().getYoffset()),width,height, null);
        }
            
//        g.setColor(Color.red);
//        g.fillRect((int)(x+bounds.x-handler.getGameCamera().getXoffset()),
//                (int)(y+bounds.y-handler.getGameCamera().getYoffset()), bounds.width, bounds.height);
    }
    
    @Override
    public void move(){
        if(checkPlayerCollisions(xmove, 0f)){
            handler.getWorld().getEntityManager().getPlayer().health--;
        }else freemoveX();    
    }
    
}
