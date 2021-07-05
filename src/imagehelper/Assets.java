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
public class Assets {
    public static BufferedImage water,water1,dirt,grass,sand,tree,road,background,backgroundop,gameover,boat;
    public static BufferedImage[] player_up,player_down,player_left,player_right,car;
    public static BufferedImage[] play,option,back,addcar;
    private static final int width= 64,height= 64;
    private static final int cwidth= 630, cheight= 564;
    public static void init(){
//        final String dir = System.getProperty("user.dir");
//        System.out.println("current dir = " + dir);
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet.png"));
        player_up=new BufferedImage[9];
        player_down=new BufferedImage[9];
        player_left=new BufferedImage[9];
        player_right=new BufferedImage[9];
        car=new BufferedImage[15];
        play=new BufferedImage[2];
        option=new BufferedImage[2];
        back=new BufferedImage[2];
        addcar=new BufferedImage[2];
        for(int i=0; i<9; i++){
            player_up[i] = sheet.crop(width*i, 0, width, height);
        }
        for(int i=0; i<9; i++){
            player_left[i] = sheet.crop(width*i, height, width, height);
        }
        for(int i=0; i<9; i++){
            player_down[i] = sheet.crop(width*i, 2*height, width, height);
        }
        for(int i=0; i<9; i++){
            player_right[i] = sheet.crop(width*i, 3*height, width, height);
        }
        play[0]=ImageLoader.loadImage("/textures/play.png");
        play[1]=ImageLoader.loadImage("/textures/playhover.png");
        
        option[0]=ImageLoader.loadImage("/textures/option.png");
        option[1]=ImageLoader.loadImage("/textures/optionhover.png");
        
        back[0]=ImageLoader.loadImage("/textures/back.png");
        back[1]=ImageLoader.loadImage("/textures/backhover.png");
        
        addcar[0]=ImageLoader.loadImage("/textures/addcar.png");
        addcar[1]=ImageLoader.loadImage("/textures/addcarhover.png");
        
        sheet = new SpriteSheet(ImageLoader.loadImage("/textures/car.png"));
        car[0] = sheet.crop(23, 23, 128, 68);
        car[2] = sheet.crop(168, 23, 128, 68);
        car[4] = sheet.crop(316, 25, 132, 68);
        car[6] = sheet.crop(491, 157, 100, 64);
        car[8] = sheet.crop(29, 240, 128, 72);
        car[10] = sheet.crop(335, 233, 132, 78);
        car[12] = sheet.crop(479, 243, 116, 68);
        car[14] = sheet.crop(483, 349, 132, 84);
        
        
        sheet = new SpriteSheet(ImageLoader.loadImage("/textures/carflip.png"));
        car[1] = sheet.crop(159, 131, 138, 88);
        car[3] = sheet.crop(311, 141, 136, 78);
        car[5] = sheet.crop(463, 115, 146, 104);
        car[7] = sheet.crop(24, 23, 136, 70);
        car[9] = sheet.crop(309, 227, 140, 84);
        car[11] = sheet.crop(159, 339, 292, 94);
        car[13] = sheet.crop(316, 456, 230, 92);
        
        boat = ImageLoader.loadImage("/textures/boat.png");
        
        background = ImageLoader.loadImage("/textures/background.png");
        backgroundop = ImageLoader.loadImage("/textures/backgroundop.jpg");
        gameover = ImageLoader.loadImage("/textures/gameover.jpg");
        dirt = ImageLoader.loadImage("/textures/dirt.jpg");
        grass = ImageLoader.loadImage("/textures/grass.jpg");
        water = ImageLoader.loadImage("/textures/water1.png");
        water1= ImageLoader.loadImage("/textures/water.jpg");
        tree = ImageLoader.loadImage("/textures/tree.png");
        road = ImageLoader.loadImage("/textures/road.png");
        sand = ImageLoader.loadImage("/textures/sand.jpg");
    }
    
}
