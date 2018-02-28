package gui;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ObjectPickerItem extends ToggleButton{
    private static final double OBJECT_PICKER_HEIGHT = 64;
    private static final double OBJECT_PICKER_WIDTH = 64;

    private Image image;


    public void initialize(Image image){
        this.image = image;
        ImageView imageView = new ImageView();
        imageView.setFitHeight(OBJECT_PICKER_HEIGHT);
        imageView.setFitWidth(OBJECT_PICKER_WIDTH);
        imageView.setImage(image);
        this.setGraphic(imageView);
    }

    public Image getImage(){
        return image;
    }
}
