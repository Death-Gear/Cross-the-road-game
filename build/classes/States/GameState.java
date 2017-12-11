package States;


import Entities.Player;
import Mains.World;
import Mains.Handler;
import States.State;
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
public class GameState extends State {
    
    private World world;

    public GameState(Handler handler) {
        super(handler);
        world = new World(handler, "lib/res/worlds/world1.txt");
        handler.setWorld(world);
    }

    @Override
    public void tick() {
        world.tick();
    }

    @Override
    public void render(Graphics g) {     
        world.render(g);
        g.setColor(Color.GREEN);
        int fontSize = 30;
        g.setFont(new Font("Times New Roman",Font.PLAIN, fontSize));
        g.drawString("Score: " + Player.getStr(), 450, 30);
    }
    
}
