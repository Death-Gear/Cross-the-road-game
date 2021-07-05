package states;


import mainutils.Handler;
import mainutils.Game;
import imagehelper.Assets;
import managers.ClickListener;
import uiclass.UIImageButton;
import managers.UIManager;
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
public class SettingsState extends State{

    private UIManager uimanager;
    
    public SettingsState(Handler handler) {
        super(handler);
        uimanager = new UIManager(handler);
        handler.getMouseManager().setUIManager(uimanager);
        
        uimanager.addObject(new UIImageButton(30, 30, 64, 64, Assets.back, new ClickListener(){
            @Override
            public void onClick() {
                handler.getMouseManager().setUIManager(null);
                Game.menuState = new MenuState(handler);
                State.setState(handler.getGame().menuState);
            }
        }));
        uimanager.addObject(new UIImageButton(30, 90, 64, 64, Assets.addcar, new ClickListener(){
            @Override
            public void onClick() {
                String[] arg= {"slfj","sldfkjsd"};
                OOP.play(arg);
            }
        }));
    }

    @Override
    public void tick() {
        uimanager.tick();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.backgroundop, 0, 0, handler.getGame().getWidth(), handler.getGame().getHeight(), null);
        uimanager.render(g);
    }
    
}
