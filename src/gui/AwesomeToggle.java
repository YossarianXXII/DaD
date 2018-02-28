package gui;

import de.jensd.fx.glyphs.GlyphIcon;
import de.jensd.fx.glyphs.GlyphIcons;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;

import java.awt.event.ActionEvent;
import java.beans.EventHandler;

public class AwesomeToggle extends ToggleButton {



    public AwesomeToggle(String action, GlyphIcon icon){
        super();
//        this.getStyleClass().setAll("font-awesome-radio");
        this.setGraphic(icon);
        setId(action);

    }


}
