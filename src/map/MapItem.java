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
        Canvas c = new Canvas();
        pane.getChildren().add(this); 
        this.getChildren().add(c);
        
        c.setOnMousePressed((MouseEvent e) -> {
            if (((RadioButton)GlobalState.selectedTool).getId().equals("deleteItemRadio")) {
                pane.getChildren().remove(MapItem.this);
            } else if(((RadioButton)GlobalState.selectedTool).getId().equals("selectItemRadio")){
                if(!isSelected){
                    c.setStyle("-fx-effect: innershadow(gaussian, #039ed3, 10, 1.0, 0, 0);");
                    isSelected=true;
                }else
                {
                    c.setStyle("");
                    isSelected=false;
                }
                
            }
        });
//        c.setOnMouseDragged((MouseEvent m)->{
////            System.out.println(  ((Canvas)(m.getSource()))   );
//                    
//                    c.setLayoutY(m.getScreenY()-c.getScene().getWindow().getY());
//                });
        c.setHeight(64);
        c.setWidth(64);
        
//        c.setLayoutX(x-32);
//        c.setLayoutY(y-32);
        GraphicsContext gc = c.getGraphicsContext2D();
        System.out.println(x + "x" + y);
        File f = new File("01.png");
        image = new Image("file:"+f.getName());
        
        gc.drawImage(image, 0, 0, 64, 64);

        
        
        
    }
    
   
    
    
    
}
