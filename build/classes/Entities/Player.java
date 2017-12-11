package Entities;


import Mains.Handler;
import Mains.Game;
import ImageHelper.Assets;
import ImageHelper.Animation;
import Tiles.Tile;
import States.State;
import States.GameOverState;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Risad
 */
public class Player extends Creature{
    
    //Animations
    
    private Animation animDown, animUp, animLeft, animRight;
    private int score=0;
    private static String str;

    public static String getStr() {
        return str;
    }
    
    public Player(Handler handler, float x, float y){
        super(handler,x,y,Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
        
        bounds.x=20;
        bounds.y=45;
        bounds.width=25;
        bounds.height=15;
        
        //Animations
        
        animDown=new Animation(100, Assets.player_down);
        animUp=new Animation(100, Assets.player_up);
        animLeft=new Animation(100, Assets.player_left);
        animRight=new Animation(100, Assets.player_right);
    }
    @Override
    public void tick() {
        //Animations
        animDown.tick();
        animUp.tick();
        animLeft.tick();
        animRight.tick();
        //movement
        getInput();
        move();
        score = ((handler.getWorld().getSpawny()-(int)this.getY())/Tile.TILEHEIGHT);
        handler.getGameCamera().centerOnEntity(this);
        str=Integer.toString(score);
        if(this.health<=0){
            this.health=10;
            //System.out.println(score);
            //str=Integer.toString(score);
            Game.gameoverState=new GameOverState(handler);
            State.setState(handler.getGame().gameoverState);
        }else if(this.getX()+this.bounds.x+this.bounds.width<=0 || 
                this.getX()+this.bounds.x+handler.getGameCamera().getXoffset()>=handler.getGame().getWidth()){
            str=Integer.toString(score);
            Game.gameoverState=new GameOverState(handler);
            State.setState(handler.getGame().gameoverState);
        }
            
    }
    private void getInput(){
        xmove=0;
        ymove=0;
        if(handler.getKeyManager().up)ymove=-speed;
        if(handler.getKeyManager().down)ymove=speed;
        if(handler.getKeyManager().left)xmove=-speed;
        if(handler.getKeyManager().right)xmove=speed;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int)(x-handler.getGameCamera().getXoffset()),
                (int)(y-handler.getGameCamera().getYoffset()),
                DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT, null);
        
//        g.setColor(Color.red);
//        g.fillRect((int)(x+bounds.x-handler.getGameCamera().getXoffset()),
//                (int)(y+bounds.y-handler.getGameCamera().getYoffset()), bounds.width, bounds.height);
    }
    
    private BufferedImage getCurrentAnimationFrame(){
        if(xmove<0){
            return animLeft.getCurrentFrame();
        }else if(xmove>0){
            return animRight.getCurrentFrame();
        }else if(ymove>0){
            return animDown.getCurrentFrame();
        }else if(ymove<0){
            return animUp.getCurrentFrame();
        }else
            return Assets.player_up[0];
    }
    
}
