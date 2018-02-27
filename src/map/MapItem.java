/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import java.io.File;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import main.GlobalState;

/**
 *  
 * @author szeman
 * 
 * 
 */
public class MapItem extends Pane{
    Canvas canvas;
    Image image;
//    double x;
//    double y;
    
    int type;
    boolean isSelected;
    MapItem() {
        
    }

    MapItem(double x, double y, Pane pane) {
        this.setLayoutX(x-32);  this.setLayoutY(y-32);
        canvas = new Canvas();
        pane.getChildren().add(this); 
        this.getChildren().add(canvas);

        canvas.setOnMousePressed((MouseEvent e) -> {
            if (((RadioButton)GlobalState.selectedTool).getId().equals("Delete")) {
                pane.getChildren().remove(MapItem.this);
            } else if(((RadioButton)GlobalState.selectedTool).getId().equals("Select")){
                if(!isSelected){
                    canvas.setStyle("-fx-effect: innershadow(gaussian, #039ed3, 10, 1.0, 0, 0);");
                    isSelected=true;
                }else
                {
                    canvas.setStyle("");
                    isSelected=false;
                }
                
            }
        });
        canvas.setOnMouseDragged((MouseEvent m)->{
                    canvas.setLayoutY(m.getScreenY()-canvas.getScene().getWindow().getY());
                });
        canvas.setHeight(32);
        canvas.setWidth(32);
        
//        c.setLayoutX(x-32);
//        c.setLayoutY(y-32);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        File f = new File("MapObjects/Castle.png");
        image = new Image("file:"+f.getAbsolutePath());
        gc.drawImage(image, 0, 0, 32, 32);

        
        
        
    }
    
   
    
    
    
}
