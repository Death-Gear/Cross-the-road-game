package States;



import Mains.Handler;
import Mains.Game;
import ImageHelper.Assets;
import Managers.ClickListener;
import UIclass.UIImageButton;
import Managers.UIManager;
import States.SettingsState;
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
public class MenuState extends State{
    
    private UIManager uiManager;
    
    public MenuState(Handler handler){
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUIManager(uiManager);
        
        this.uiManager.addObject(new UIImageButton(handler.getGame().getWidth()/2-50, 100, 128, 64, Assets.play, new ClickListener(){
            @Override
            public void onClick() {
                handler.getMouseManager().setUIManager(null);    
                Game.gameState = new GameState(handler);
                State.setState(handler.getGame().gameState);
            }
        }));
        this.uiManager.addObject(new UIImageButton(handler.getGame().getWidth()/2-50, 200, 128, 64, Assets.option, new ClickListener(){
            @Override
            public void onClick() {
                handler.getMouseManager().setUIManager(null);
                Game.settingsState = new SettingsState(handler);
                State.setState(handler.getGame().settingsState);
            }
        }));
    }

    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.background, 0, 0, handler.getGame().getWidth(), handler.getGame().getHeight(), null);
        uiManager.render(g);
    }
    
}
