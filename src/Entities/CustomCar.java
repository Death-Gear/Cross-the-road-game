package Entities;


import Mains.Handler;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
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
public class CustomCar extends Creature{
    
    protected float speed;
    protected int index;
    public static ArrayList<BufferedImage> cars=new ArrayList();
    public CustomCar(Handler handler, float x, float y, int width, int height, float speed, int index) {
        super(handler, x, y, width, height);
        this.speed=speed;
        this.index=index;
        
         //bounds
        
        bounds.x=0;
        bounds.y=height/2-10;
        bounds.width=width;
        bounds.height=height/2;
    }

    @Override
    public void tick() {
        xmove=speed;
        move();
        if(this.getX()>=handler.getGame().getWidth())this.setX(0);
        else if(this.getX()<=0)this.setX(handler.getGame().getWidth());
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(cars.get(index), (int)(x-handler.getGameCamera().getXoffset()), 
                (int)(y-handler.getGameCamera().getYoffset()),width,height, null);
    }
    
    @Override
    public void move(){
        if(checkPlayerCollisions(xmove, 0f)){
            handler.getWorld().getEntityManager().getPlayer().health--;
        }else freemoveX();    
    }
    
}
