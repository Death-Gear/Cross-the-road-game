package Mains;


import Mains.Display;
import ImageHelper.Assets;
import ImageHelper.SpriteSheet;
import Managers.MouseManager;
import Managers.KeyManager;
import States.GameState;
import States.State;
import States.GameOverState;
import States.MenuState;
import States.SettingsState;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.audio.*;
import java.io.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Risad
 */
public class Game implements Runnable {
    private Display display;
    private Thread thread;
    
    private BufferStrategy bs;
    private Graphics g;
    //states
    public static State gameState;
    public static State gameoverState;
    public static State menuState;
    public static State settingsState;
    //private BufferedImage testimg;
    private SpriteSheet sheet;
    //Inputs
    private KeyManager keyManager;
    private MouseManager mouseManager;
    //Camera
    private GameCamera gameCamera;
    //Handler
    private Handler handler;
    
    private static boolean running=false;

    private int width, height;
    public String title;
    public Game(String title, int width, int height){
        this.width=width;
        this.height=height;
        this.title=title;
        keyManager=new KeyManager();
        mouseManager=new MouseManager();
    }
    
    private void init(){
        display = new Display(title,width,height);
        Assets.init();
        handler = new Handler(this);
        gameCamera = new GameCamera(handler, 0, 0);
        
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
        //testimg = ImageLoader.loadImage("/textures/road.png");
        //sheet = new SpriteSheet(testimg);
        gameState = new GameState(handler);
        gameoverState = new GameOverState(handler);
        settingsState = new SettingsState(handler);
        menuState = new MenuState(handler);
        
        State.setState(menuState);
    }
    private void tick(){
        keyManager.tick();
        if(State.getState()!=null){
            State.getState().tick();
        }
    }
    private void render(){
        bs=display.getCanvas().getBufferStrategy();
        if(bs==null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g=bs.getDrawGraphics();
        //clear screen    
        
        g.clearRect(0, 0, width, height);
        //draw here
        //g.setColor(Color.WHITE);
        //g.fillRect(0, 0, width, height);
        //g.drawImage(testimg, 0, 0, null);
        
        if(State.getState()!=null){
            State.getState().render(g);
        }
        //end drawing
        bs.show();
        g.dispose();
    }
    @Override
    public void run(){
        init();
        int fps = 60;
        double timepertick = 1000000000/fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;
        while(running){
            now = System.nanoTime();
            delta+=(now-lastTime)/timepertick;
            timer+=now-lastTime;
            lastTime = now;
            if(delta>=1){
                tick();
                render();
                ticks++;
                delta--;
            }
            if(timer >= 1000000000){
                System.out.println("fps: "+ticks);
                ticks=0;
                timer=0;
            }
        }
        stop();
    }
    public KeyManager getKeyManager(){
        return keyManager;
    }
    public MouseManager getMouseManager(){
        return mouseManager;
    }
    public GameCamera getGameCamera(){
        return gameCamera;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public static boolean isRunning() {
        return running;
    }
    
    public synchronized void start(){
        if(running)return;
        running = true;
        thread=new Thread(this);
        thread.start();
    }
    public synchronized void stop(){
        if(!running)return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
