package managers;


import mainutils.Handler;
import uiclass.UIObject;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Risad
 */
public class UIManager {
    private Handler handler;
    private ArrayList<UIObject> objects=new ArrayList<UIObject>();
    public UIManager(Handler handler){
        this.handler=handler;
        //objects=new ArrayList<UIObject>();
    }
    
    public void tick(){
        for(UIObject o : objects){
            o.tick();
        }
    }
    
    public void render(Graphics g){
        for(UIObject o : objects){
            o.render(g);
        }
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ArrayList<UIObject> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<UIObject> objects) {
        this.objects = objects;
    }
    
    
    
    public void onMouseMove(MouseEvent e){
        for(UIObject o : objects){
            o.onMouseMove(e);
        }
    }
    
    public void onMouseRelease(MouseEvent e){
        for(UIObject o : objects){
            o.onMouseRelease(e);
        }
    }
    
    public void addObject(UIObject o){
        objects.add(o);
    }
    
    public void removeObject(UIObject o){
        objects.remove(o);
    }
}
