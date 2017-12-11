package Entities;


import Mains.Handler;
import ImageHelper.Assets;
import Tiles.Tile;
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
public class Tree extends StaticEntity{
    public Tree(Handler handler, float x, float y){
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT*2);
        bounds.x=15;
        bounds.y=(int)(height/1.5f)+13;
        bounds.width=(width-20)/2+18;
        bounds.height=(int)(height-height/1.5f)-13;
    }

    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) {
        if(handler.getWorld().getEntityManager().getPlayer().getY()-this.y<handler.getGame().getHeight()/2+100){
            g.drawImage(Assets.tree, (int)(x/*-handler.getGameCamera().getXoffset()*/), 
                (int)(y-handler.getGameCamera().getYoffset()), width, height, null);
        }
        //g.setColor(Color.red);
        //g.fillRect((int)(x+bounds.x-handler.getGameCamera().getXoffset()),
                //(int)(y+bounds.y-handler.getGameCamera().getYoffset()), bounds.width, bounds.height);
    }
}
