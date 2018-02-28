/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import main.DrawingState;
import main.GlobalState;

/**
 *  
 * @author szeman
 * 
 * 
 */
public class MapItem extends Pane{
    private Canvas canvas;

    int type;
    boolean isSelected;
    MapItem() {
        
    }

    MapItem(double x, double y, Pane pane, Image im) {
        // Sets the new item to be centered on where mouse click occured
        this.setLayoutX(x-DrawingState.getScale()/2);
        this.setLayoutY(y-DrawingState.getScale()/2);
        canvas = new Canvas();
        pane.getChildren().add(this); 
        this.getChildren().add(canvas);

        this.setOnMousePressed((MouseEvent e) -> {
            switch (((RadioButton) GlobalState.selectedTool).getId()) {
                case "Delete":
                    pane.getChildren().remove(MapItem.this);
                    e.consume();

                    break;
                case "Select":
                    if (!isSelected) {
                        canvas.setStyle("-fx-effect: innershadow(gaussian, #039ed3, 10, 1.0, 0, 0);");
                        isSelected = true;
                    } else {
                        canvas.setStyle("");
                        isSelected = false;
                    }

                    break;
                case "Move":
                    this.setOnMouseDragged(m -> {
                        this.setLayoutY(m.getScreenY() - this.getScene().getWindow().getY());
                    });
                    break;
            }
        });
        this.setOnMouseReleased((MouseEvent event) -> this.setOnMouseDragged(null));

        canvas.setHeight(64);
        canvas.setWidth(64);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.drawImage(im, 0, 0, DrawingState.getScale(), DrawingState.getScale());

        
        
        
    }
    
   
    
    
    
}
