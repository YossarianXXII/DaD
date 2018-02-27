package gui;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ObjectPickerItem extends ToggleButton{
    private static final double OBJECT_PICKER_HEIGHT = 32;
    private static final double OBJECT_PICKER_WIDTH = 32;

    Canvas canvas = new Canvas();
    ObjectPickerItem(){

    }


    public void initialize(Image image){

        ImageView imageView = new ImageView();
        imageView.setFitHeight(32);
        imageView.setFitWidth(32);
        imageView.setImage(image);
        this.setGraphic(imageView);
    }
}
