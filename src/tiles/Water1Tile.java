/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiles;

import imagehelper.Assets;

/**
 *
 * @author Risad
 */
public class Water1Tile extends Tile{
    
    public Water1Tile(int id) {
        super(Assets.water1, id);
    }
    @Override
    public boolean isSolid(){
        return true;
    }
    
}
