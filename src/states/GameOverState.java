package states;


import mainutils.Handler;
import mainutils.Game;
import imagehelper.Assets;
import entities.Player;
import managers.ClickListener;
import uiclass.UIImageButton;
import managers.UIManager;

import java.awt.Color;
import java.awt.Font;
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
public class GameOverState extends State{

    private UIManager uiManager;
    public GameOverState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUIManager(uiManager);
        
        this.uiManager.addObject(new UIImageButton(handler.getGame().getWidth()/2-50, 300, 128, 64, Assets.play, new ClickListener(){
            @Override
            public void onClick() {
                handler.getMouseManager().setUIManager(null);    
                Game.gameState = new GameState(handler);
                State.setState(handler.getGame().gameState);
            }
        }));
        this.uiManager.addObject(new UIImageButton(30, 30, 64, 64, Assets.back, new ClickListener(){
            @Override
            public void onClick() {
                handler.getMouseManager().setUIManager(null);
                Game.menuState = new MenuState(handler);
                State.setState(handler.getGame().menuState);
            }
        }));
    }

    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.gameover, 0, 0, handler.getGame().getWidth(), handler.getGame().getHeight(), null);
        uiManager.render(g);
        int fontSize = 50;
        g.setColor(Color.RED);
        g.setFont(new Font("Times New Roman",Font.PLAIN, fontSize));
        g.drawString("Your Score is "+Player.getStr(), 150, 100);
    }
    
}
