/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import Entities.CustomCar;
/**
 *
 * @author Risad
 */
public class OOP extends Application {
   
    ImageView myImageView;
    @Override
    public void start(Stage primaryStage) {
         Button btnLoad = new Button("Load");
        btnLoad.setOnAction(btnLoadEventListener);
         
        myImageView = new ImageView();        
         
        VBox rootBox = new VBox();
        rootBox.getChildren().addAll(btnLoad, myImageView);
         
        Scene scene = new Scene(rootBox, 300, 300);
         
        primaryStage.setTitle("Add your own car");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static BufferedImage img;
    private static int indx=-1;

    public static int getIndx() {
        return indx;
    }

    public static void setIndx(int indx) {
        OOP.indx = indx;
    }

    
    

    public static void play(String[] args){
        launch(args);
    }

    public static BufferedImage getImg() {
        return img;
    }
    EventHandler<ActionEvent> btnLoadEventListener
    = new EventHandler<ActionEvent>(){
 
        @Override
        public void handle(ActionEvent t) {
            FileChooser fileChooser = new FileChooser(); 
            //Set extension filter
            FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
              
            //Show open file dialog
            File file = fileChooser.showOpenDialog(null);        
            try {
                img = ImageIO.read(file);
                indx++;
                CustomCar.cars.add(img);
                Image image = SwingFXUtils.toFXImage(img, null);
                myImageView.setImage(image);
            } catch (IOException ex) {
                //Logger.getLogger(JavaFXPixel.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex);
            }
        }
    };
    
}
