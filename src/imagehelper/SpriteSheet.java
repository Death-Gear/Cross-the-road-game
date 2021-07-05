package imagehelper;


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
public class SpriteSheet {
    private BufferedImage sheet;
    public SpriteSheet(BufferedImage sheet){
        this.sheet=sheet;
    }
    public BufferedImage crop(int x, int y, int width, int height){
        return sheet.getSubimage(x, y, width, height);
    }
    
}
