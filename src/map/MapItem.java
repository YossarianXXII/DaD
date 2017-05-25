/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import java.io.File;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import main.GlobalState;

/**
 *  
 * @author szeman
 * 
 * 
 */
public class MapItem {
    Canvas canvas;
    Image image;
    double x;
    double y;
    
    int type;

    MapItem() {
        
    }

    MapItem(double x, double y, Pane pane) {
        this.x = x; this.y = y;
        Canvas c = new Canvas();
        c.setOnMousePressed(e->{
            if(GlobalState.isDeleteItemRadioSelected){
               pane.getChildren().remove(c);
            }
        });
        c.setHeight(64);
        c.setWidth(64);
        
        c.setLayoutX(x-32);
        c.setLayoutY(y-32);
        GraphicsContext gc = c.getGraphicsContext2D();
        System.out.println(x + "x" + y);
        File f = new File("01.png");
        Image i = new Image("file:"+f.getName());
        
        gc.drawImage(i, 0, 0, 64, 64);
//        gc.drawImage(i, 0, 0);
        
        
        pane.getChildren().add(c); 
    }
    
    
    
}
