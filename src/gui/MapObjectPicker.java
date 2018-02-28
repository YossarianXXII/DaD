package gui;

import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;

import java.io.File;

public class MapObjectPicker extends HBox{
    private ToggleGroup toggleGroup = new ToggleGroup();

    public MapObjectPicker() {
        this.setOnScroll(event -> {
            int current = toggleGroup.getToggles().indexOf(toggleGroup.getSelectedToggle());
            int next;
            if(event.getTextDeltaY()<0) {
                next = (current + 1) % toggleGroup.getToggles().size();
            }
            else{
                next = Math.abs(current - 1 + toggleGroup.getToggles().size()) % toggleGroup.getToggles().size();
            }
            toggleGroup.selectToggle(toggleGroup.getToggles().get(next));
        });
    }

    public void initialize(){
        File f = new File("MapObjects");
        final File[] files = f.listFiles();
        if (files != null) {
            for(File i: files){
                System.out.println("Loading image: " + i.getAbsolutePath());
                Image image = new Image("file:"+i.getAbsolutePath());

                ObjectPickerItem item = new ObjectPickerItem();
                item.initialize(image);
                toggleGroup.getToggles().add(item);
                this.getChildren().add(item);
            }
        }
    }


    public Image getSelected(){
        return ((ObjectPickerItem)this.toggleGroup.getSelectedToggle()).getImage();
    }




}
