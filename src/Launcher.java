
import mainutils.Game;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Risad
 */
public class Launcher {
    public static void main(String[] args){
//        final String dir = System.getProperty("user.dir");
//        System.out.println("current dir = " + dir);
        Game game = new Game("Help The Blind Man!!!",620,420);
        game.start();
    }
    
}
